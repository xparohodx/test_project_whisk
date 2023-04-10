package portal.pages;

import io.qameta.allure.Step;

public class MainPage extends BasePage {

    protected String url = baseURL;
    public String buttonSignupLogin = "//button//div[@class='s11206']";

    @Step("Open main page")
    public MainPage openPage() {
        this.openPageByURL(url);
        return this;
    }

    @Step("Click on 'Sign Up' button")
    public MainPage clickButtonSignup() {
        $(buttonSignupLogin).click();
        return this;
    }

}
