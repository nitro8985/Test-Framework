package Forms;

import Framework.BaseForm;
import Framework.Button;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {

    private final Button alertsFrameAndWindowsButton = new Button(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]"),
            "alertsFrameAndWindows");
    private final Button elementsButton = new Button(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]"),
            "elementsButton");

    public MainPage() {
        super(By.className("home-banner"), "mainPage");
    }

    public void clickAlertsFrameAndWindows() {
        alertsFrameAndWindowsButton.scrollTo().click();
    }

    public void clickElements() {
        elementsButton.scrollTo().click();
    }
}
