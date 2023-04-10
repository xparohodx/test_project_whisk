package portal.pages.elements.sections;

import io.qameta.allure.Step;
import portal.pages.BasePage;

public class HeaderSection extends BasePage {
    private String buttonAvatar = "//button[@data-testid='avatar-button']";
    private String linkShopping = "//a[@href='/shopping-list']";

    @Step("Assert that user menu button is visible")
    public HeaderSection menuButtonIsVisible() {
        $(buttonAvatar).isDisplayed();
        return this;
    }

    @Step("Click on Shopping link")
    public HeaderSection clickLinkShopping() {
        $(linkShopping).click();
        return this;
    }


}
