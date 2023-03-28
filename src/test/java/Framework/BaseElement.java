package Framework;

import Framework.Utils.Browser;
import Framework.Utils.WaitUtil;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Slf4j
public abstract class BaseElement {
    private final By uniqueLocator;
    private final String elementName;

    public BaseElement(By locator, String name) {
        uniqueLocator = locator;
        elementName = name;
    }

    public WebElement getElement() {
        return WaitUtil.waitForPresence(uniqueLocator);
    }

    public BaseElement scrollTo() {
        Browser.executeScript("arguments[0].scrollIntoView(true);", WaitUtil.waitForPresence(uniqueLocator));
        return this;
    }

    public void click() {
        log.info("Clicking element: {}", elementName);
        WaitUtil.waitElementToBeClickable(uniqueLocator).click();
    }

    public String getElementName() {
        return elementName;
    }
}
