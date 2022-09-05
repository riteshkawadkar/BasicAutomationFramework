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

    private static DriverFactory instance = new DriverFactory();

    private DriverFactory() {
    }

    public static DriverFactory getInstance() {
        if (instance == null) {
            throw new IllegalStateException("WebDriver Instance is null! Please create instance of WebDriver using setWebDriver!");
        }
        return instance;
    }

    public static WebDriver getDriver() {
        if (tlDriver.get() == null) {
            throw new IllegalStateException("WebDriver Instance is null! Please create instance of WebDriver using setWebDriver!");
        }
        return tlDriver.get();
    }

    public static void setDriver(WebDriver driver) {
        tlDriver.set(driver);

    }

    public static void disposeDriver() {
        tlDriver.get().quit();
        tlDriver.remove();

    }

}
