package Framework;

import Framework.Utils.Browser;
import Framework.Utils.SingletonBrowser;
import org.openqa.selenium.By;

public class IFrame extends BaseElement {
    public IFrame(By locator, String name) {
        super(locator, name);
    }

    public void switchTo() {
        Browser.switchToFrame(getElement());
    }

    public String getFrameText() {
        String text;
        switchTo();
        text = SingletonBrowser.getDriver().findElement(By.tagName("body")).getText();
        Browser.switchToDefault();
        return text;
    }
}
