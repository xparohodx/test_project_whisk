package portal.pages.elements.alerts;

import io.qameta.allure.Step;
import portal.pages.BasePage;

public class SuccessfulLoginAlert extends BasePage {
    private String container = "//span[@class='s31']";

    @Step("Assert that Successful login alert is visible")
    public SuccessfulLoginAlert isVisible() {
        assert $(container).isDisplayed();
        return this;
    }

    @Step("Click on Successful login alert")
    public SuccessfulLoginAlert clickOnSuccessfulLoginAlert() {
        $(container).click();
        return this;
    }
}
