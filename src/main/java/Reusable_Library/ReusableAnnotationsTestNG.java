package Reusable_Library;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;


public class ReusableAnnotationsTestNG {
    /*
    WebDriver variable needs to get inherited to your test class but in order to do that
    it must be public static
     */
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;
    @BeforeSuite
    public void setTheDriver(){
        driver = ReusableActions.setUpDriver();
        reports= new ExtentReports("src/main/java/HTML_Report/Automation_Report.html",true);
        // String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        // reports = new ExtentReports("src/main/java/HTML_Report/Automation_Report" + timeStamp + ".html",false)

    }//end of beforesuite
    @BeforeMethod
    public void captureTestName(Method testName){
        //before every test, this method will be called and take the name of your test
        //and it will add your test method name to the html report
        logger = reports.startTest(testName.getName());
    }//end of before method

    @AfterMethod
    public void endLogger(){
        reports.endTest(logger);
    }//end of after method

    @AfterSuite
    public void quitSession(){
        driver.quit();
        reports.flush();
    }//end of aftersuite

}
