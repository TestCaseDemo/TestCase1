package com.test.testcasesPractice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Constants;
import utils.DriverHelper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {

    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static WebDriver driver;
    public static String ReportDateAndTime;


    @BeforeSuite
    public void StartReport(){
        String dateName = new SimpleDateFormat("dd-MM-yyyy-hh_mm").format(new Date());
        ReportDateAndTime = dateName;
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ File.separator + "Register Testcase Reports"+ File.separator + "Register_Automation Reports" + dateName + ".html");

      extent = new ExtentReports();
      extent.attachReporter(sparkReporter);

      extent.setSystemInfo("OS",System.getProperty("os.name"));
      extent.setSystemInfo("Browser", ConfigReader.readProperty("chrome"));

      sparkReporter.config().setTheme(Theme.DARK);
      sparkReporter.config().setDocumentTitle("Register Automation Report");
      sparkReporter.config().setReportName("Automation Exercise for Register TestCase");
      sparkReporter.config().setTimeStampFormat("EEEE,MMMM dd, yyyy,hh:mm a'('zzz')' ");
    }

    @BeforeMethod
    public void SetDriver(Method testMethod) {
        logger = extent.createTest(testMethod.getName());
        logger.log(Status.INFO, "Launching Browser");

        driver = DriverHelper.getDriver();
        driver.get(Constants.urls);



    }
    public static String ProjectfileScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/FailedTestScreenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;

    }
    public static String ExtentReportScreenshot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        String error = takesScreenshot.getScreenshotAs(OutputType.BASE64);
        System.out.println("ScreenShot saved successfully ");
        return error;
    }

    @AfterMethod
    public void getTestResult(ITestResult iTestResult) throws IOException {
        if(iTestResult.getStatus() == ITestResult.FAILURE){
            logger.log(Status.FAIL , MarkupHelper.createLabel(iTestResult.getName() + "FAILED", ExtentColor.RED));
            logger.fail(iTestResult.getThrowable());

            TestBase.ProjectfileScreenshot(driver ,iTestResult.getName());

            String error = ExtentReportScreenshot();
            logger.addScreenCaptureFromBase64String(error , "Please click above fo ERROR IMAGE");


        }else if (iTestResult.getStatus() == ITestResult.SUCCESS){
          logger.log(Status.PASS , MarkupHelper.createLabel(iTestResult.getName() + "PASSED" , ExtentColor.GREEN));
          String error = ExtentReportScreenshot();

          logger.addScreenCaptureFromBase64String(error, "Please click above for image");

        }else if(iTestResult.getStatus() == ITestResult.SKIP){
            logger.log(Status.SKIP,MarkupHelper.createLabel(iTestResult.getName()+ "SKIPED" ,ExtentColor.YELLOW));
            logger.skip(iTestResult.getThrowable());

        }
        //driver.quit();


    }

    @AfterSuite
    public void tearDown (){

        extent.flush();
    }
}
