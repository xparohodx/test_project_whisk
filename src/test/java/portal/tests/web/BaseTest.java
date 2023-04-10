package portal.tests.web;

import org.testng.annotations.AfterMethod;
import portal.utils.browsers.BrowserHolder;

public class BaseTest {

    @AfterMethod(alwaysRun = true)
    void teardown() {
        if (BrowserHolder.isBrowserCreated()) {
            BrowserHolder.quit();
        }
    }


}
