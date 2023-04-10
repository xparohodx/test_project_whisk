package portal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import portal.utils.browsers.Browser;
import portal.utils.browsers.BrowserHolder;
import portal.utils.configReader.ConfigFileReader;
import portal.utils.suppliers.PageObjectSupplier;

public class BasePage implements PageObjectSupplier {
    Browser browser;
    protected String baseURL = new ConfigFileReader().getWebURL();
    private long baseTimeout = new ConfigFileReader().getTimeout();
    private String pageContainer = "//div[@id='app']";

    protected void openPageByURL(String url) {
        this.browser = BrowserHolder.getBrowser();
        this.browser.getDriver().get(url);
        waitPageForLoad();
    }

    public void waitPageForLoad() {
        this.browser = BrowserHolder.getBrowser();
        WebDriverWait wait = new WebDriverWait(this.browser.getDriver(), baseTimeout * 2);
        wait.until(ExpectedConditions.visibilityOf($(pageContainer)));
        $(pageContainer).click();
    }

    public void waitForElementIsVisible(WebElement locator) {
        new WebDriverWait(this.browser.getDriver(), baseTimeout).until(ExpectedConditions.visibilityOf(locator));
    }

    public void waitForElementIsHidden(WebElement locator) {
        new WebDriverWait(this.browser.getDriver(), baseTimeout).until(ExpectedConditions.invisibilityOf(locator));
    }

    public WebElement $(String locator) {
        this.browser = BrowserHolder.getBrowser();
        return browser.getDriver().findElement(By.xpath(locator));
    }
}
