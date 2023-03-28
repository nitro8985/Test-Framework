package Framework.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static WebDriver initDriver() {
        String browserName = DataUtil.getConfig().get("browser").asText();
        switch (browserName.toLowerCase()) {
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(BrowserConfiguration.getFirefoxOptions());
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver(BrowserConfiguration.getEdgeOptions());
            }
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(BrowserConfiguration.getChromeOptions());
            }
            default -> throw new RuntimeException("Non supportable browser");
        }
    }
}
