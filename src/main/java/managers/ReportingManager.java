package managers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportingManager {

    protected static ExtentSparkReporter sparkReporter;
    protected static ExtentReports extent;

    public static ExtentReports getExtentReport() {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"/reports/MyOwnReport.html");

        sparkReporter.config().setDocumentTitle("Core Automation");
        sparkReporter.config().setReportName("Daily Sanity Report");
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        sparkReporter.config().setTheme(Theme.DARK);

        // Initialize ExtentReport and attach it to reporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        return extent;
    }

}
