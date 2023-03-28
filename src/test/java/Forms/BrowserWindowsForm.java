package Forms;

import Framework.BaseForm;
import Framework.Button;
import org.openqa.selenium.By;

public class BrowserWindowsForm extends BaseForm {

    public final NavigationBar navigationBar = new NavigationBar();

    private final Button newTabButton = new Button(By.id("tabButton"), "tabButton");

    public BrowserWindowsForm() {
        super(By.id("browserWindows"), "browserWindowsForm");
    }

    public void clickNewTabButton() {
        newTabButton.scrollTo().click();
    }
}
