package Day_11;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class T1_WebElements {

    @AfterSuite public void qutSession(){}
    WebDriver driver;
    ArrayList<WebElement> totalMenuHeaders, mainMenuHeaders;
    @BeforeSuite
    public void SetChromeDriver() {
        driver = ReusableActions.setUpDriver();
        //navigate to usps.com home page
        driver.navigate().to("https://www.usps.com/");
        //store all the elements of the menu header into an arraylist of webelements
        totalMenuHeaders = new ArrayList<>(driver.findElements(By.xpath("//*[@class = 'nav-list']/li")));
    }//end of set driver method
//    @AfterSuite
//    public void quitTheSession() {
//        driver.quit();
//    }//end of after suite
    @Test(priority=1)
        public void tc001_verifyMenuHeaders(){
        System.out.println("Total menu headers: "+ totalMenuHeaders.size());
    }//end test 1
    @Test(priority=2)
    public void tc002_clickFirstDropdown(){
        totalMenuHeaders.get(0).click();
    }//end test 2
    @Test(priority=3)
    public void tc003_verifyCountMainHeaders(){
       mainMenuHeaders=new ArrayList<>(driver.findElements(By.xpath("//*[@class='menuheader']")));
        System.out.println("The total main menu headers is: "+ mainMenuHeaders.size());
    }//end test 3
}
