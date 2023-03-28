package Framework;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
public class TextBox extends BaseElement {

    public TextBox(By locator, String name) {
        super(locator, name);
    }

    public void putText(String text) {
        log.info("Entering text '{}' to {}", text, getElementName());
        getElement().sendKeys(text);
    }
}
