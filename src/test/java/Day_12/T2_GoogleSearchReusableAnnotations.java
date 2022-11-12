package Day_12;
import Reusable_Library.ReusableActionLogger;
import Reusable_Library.ReusableAnnotationsTestNG;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
public class T2_GoogleSearchReusableAnnotations extends ReusableAnnotationsTestNG {


        @Test
        public void searchForBmw(){
            driver.navigate().to("https://www.google.com");
            //search for bmw on the search field
            ReusableActionLogger.sendKeysAction(driver,"//*[@name='q']","BMW",logger,"Search Field");
            //hit submit on google search button
            ReusableActionLogger.submitAction(driver,"//*[@name='btnK']",logger,"Google Search");
        }//end of test 1

        @Test(dependsOnMethods = "searchForBmw")
        public void captureSearchNumber(){
            //capture the search results text
            String results = ReusableActionLogger.getTextAction(driver,"//*[@id='result-stats']",logger,"Search Results");
            String[] arrayResult = results.split(" ");
            //print back to html report by using log INFO
            logger.log(LogStatus.INFO,"Search number for BMW is " + arrayResult[1]);
        }//end of test 2



    }//end of java class


