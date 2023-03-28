package Framework.Utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Browser {

    public static void goToUrl(String url) {
        log.info("Going to url: {}", url);
        SingletonBrowser.getDriver().get(url);
    }

    public static void switchToFrame(WebElement frame) {
        SingletonBrowser.getDriver().switchTo().frame(frame);
    }

    public static void switchToDefault() {
        SingletonBrowser.getDriver().switchTo().defaultContent();
    }

    public static void switchToTab(int num) {
        List<String> tabs = new ArrayList<>(SingletonBrowser.getDriver().getWindowHandles());
        if (tabs.size() > 1 && num <= tabs.size()) {
            SingletonBrowser.getDriver().switchTo().window(tabs.get(num - 1));
        }
    }

    public static void closeTab() {
        List<String> tabs = new ArrayList<>(SingletonBrowser.getDriver().getWindowHandles());
        if (tabs.size() > 1) {
            SingletonBrowser.getDriver().close();
            SingletonBrowser.getDriver().switchTo().window(tabs.get(0));
        }
    }

    public static void quitBrowser() {
        log.info("Quitting browser");
        SingletonBrowser.quitBrowser();
    }

    public static void maximize() {
        SingletonBrowser.getDriver().manage().window().maximize();
    }

    public static boolean hasNoAlerts() {
        try {
            SingletonBrowser.getDriver().switchTo().alert();
        } catch (NoAlertPresentException e) {
            return true;
        }
        return false;
    }

    public static String getAlertText() {
        return SingletonBrowser.getDriver().switchTo().alert().getText();
    }

    public static void putAlertText(String text) {
        SingletonBrowser.getDriver().switchTo().alert().sendKeys(text);
    }

    public static void acceptAlert() {
        SingletonBrowser.getDriver().switchTo().alert().accept();
    }

    public static void executeScript(String script, Object... args) {
        ((JavascriptExecutor) SingletonBrowser.getDriver()).executeScript(script, args);
    }
}
