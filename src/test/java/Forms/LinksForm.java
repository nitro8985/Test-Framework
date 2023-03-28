package Forms;

import Framework.BaseForm;
import Framework.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class LinksForm extends BaseForm {

    private final Button linksButton = new Button(RelativeLocator.with(By.id("item-5")).below(By.className("navbar")),
            "linksButton");
    private final Button homeLink = new Button(By.id("simpleLink"), "homeLink");

    public LinksForm() {
        super(By.id("linkWrapper"), "linksForm");
    }

    public void clickLinksButton() {
        linksButton.scrollTo().click();
    }

    public void clickHomeLink() {
        homeLink.scrollTo().click();
    }
}
