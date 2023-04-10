package portal.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingListPage extends BasePage {

    private String url = baseURL + "/shopping-list/";
    private String buttonCreateNewList = "//div[@class='s11268']";
    private String containerOfShoppingLists = "//div[@class='s-d01wko hoFZKh']";
    private String inputAddItem = "//input[@placeholder='Add item']";
    private String buttonDeleteList = "//button[@data-testid='shopping-list-delete-menu-button']";
    private String alertListDeleted = "//span[text()='List was deleted']";
    private String containerOfSingleShoppingList = "//div[@class='s-1bihe2z jtfYez']";

    public ShoppingListPage() {

    }

    @Step("Open Shopping list page")
    public ShoppingListPage openPage() {
        this.openPageByURL(url);
        return this;
    }

    @Step("Click on button 'Create new list'")
    public ShoppingListPage clickButtonCreateNewList() {
        assert $(containerOfShoppingLists).isDisplayed();
        $(containerOfShoppingLists).click();
        $(buttonCreateNewList).click();
        return this;
    }

    @Step("Click on list with given name")
    public ShoppingListPage selectCreatedList(String locator) {
        waitForElementIsVisible($("//div[contains(text(), '" + locator + "')]"));
        $("//div[contains(text(), '" + locator + "')]").click();
        return this;
    }

    @Step("Click on actions button for list with given name")
    public ShoppingListPage clickActionsButtonForList(String listName) {
        String locator = "//div[contains(text(), '" + listName + "')]/parent::div/following-sibling::div//div[@class='s24']";
        waitForElementIsVisible($(locator));
        $(locator).click();
        return this;
    }

    @Step("Assert that Shopping list was deleted")
    public ShoppingListPage assertThatListWasDeleted(String expected) {
        List<WebElement> list = this.browser.getDriver().findElements(By.xpath(containerOfSingleShoppingList));
        String currentFirstList = list.get(0).getText();
        assert !currentFirstList.contains(expected);
        return this;
    }

    @Step("Fill 'Add item' input with given value")
    public ShoppingListPage findAndAddItem(String item) {
        $(inputAddItem).sendKeys(item);
        $(inputAddItem).sendKeys(Keys.ENTER);
        waitForElementIsHidden($("//div[@data-testid='desktop-add-item-autocomplete']"));
        return this;
    }

    @Step("Check that item with given name was added in shopping list")
    public ShoppingListPage assertItemInList(String item) {
        String locatorText = capitalizeFirstLetter(item);
        assert $("//span[@data-testid='shopping-list-item-name'][contains(text(), '" + locatorText + "')]").isDisplayed();
        return this;
    }

    //Additional function for capitalizing first letter in the name of item
    private String capitalizeFirstLetter(String input) {
        String output = input.substring(0, 1).toUpperCase() + input.substring(1);
        return output;
    }

    @Step("Click on 'Delete' button in list actions menu")
    public ShoppingListPage clickButtonDeleteList() {
        $(buttonDeleteList).click();
        waitForElementIsHidden($(buttonDeleteList));
        return this;
    }

    @Step("Click on alert 'Shopping list was deleted'")
    public ShoppingListPage clickAlertListDeleted() {
        $(alertListDeleted).click();
        return this;
    }
}
