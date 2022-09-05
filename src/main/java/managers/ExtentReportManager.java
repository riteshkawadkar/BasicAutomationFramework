package managers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.util.Arrays;
import java.util.List;

public class ExtentReportManager {

    public static ExtentReports setupExtentReports() {
        ExtentReports report;
        ExtentSparkReporter sparkReporter;

        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"/reports/Report.html");

        sparkReporter.config().setDocumentTitle("Basic Automation Framework");
        sparkReporter.config().setReportName("Sanity Report");
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        sparkReporter.config().setTheme(Theme.DARK);

        List<ViewName> DEFAULT_ORDER = Arrays.asList(
                ViewName.DASHBOARD,
                ViewName.TEST,
                ViewName.LOG,
                ViewName.EXCEPTION,
                ViewName.CATEGORY,
                ViewName.DEVICE,
                ViewName.AUTHOR
        );
        sparkReporter.viewConfigurer().viewOrder().as(DEFAULT_ORDER);


        // Initialize ExtentReport and attach it to reporter
        report = new ExtentReports();
        report.attachReporter(sparkReporter);

        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", "Chrome");
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("User", System.getProperty("user.name"));



        return report;
    }
}
