package Forms;

import Framework.BaseForm;
import Framework.IFrame;
import org.openqa.selenium.By;

public class FramesForm extends BaseForm {

    public final NavigationBar navigationBar = new NavigationBar();

    private final IFrame upperFrame = new IFrame(By.id("frame1"), "upperFrame");

    private final IFrame lowerFrame = new IFrame(By.id("frame2"), "lowerFrame");

    public FramesForm() {
        super(By.id("frame2"), "framesForm");
    }

    public String getUpperFrameText() {
        return upperFrame.getFrameText();
    }

    public String getLowerFrameText() {
        return lowerFrame.getFrameText();
    }
}
