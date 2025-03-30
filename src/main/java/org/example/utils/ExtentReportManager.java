package org.example.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class ExtentReportManager {

    static ExtentReports extent;
    static SimpleDateFormat ft = new SimpleDateFormat("d-MMM-YY HH-mm-ss");
    static String strDate = ft.format(new Date());
    final static String reportPath = "Reports" + File.separator + "SparkReport " +
                                     strDate + File.separator + "ExtentReportsTestNG.html";
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

    public static synchronized ExtentReports getReporter() {

        if(extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setDocumentTitle("Selenium Parallel Testing Demo");
            reporter.config().setReportName("Internet Herokuapp Demo");
            reporter.config().setTimeStampFormat("MMM d, yyyy hh:mm:ss a");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }

    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized ExtentTest startTest(String testName, String description) {
        ExtentTest extentTest = getReporter().createTest(testName, description);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), extentTest);

        return extentTest;
    }

    public static synchronized void endTest() {
        getReporter().removeTest(extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }

}
