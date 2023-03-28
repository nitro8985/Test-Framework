package Forms;

import Framework.BaseForm;
import Framework.IFrame;
import org.openqa.selenium.By;

import java.util.List;

public class NestedFramesForm extends BaseForm {

    public final NavigationBar navigationBar = new NavigationBar();

    private final IFrame outerFrame = new IFrame(By.id("frame1"), "outerFrame");

    public NestedFramesForm() {
        super(By.id("frame1"), "nestedFramesForm");
    }

    public String getOuterFrameText() {
        return outerFrame.getFrameText();
    }

    public String getInnerFrameText() {
        outerFrame.switchTo();
        IFrame innerFrame = new IFrame(By.tagName("IFRAME"), "innerFrame");
        return innerFrame.getFrameText();
    }

    public List<String> getFramesTextAsList() {
        return List.of(getOuterFrameText(), getInnerFrameText());
    }
}
