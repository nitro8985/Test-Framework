package Framework;

import Framework.Utils.SingletonBrowser;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@Slf4j
public abstract class BaseForm {
    private final By uniqueFormLocator;

    public BaseForm(By locator, String name) {
        log.info("Creating new form: {}", name);
        uniqueFormLocator = locator;
    }

    public boolean isOpen() {
        List<WebElement> list = SingletonBrowser.getDriver()
                .switchTo()
                .defaultContent()
                .findElements(uniqueFormLocator);
        return list.size() > 0;
    }
}
