package Framework.Utils;

import com.fasterxml.jackson.databind.JsonNode;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.ArrayList;
import java.util.List;

public class BrowserConfiguration {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        List<String> opts = new ArrayList<>();
        for (JsonNode node : DataUtil.getConfig().get("chrome_options")) {
            opts.add(node.textValue());
        }
        options.addArguments(opts);
        return options;
    }

    public static EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        List<String> opts = new ArrayList<>();
        for (JsonNode node : DataUtil.getConfig().get("edge_options")) {
            opts.add(node.textValue());
        }
        options.addArguments(opts);
        return options;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference(DataUtil.getConfig().get("firefox_options").get("key").asText(),
                DataUtil.getConfig().get("firefox_options").get("value").asText());
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        return options;
    }
}
