package Day_13;

import Practice.sampleScreenshot;
import Reusable_Library.ReusableActionLogger;
import Reusable_Library.ReusableAnnotationsTestNG;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class T1_screenshotYahoo extends ReusableAnnotationsTestNG {
    @Test(priority = 1)
    public void tc001_verifySignedInOptionIsChecked() throws IOException {
        //first navigate to yahoo homepage
        driver.navigate().to("https://demo.applitools.com/app.html#");
        //next we need to click on sign in button
        //this will fail because the xpath is incorrect(screenshot should be attached to the report)
        ReusableActionLogger.clickAction(driver,"(//*[@class='cell-with-media'])[3]/following-sibling::td[1]",logger,"Mailchimp");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@class= 'content-i']")).isDisplayed();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
        logger.log(LogStatus.INFO,"The checkbox check condition is: " + isSignInChecked);

        sampleScreenshot.screenshotMethod(driver,logger);


    }//end of test 1


}
