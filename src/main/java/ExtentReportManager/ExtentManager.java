package ExtentReportManager;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentManager implements IReporter {
    private ExtentReports extent;

    @Override
    public void generateReport(List<XmlSuite> list, List<ISuite> list1, String s) {
        extent = new ExtentReports(s + File.separator + "SeleniumTest.html", true);

    for(ISuite suite : list1) {
        Map<String, ISuiteResult> result = suite.getResults();

        for (ISuiteResult res : result.values()) {
            ITestContext context = res.getTestContext();

            buildTest(context.getPassedTests(), LogStatus.PASS);
            buildTest(context.getFailedTests(), LogStatus.FAIL);
            buildTest(context.getSkippedTests(), LogStatus.SKIP);
        }
    }

        extent.flush();
        extent.close();
    }


        private void buildTest(IResultMap tests, LogStatus status) {
            ExtentTest test;

            if (tests.size() > 0) {
                for (ITestResult result : tests.getAllResults()) {
                    test = extent.startTest(result.getMethod().getMethodName());

                    test.setStartedTime(getTime(result.getStartMillis()));
                    test.setEndedTime(getTime(result.getEndMillis()));

                    for (String group : result.getMethod().getGroups())
                        test.assignCategory(group);

                    if (result.getThrowable() != null) {
                        test.log(status, result.getThrowable());
                        test.log(status, "Test " + status.toString().toLowerCase()
                                + " ");
                    } else {
                        test.log(status, "Test " + status.toString().toLowerCase()
                                + " ");
                    }

                    extent.endTest(test);
                }
            }
        }

        private Date getTime(long millis) {
            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(millis);
        return c.getTime();
    }
}

