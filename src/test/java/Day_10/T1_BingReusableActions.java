package Day_10;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.WebDriver;

public class T1_BingReusableActions {
    public static void main(String[] args) {
        //call the reusable method to setup the WebDriver
        WebDriver driver = ReusableActions.setUpDriver();
        //navigate
        driver.navigate().to("https://www.bing.com");
        //call the reusable method to enter a keyword in the search field
        ReusableActions.sendKeysAction(driver,"//*[@name='q']", "soccer","searchBar");
        //click submit
        ReusableActions.clickAction(driver,"//*[@id='search_icon']", "searchIcon");
        //capture the result and extract the number
        String result = ReusableActions.getTextAction(driver,"//*[@class='sb_count']","searchResultsNumber");
        System.out.println("Results: "+result);
        driver.quit();
    }//end of main
}//end of class
