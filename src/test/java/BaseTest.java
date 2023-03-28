import Framework.Utils.Browser;
import Framework.Utils.DataUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    public void setupBrowser() {
        Browser.goToUrl(DataUtil.getConfig().get("url").asText());
        Browser.maximize();
    }

    @AfterMethod
    public void tearDown() {
        Browser.quitBrowser();
    }
}
