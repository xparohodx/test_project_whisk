package portal.pages.elements.dialogs;

import io.qameta.allure.Step;
import portal.pages.BasePage;

public class DeleteListDialog extends BasePage {
    private String container = "//div[@class='s11400']";
    private String buttonConfirmDelete = "//button[@data-testid='confirm-delete-button']";


    public DeleteListDialog() {
        waitPageForLoad();
    }

    @Step("Assert that 'Delete list' dialog is visible")
    public DeleteListDialog isVisible() {
        assert $(container).isDisplayed();
        return this;
    }

    @Step("Tap on 'Delete' button in list actions menu")
    public DeleteListDialog clickButtonConfirmDeleteList() {
        $(buttonConfirmDelete).click();
        waitForElementIsHidden($(buttonConfirmDelete));
        return this;
    }
}
