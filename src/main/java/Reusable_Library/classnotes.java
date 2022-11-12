package Reusable_Library;

public class classnotes {
  /*  @BeforeMethod
    public void captureTestName(Method testName){
        //before every test, this method will be called and take the name of your test
        //and it will add your test method name to the html report
        logger = reports.startTest(testName.getName());
    }//end of before method
    IT Professor to Everyone (12:12 PM)
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
        //writing back to one html report
        reports.flush();
    }//end of aftersuite
    IT Professor to Everyone (12:15 PM)
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @BeforeSuite
    public void setTheDriver(){
        driver = Reusable_Actions.setUpDriver();
        //set the report path here
        reports = new ExtentReports("src/main/java/HTML_Report/Automation_Report.html",true);
    }//end of beforesuite
    IT Professor to Everyone (12:24 PM)
    @Test
    public void searchForBmw(){
        driver.navigate().to("https://www.google.com");
        //search for bmw on the search field
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@name='q']","BMW",logger,"Search Field");
        //hit submit on google search button
        Reusable_Actions_Loggers.submitAction(driver,"//*[@name='btnK']",logger,"Google Search");
    }//end of test 1

    @Test(dependsOnMethods = "searchForBmw")
    public void captureSearchNumber(){
        //capture the search results text
        String results = Reusable_Actions_Loggers.getTextAction(driver,"//*[@id='result-stats']",logger,"Search Results");
        String[] arrayResult = results.split(" ");
        //print back to html report by using log INFO
        logger.log(LogStatus.INFO,"Search number for BMW is " + arrayResult[1]);
    }//end of test 2
    IT Professor to Everyone (12:50 PM)
    <?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Regression">
    <test name="Google And Yahoo Scenarios" preserve-order="true">
        <classes>
            <class name="Day12_110622.T2_GoogleSearch_ReusableAnnotations" />
            <class name="Day12_110622.T3_YahooScenario_ReusableAnnotations" />
        </classes>
    </test> <!-- Test -->
</suite> <!-- Suite -->
    IT Professor to Everyone (12:56 PM)
    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsChecked() throws InterruptedException {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.yahoo.com/");
        //next we need to click on sign in button
        Reusable_Actions_Loggers.clickAction(driver,"//*[@class = '_yb_1933e']",logger,"Sign In");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
        logger.log(LogStatus.INFO,"The checkbox check condition is: " + isSignInChecked);
    }//end of test 1
    IT Professor to Everyone (12:56 PM)
    @Test(dependsOnMethods = "tc001_verifySignedInOptionIsChecked")
    public void tc002_verifySignedInOptionIsUnChecked() {
        //click on check box to uncheck it
        Reusable_Actions_Loggers.clickAction(driver,"//*[@class= 'stay-signed-in checkbox-container']",logger,"Check Box Unchecked");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
        logger.log(LogStatus.INFO,"The checkbox check condition is: " + isSignInChecked);
    }//end of test 2
    Maryam Kabir to Everyone (12:59 PM)
    done
    Shahdat Hossain to Everyone (12:59 PM)
    done
    Patrick Fieffe to Everyone (12:59 PM)
    done
    md islam to Everyone (12:59 PM)
    Done
    hossain Shiblu to Everyone (1:00 PM)
    done
    Nusrat Zahan D to Everyone (1:01 PM)
    done
    Sudeep Barua to Everyone (1:02 PM)
    done */
}
