package reports;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class OpenCartReport implements ITestListener {

	String reportName;
	ExtentSparkReporter reports;
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		test.assignCategory(result.getMethod().getGroups());

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "test pass");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "test fail");
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "test skip");

	}

	public void onStart(ITestContext context) {
		String dt = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		reportName = "Test-Report " + dt + ".html";
		reports = new ExtentSparkReporter(".\\reports\\" + reportName);
		reports.config().setDocumentTitle("Open Cart Automation Report");
		reports.config().setReportName("K Rajasekhar");
		reports.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(reports);
		report.setSystemInfo("application", "opencart");
		report.setSystemInfo("module", "admin");
		report.setSystemInfo("user name", System.getProperty("user.name"));
		report.setSystemInfo("environment", "QA");
		report.setSystemInfo("operating system", context.getCurrentXmlTest().getParameter("os"));
		report.setSystemInfo("browser", context.getCurrentXmlTest().getParameter("browser"));
		List<String> groups = context.getCurrentXmlTest().getIncludedGroups();
		if (!groups.isEmpty())
			report.setSystemInfo("groups", groups.toString());
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}

}
