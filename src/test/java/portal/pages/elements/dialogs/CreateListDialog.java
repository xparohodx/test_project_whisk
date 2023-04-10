package portal.pages.elements.dialogs;

import io.qameta.allure.Step;
import portal.pages.BasePage;

public class CreateListDialog extends BasePage {
    private String container = "//div[@class='s11400']";
    private String inputName = "//input[@name='name']";
    private String buttonCreate = "//button[@data-testid='create-new-shopping-list-create-button']";
    private String buttonCancel = "//button[@data-testid='create-new-shopping-list-cancel-button']";

    public CreateListDialog() {
        waitPageForLoad();
    }

    @Step("Assert that 'Create list' dialog is visible")
    public CreateListDialog isVisible() {
        assert $(container).isDisplayed();
        return this;
    }

    @Step("Fill list name input")
    public CreateListDialog fillInputListName(String name) {
        $(inputName).click();
        $(inputName).sendKeys(name);
        return this;
    }

    @Step("Click on 'Create' button")
    public CreateListDialog clickButtonCreate() {
        $(buttonCreate).click();
        waitForElementIsHidden($(buttonCreate));
        return this;
    }
}
