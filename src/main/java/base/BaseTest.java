package base;

import com.aventstack.extentreports.ExtentTest;
import factories.DriverFactory;
import freemarker.template.utility.Constants;
import managers.ApplicationLogManager;
import factories.BrowserFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseTest {

    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    protected Properties props = new Properties();


    @BeforeMethod(alwaysRun = true)
    @Parameters(value={"browser"})
    public void setUp(@Optional("CHROME") String browser, ITestResult result) {

        try {
            props.load(getClass().getClassLoader()
                    .getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DriverFactory.getInstance().setDriver(BrowserFactory.getBrowser(browser));

        DriverFactory.getDriver().get(props.getProperty("APPLICATION_URL"));
        DriverFactory.getInstance().getDriver().manage().window().maximize();

        ApplicationLogManager.info("Setup Operation completed");


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {
        DriverFactory.disposeDriver();
    }



}
