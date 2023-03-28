package Forms;

import Framework.BaseForm;
import Framework.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class NavigationBar extends BaseForm {

    private final Button alertsMenuButton = new Button(RelativeLocator.with(By.id("item-1")).
            below(By.className("navbar")).below(By.className("element-group")).below(By.className("element-group")),
            "alertsMenuButton");
    private final Button nestedFramesMenuButton = new Button(RelativeLocator.with(By.id("item-3")).
            below(By.className("navbar")).below(By.className("element-group")).below(By.className("element-group")),
            "nestedFramesMenuButton");
    private final Button framesMenuButton = new Button(RelativeLocator.with(By.id("item-2")).
            below(By.className("navbar")).below(By.className("element-group")).below(By.className("element-group")),
            "framesMenuButton");
    private final Button browserWindowsMenuButton = new Button(RelativeLocator.with(By.id("item-0")).
            below(By.className("navbar")).below(By.className("element-group")).below(By.className("element-group")),
            "browserWindowsMenuButton");
    private final Button elementsButton = new Button(RelativeLocator.with(By.className("element-group")).
            near(By.className("navbar")), "elementsButton");

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
