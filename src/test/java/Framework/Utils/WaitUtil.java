package Framework.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

    private static final Duration duration = Duration.ofSeconds(DataUtil.getConfig().get("wait_duration").asInt());

    public static WebElement waitForPresence(By locator) {
        return new WebDriverWait(SingletonBrowser.getDriver(), duration).
                until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitElementToBeClickable(By locator) {
        return new WebDriverWait(SingletonBrowser.getDriver(), duration).
                until(ExpectedConditions.elementToBeClickable(locator));
    }
}
