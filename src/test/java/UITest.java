import Forms.*;
import Framework.Utils.Browser;
import Framework.Utils.DataUtil;
import Models.UserData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

@Slf4j
public class UITest extends BaseTest {

    @DataProvider
    public Object[][] provideUsers() {
        return DataUtil.getTestData();
    }

    @Test
    public void alertsTest() {
        log.info("Starting Alerts test");
        MainPage main = new MainPage();
        Assert.assertTrue(main.isOpen(), "Not on the main page");
        main.clickAlertsFrameAndWindows();
        AlertsForm alertsPage = new AlertsForm();
        alertsPage.navigationBar.clickAlertsMenuButton();
        Assert.assertTrue(alertsPage.isOpen(), "Alerts form didn't open");
        alertsPage.clickAlertButton();
        Assert.assertTrue(Browser.getAlertText().contains(DataUtil.getValue("simpleAlertText")),
                "Alert didn't displayed");
        Browser.acceptAlert();
        Assert.assertTrue(Browser.hasNoAlerts(), "Alert is still present");
        alertsPage.clickConfirmButton();
        Assert.assertTrue(Browser.getAlertText().contains(DataUtil.getValue("confirmAlertText")),
                "Confirm alert didn't displayed");
        Browser.acceptAlert();
        Assert.assertTrue(Browser.hasNoAlerts(), "Confirm alert is still present");
        Assert.assertTrue(alertsPage.getConfirmResult().contains(DataUtil.getValue("confirmResult")),
                "No text appeared");
        alertsPage.clickPromptBoxButton();
        Assert.assertTrue(Browser.getAlertText().contains(DataUtil.getValue("promptAlertText")),
                "Prompt alert didn't displayed");
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        Browser.putAlertText(generatedString);
        Browser.acceptAlert();
        Assert.assertTrue(Browser.hasNoAlerts(), "Prompt alert is still present");
        Assert.assertTrue(alertsPage.getPromptResult().contains(generatedString), "No text appeared");
    }

    @Test
    public void iFrameTest() {
        log.info("Starting iFrame test");
        MainPage main = new MainPage();
        Assert.assertTrue(main.isOpen(), "Not on the main page");
        main.clickAlertsFrameAndWindows();
        NestedFramesForm nestedFramesPage = new NestedFramesForm();
        nestedFramesPage.navigationBar.clickNestedFramesMenuButton();
        List<String> expectedText = List.of("Parent frame", "Child Iframe");
        Assert.assertTrue(nestedFramesPage.isOpen(), "Nested Frames form is not open");
        Assert.assertTrue(nestedFramesPage.getFramesTextAsList().containsAll(expectedText), "Text is not as expected");
        FramesForm framesPage = new FramesForm();
        framesPage.navigationBar.clickFramesMenuButton();
        Assert.assertEquals(framesPage.getUpperFrameText(), framesPage.getLowerFrameText(),
                "Text from upper frame is not equal to one from lower");
    }

    @Test(dataProvider = "provideUsers")
    public void tablesTest(UserData user) {
        log.info("Starting Tables test");
        MainPage main = new MainPage();
        Assert.assertTrue(main.isOpen(), "Not on the main page");
        main.clickElements();
        WebTablesForm webTablesForm = new WebTablesForm();
        webTablesForm.clickWebTablesButton();
        Assert.assertTrue(webTablesForm.isOpen(), "Web Tables form is not open");
        RegistrationForm registrationForm = new RegistrationForm();
        webTablesForm.clickAddButton();
        registrationForm.fillTheForm(user);
        Assert.assertTrue(webTablesForm.getTableText().containsAll(user.getPropertiesAsList()), "Table doesn't contain new entry");
        Assert.assertFalse(registrationForm.isOpen(), "Registration form is still open");
        int entryCountBeforeDeletion = webTablesForm.getTableText().size();
        webTablesForm.deleteLastEntry();
        int entryCountAfterDeletion = webTablesForm.getTableText().size();
        Assert.assertFalse(entryCountBeforeDeletion == entryCountAfterDeletion && webTablesForm.getTableText().
                        containsAll(user.getPropertiesAsList()),
                "Entry deletion failed");
    }

    @Test
    public void handlesTest() {
        log.info("Starting Handles test");
        MainPage main = new MainPage();
        Assert.assertTrue(main.isOpen(), "Not on the main page");
        main.clickAlertsFrameAndWindows();
        BrowserWindowsForm browserWindowsPage = new BrowserWindowsForm();
        browserWindowsPage.navigationBar.clickBrowserWindowsMenuButton();
        Assert.assertTrue(browserWindowsPage.isOpen(), "Browser Windows form didn't open");
        browserWindowsPage.clickNewTabButton();
        Browser.switchToTab(2);
        SamplePage samplePage = new SamplePage();
        Assert.assertTrue(samplePage.isOpen(), "Sample Page didn't open");
        Browser.closeTab();
        Assert.assertTrue(browserWindowsPage.isOpen(), "Not on the Browser Windows form");
        browserWindowsPage.navigationBar.clickElementsButton();
        LinksForm linksPage = new LinksForm();
        linksPage.clickLinksButton();
        Assert.assertTrue(linksPage.isOpen(), "Links Page didn't open");
        linksPage.clickHomeLink();
        Browser.switchToTab(2);
        MainPage newMain = new MainPage();
        Assert.assertTrue(newMain.isOpen(), "Main page in new tab didn't open");
        Browser.switchToTab(1);
        Assert.assertTrue(linksPage.isOpen(), "Not on the Links Page");
    }
}
