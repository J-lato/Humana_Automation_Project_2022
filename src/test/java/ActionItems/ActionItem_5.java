package ActionItems;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class ActionItem_5 {
  //declare driver and set equal to reusableActions setUpDriver to give it all options
  WebDriver driver = ReusableActions.setUpDriver();
  WebDriverWait wait = new WebDriverWait(driver,10);
  //declare afterSuite class to quit the session
  //@AfterSuite public void endSession() {driver.quit();}
  @Test(priority = 1)
  public void tc001_navigate() throws InterruptedException {
      driver.navigate().to("https://www.uhc.com");
      //trying to navigate to find a doctor

      ReusableActions.clickAction(driver,"//*[contains(text(),'Find a doctor')]", "FindADoctor");
      // ReusableActions.doubleClickAction(driver, "/html/body/div[1]/div/div[1]/header/div/div[1]/div[2]/div[2]/div[2]/div[1]/a", "Find a Doctor");
      //String href = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div/div[1]/div[2]/div[2]/div[2]/div[1]/a")).getAttribute("href");
      //driver.navigate().to(href);

      //scroll to find a dentist then click
      ReusableActions.scrollByView(driver,"//*[text()='Find a dentist']","FindDentist");
      ReusableActions.clickAction(driver,"//*[text()='Find a dentist']", "clickDentist");
      //switch tabs to interact
      ReusableActions.switchToTabByIndex(driver,1);
      Thread.sleep(10000);
      driver.navigate().refresh();
      //click Employer link
      ReusableActions.clickActionByIndex(driver,"//*[@class='option-title']",0,"clickEmployers");
  }//end test1
    @Test(priority = 2) public void tc002_enterZip() throws InterruptedException {
      Thread.sleep(3000);
      ReusableActions.sendKeysAction(driver, "//*[@id='location']","11221", "sendZipCode");
      Thread.sleep(2000);
      //click on continue button
        ReusableActions.clickAction(driver,"//*[@cs-id='locationSubmit']","continueButton");
        Thread.sleep(3000);
      ReusableActions.clickAction(driver, "//*[text()='*National Options PPO 30']","clickFirstResult" );
      //click General Dentist
        ReusableActions.clickActionByIndex(driver, "//*[@class='sc-gSYDnn fslDuO']", 0, "clickGeneralDentist");
  }//end test2
    @Test(priority = 3) public void tc003_selectDistance() {
        ReusableActions.selectByText(driver, "//*[@id='distance']", "Within 1 Mile", "selectDistance");
        //click on the first doctor
        ReusableActions.clickActionByIndex(driver, "//*[@class='sc-knnzTo cMveOm']", 0, "clickTheFirst");
        //click the save button
        ReusableActions.clickAction(driver, "//*[@data-test-id='saved-provider-button']", "clickSave");
        //capture address, distance away, and in-network status
        String address = ReusableActions.getTextAction(driver, "//*[@data-test-id='provider-address']", "getAddress");
        String distance = ReusableActions.getTextAction(driver, "//*[@class='td c-4-dt-tbl']", "distanceAway");
        String network = ReusableActions.getTextAction(driver, "//*[@class='status-label']", "networkStatus");
        //print all values
        System.out.println("Address: " + address + "Distance: " + distance + "Network: " + network);
        driver.close();
    }//end test3
    @Test(priority = 4)public void tc004_searchResults() {
        ReusableActions.switchToTabByIndex(driver, 0);
        //enter keyword doctor
        ReusableActions.sendKeysAction(driver, "//*[@id='search-desktop']", "doctor","searchDoctor");
        //click/submit
        ReusableActions.submitAction(driver, "//*[@id='search-desktop']", "submit the search");
        //capture the amount of search results
        String searchNumber= ReusableActions.getTextAction(driver,"//*[@id='search-results-count__header']", "SearchResultNumber");
        //grab the right text
        String[] search_number= searchNumber.split(" ");
        //print the number
        System.out.println("Search number is: "+search_number[2]);
    }//end test 4



    }//end class

