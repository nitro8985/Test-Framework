package Forms;

import Framework.BaseForm;
import org.openqa.selenium.By;

public class SamplePage extends BaseForm {

    public SamplePage() {
        super(By.id("sampleHeading"), "samplePage");
    }
}
