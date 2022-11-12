package Day_11;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_Boolean {
    WebDriver driver;
    @BeforeSuite
    public void SetChromeDriver() {
        driver = ReusableActions.setUpDriver();
    }//end of set driver method
    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of after suite

    @Test(priority=1) public void tc001(){
        //navigate to homepage
    driver.navigate().to("https://www.yahoo.com");
    //next we need to click sign in
        ReusableActions.clickAction(driver,"//*[@class='_yb_1933e']","Sign in button");
        //verify sign in button is checked
    boolean isSignInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        System.out.println("The checkbox check condition is: "+ isSignInChecked);
    }//end of t1
    @Test(dependsOnMethods= "tc001") public void tc002(){
        ReusableActions.clickAction(driver,"//*[@class='stay-signed-in checkbox-container']", "SignedInCheckbox");
        //verify sign in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        System.out.println("The checkbox check condition is: "+ isSignInChecked);
    }//end of t1



}
