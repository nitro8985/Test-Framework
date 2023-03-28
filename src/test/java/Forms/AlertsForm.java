package Forms;

import Framework.BaseForm;
import Framework.Button;
import Framework.Label;
import org.openqa.selenium.By;

public class AlertsForm extends BaseForm {

    public final NavigationBar navigationBar = new NavigationBar();
    private final Button alertButton = new Button(By.id("alertButton"), "alertButton");
    private final Button confirmButton = new Button(By.id("confirmButton"), "confirmButton");
    private final Button promptBoxButton = new Button(By.id("promtButton"), "promptBoxButton");
    private final Label confirmResult = new Label(By.id("confirmResult"), "confirmResult");
    private final Label promptResult = new Label(By.id("promptResult"), "promptResult");

    public AlertsForm() {
        super(By.id("javascriptAlertsWrapper"), "alertsForm");
    }

    public void clickAlertButton() {
        alertButton.scrollTo().click();
    }

    public void clickConfirmButton() {
        confirmButton.scrollTo().click();
    }

    public void clickPromptBoxButton() {
        promptBoxButton.scrollTo().click();
    }

    public String getConfirmResult() {
        return confirmResult.getText();
    }

    public String getPromptResult() {
        return promptResult.getText();
    }
}
