package com.project.result;

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

import com.project.setup.testSetup;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG implements IReporter {
    public static ExtentReports extent;
  
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        extent = new ExtentReports(outputDirectory + File.separator + "ExtentReportTestNG.html", true);
  
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
  
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
  
                try {
					buildTestNodes(context.getPassedTests(), LogStatus.PASS);
	                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
	                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

            }
        }
  
        extent.flush();
        extent.close();
    }
  
    private void buildTestNodes(IResultMap tests, LogStatus status) throws InterruptedException {
        ExtentTest test;
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.startTest(result.getMethod().getMethodName());
  
/*              test.getTest().startedTime = getTime(result.getStartMillis());
                test.getTest().endedTime = getTime(result.getEndMillis());*/
                test.getTest().setStartedTime(getTime(result.getStartMillis()));
                test.getTest().setEndedTime(getTime(result.getEndMillis()));
                //test.addScreenCapture(scr.createScreenshot());
  
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);
  
                String message = "Test " + status.toString().toLowerCase() + "ed";
  
                if (result.getThrowable() != null)
                    message = result.getThrowable().getMessage();
  
                test.log(status, message);
  
                extent.endTest(test);
            }
        }
    }
  
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();        
    }
}
