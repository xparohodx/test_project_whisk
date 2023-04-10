package portal.pages.elements.dialogs;

import io.qameta.allure.Step;
import portal.pages.BasePage;

public class AuthorizationDialog extends BasePage {
    private String container = "//div[@data-testid='authentication-form']";
    private String inputUsername = "//input[@name='username']";
    private String inputPassword = "//input[@data-testid='UI_KIT_INPUT']";
    private String buttonConinue = "//button[@data-testid='auth-continue-button']";
    private String buttonLogin = "//button[@data-testid='auth-login-button']";

    @Step("Assert that Authorization dialog is visible")
    public AuthorizationDialog isVisible() {
        assert $(container).isDisplayed();
        return this;
    }

    @Step("Fill user email")
    public AuthorizationDialog fillInputUsername(String username) {
        $(inputUsername).sendKeys(username);
        return this;
    }
    @Step("Fill the password")
    public AuthorizationDialog fillInputPassword(String password) {
        $(inputPassword).sendKeys(password);
        return this;
    }
    @Step("Click on 'Continue' button")
    public AuthorizationDialog clickButtonContinue() {
        $(buttonConinue).click();
        waitForElementIsHidden($(buttonConinue));
        return this;
    }

    @Step("Click on 'Login' button")
    public AuthorizationDialog clickButtonLogin() {
        $(buttonLogin).click();
        waitForElementIsHidden(authorizationDialog().$(container));
        return this;
    }
}
