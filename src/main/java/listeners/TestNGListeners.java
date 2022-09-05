package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import factories.DriverFactory;
import managers.ApplicationLogManager;
import managers.ExtentReportManager;
import factories.ExtentTestFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener{
    public static ExtentTest test;
    public static ExtentReports report;

    @Override
    public void onTestStart(ITestResult result) {
        test = report.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        test
                .assignAuthor(System.getProperty("user.name"))
                .assignCategory("SMOKE")
                .assignDevice("Windows");
        ExtentTestFactory.getInstance().setExtent(test);
        ExtentTestFactory.getInstance().getExtent().log(Status.INFO, "Test Started");
        ApplicationLogManager.info("Test Started- " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestFactory.getInstance().getExtent().log(Status.PASS, "Test Passed ");
        ApplicationLogManager.info("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTestFactory.getInstance().getExtent().log(Status.FAIL, "Exception:");
        ExtentTestFactory.getInstance().getExtent().log(Status.FAIL,result.getThrowable());
        ApplicationLogManager.error("FAILED");
        ApplicationLogManager.error(result.getThrowable().toString());


        TakesScreenshot ts = (TakesScreenshot) DriverFactory.getInstance().getDriver();
        String screenshotAsBase64String = ts.getScreenshotAs(OutputType.BASE64);

        // base64
        ExtentTestFactory.getInstance().getExtent().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotAsBase64String).build());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestFactory.getInstance().getExtent().log(Status.SKIP, "Skip:");

        ApplicationLogManager.info("Test Skipped- " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ExtentTestFactory.getInstance().getExtent().log(Status.FAIL, "Failed on Timeout");
        ExtentTestFactory.getInstance().getExtent().log(Status.FAIL,result.getThrowable());

    }

    @Override
    public void onStart(ITestContext context) {
        report = ExtentReportManager.setupExtentReports();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentTestFactory.getInstance().getExtent().log(Status.INFO, "Test Stopped");
        ExtentTestFactory.getInstance().disposeExtent();
        report.flush();
    }

}
