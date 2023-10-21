package Forms;

import Framework.BaseForm;
import Framework.Button;
import Framework.Utils.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WebTablesForm extends BaseForm {

    private final Button webTablesButton = new Button(By.xpath("//*[text()='Web Tables']"),
            "webTablesButton");
    private final Button addButton = new Button(By.id("addNewRecordButton"), "addButton");

    public WebTablesForm() {
        super(By.className("ReactTable"), "webTablesForm");
    }

    public void clickWebTablesButton() {
        webTablesButton.scrollTo().click();
    }

    public void clickAddButton() {
        addButton.scrollTo().click();
    }

    public List<String> getTableText() {
        List<String> list = new ArrayList<>();
        List<WebElement> table = SingletonBrowser.getDriver().findElements(By.className("rt-td"));
        for (WebElement entry : table) {
            if (!entry.getText().isBlank()) {
                list.add(entry.getText());
            }
        }
        return list;
    }

    public void deleteLastEntry() {
        int lastEntryNum = SingletonBrowser.getDriver().findElements(By.className("action-buttons")).size();
        Button lastEntryButton = new Button(By.id("delete-record-" + lastEntryNum), "lastEntryButton");
        lastEntryButton.scrollTo().click();
    }
}
