package Day_10;
import Reusable_Library.ReusableActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;


public class T2_TestNG_GoogleSearch {

    WebDriver driver = ReusableActions.setUpDriver();
    @AfterSuite public void quitSession(){
        driver.quit();
    }//end After Suite

    @Test(priority = 1)
        public void SearchForCar(){
            driver.navigate().to("https://www.google.com");
            //enter a car in the search field
        ReusableActions.sendKeysAction(driver,"//*[@name='q']","AMG GT", "Search Field");
        //hit submit button
        ReusableActions.submitAction(driver, "//*[@name='btnK']","Google Search Button");
        }//end of test 1
    @Test(priority = 2)
    public void CaptureSearchNumbers() {
        String result = ReusableActions.getTextAction(driver, "//*[@id='result-stats']", "Search Results");
        String[] arrayResult = result.split(" ");
        System.out.println("Result is: " + arrayResult[1]);
    }//end of test 2
    }//end of java class

