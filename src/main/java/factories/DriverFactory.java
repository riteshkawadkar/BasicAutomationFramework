package factories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    // TreadLocal WebDriver instance for providing parallel support to WebDriver instance
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver getTlDriver() {
        if (tlDriver.get() == null) {
            throw new IllegalStateException("WebDriver Instance is null! Please create instance of WebDriver using setWebDriver!");
        }
        return tlDriver.get();
    }

    public static void setTlDriver(String browser) {
        switch (browser.toUpperCase()) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("headless");
                tlDriver.set(new ChromeDriver(options));
                break;

            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                tlDriver.set(new FirefoxDriver());
                break;

            case "EDGE":
                WebDriverManager.edgedriver().setup();
                tlDriver.set(new EdgeDriver());
                break;

            default:
                throw new IllegalStateException("MESSAGE_UNKNOWN_BROWSER");
        }

    }

    public static void disposeDriver() {
        tlDriver.get().quit();
        tlDriver.remove();

    }

}
