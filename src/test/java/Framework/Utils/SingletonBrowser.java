package Framework.Utils;

import org.openqa.selenium.WebDriver;

public class SingletonBrowser {

    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = BrowserFactory.initDriver();
        }
        return driver;
    }

    public static void quitBrowser() {
        driver.quit();
        driver = null;
    }
}
