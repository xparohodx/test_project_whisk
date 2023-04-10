package portal.utils.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import portal.utils.configReader.ConfigFileReader;

public class Browser {

    protected WebDriver driver;

    public Browser() {
        this.getDriver();
    }

    public WebDriver getDriver() {

        String browserType = new ConfigFileReader().getBrowserType();
        if (this.driver == null) {
            if (browserType.contains("chrome")) {
                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver();
            }
            if (browserType.contains("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                this.driver = new FirefoxDriver();
            }
        }
        return this.driver;
    }


    public void quit() {
        try {
            this.driver.quit();
        } catch (Exception var1) {
        }

        this.driver = null;
    }
}
