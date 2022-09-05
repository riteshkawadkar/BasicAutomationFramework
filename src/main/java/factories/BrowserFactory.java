package factories;

import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.WebDriverListenerHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class BrowserFactory {

    public static WebDriver getBrowser(String browserName){

        WebDriver driver = null;

        WebDriverListener listener = new WebDriverListenerHandler();
        WebDriver decorated = null;

        if(browserName.equalsIgnoreCase("CHROME")) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions optionsChrome = new ChromeOptions();
            optionsChrome.addArguments("incognito");
            driver = new ChromeDriver(optionsChrome);
            decorated = new EventFiringDecorator(listener).decorate(driver);

        }
        else if (browserName.equalsIgnoreCase("FIREFOX")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions optionsFirefox = new FirefoxOptions();
            optionsFirefox.addArguments("private");
            driver = new FirefoxDriver(optionsFirefox);
            decorated = new EventFiringDecorator(listener).decorate(driver);

        }
        else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            InternetExplorerOptions optionsIE = new InternetExplorerOptions();
            optionsIE.addCommandSwitches("private");
            driver = new InternetExplorerDriver(optionsIE);
            decorated = new EventFiringDecorator(listener).decorate(driver);

        }

        return decorated;
    }
}
