package Forms;

import Framework.BaseForm;
import Framework.Button;
import org.openqa.selenium.By;

public class NavigationBar extends BaseForm {

    private final Button alertsMenuButton = new Button(By.xpath("//*[text()='Alerts']"),
            "alertsMenuButton");
    private final Button nestedFramesMenuButton = new Button(By.xpath("//*[text()='Nested Frames']"),
            "nestedFramesMenuButton");
    private final Button framesMenuButton = new Button(By.xpath("//*[text()='Frames']"),
            "framesMenuButton");
    private final Button browserWindowsMenuButton = new Button(By.xpath("//*[text()='Browser Windows']"),
            "browserWindowsMenuButton");
    private final Button elementsButton = new Button(By.xpath("//*[text()='Elements']"),
            "elementsButton");

    public NavigationBar() {
        super(By.className("left-pannel"), "navigationBar");
    }

    public void clickAlertsMenuButton() {
        alertsMenuButton.scrollTo().click();
    }

    public void clickNestedFramesMenuButton() {
        nestedFramesMenuButton.scrollTo().click();
    }

    public void clickFramesMenuButton() {
        framesMenuButton.scrollTo().click();
    }

    public void clickBrowserWindowsMenuButton() {
        browserWindowsMenuButton.scrollTo().click();
    }

    public void clickElementsButton() {
        elementsButton.scrollTo().click();
    }
}
