package base;

import com.aventstack.extentreports.ExtentTest;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import factories.DriverFactory;
import managers.ApplicationLogManager;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {

    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    Properties props = new Properties();

    @BeforeMethod(alwaysRun = true)
    @Parameters(value={"browser"})
    public void setUp(@Optional("CHROME") String browser, ITestResult result) {

        try {
            props.load(getClass().getClassLoader()
                    .getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DriverFactory.setTlDriver(browser);

        DriverFactory.getTlDriver().get(props.getProperty("APPLICATION_URL"));
        DriverFactory.getTlDriver().manage().window().maximize();



        ApplicationLogManager.info("Setup Operation completed");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {
        DriverFactory.disposeDriver();
    }

}
