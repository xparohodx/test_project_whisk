package portal.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import portal.utils.browsers.BrowserHolder;

public class TestListener implements ITestListener {

    @Attachment(value = "Page screenshot", type = "image/png", fileExtension = ".png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        //Object testClass = iTestResult.getInstance();
        WebDriver driver = BrowserHolder.getBrowser().getDriver();
        if (driver instanceof WebDriver) {
            saveScreenshotPNG(driver);
        }
    }
}
