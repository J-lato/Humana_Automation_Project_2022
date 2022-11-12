package ActionItems;

import Reusable_Library.ReusableActionLogger;
import Reusable_Library.ReusableAnnotationsTestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionItem6_PharmacyFamily extends ReusableAnnotationsTestNG {
    @BeforeMethod
    public void popUpWindow() throws InterruptedException {
        driver.navigate().to("https://www.humana.com");
        Thread.sleep(3000);
        //handle popup
//        try{  ReusableActionLogger.clickAction(driver,"//*[@aria-label='No thanks']",logger,"noThanksPopup");}
//        catch(Exception e){
//            System.out.println("popUp not found");}
    }
//    @Test(priority = 1) public void tc040102_PharmacyZipSearch() throws InterruptedException {
//        ReusableActionLogger.mouseHover(driver,"//*[@data-parent='parent']",logger,"shopForPlansMenu");
//        //click Shop Medicare
//        ReusableActionLogger.clickAction(driver,"//*[contains(text(), 'Find a pharmacy')]",logger,"Find a pharmacy");
//        //scroll to search field
//        ReusableActionLogger.scrollByView(driver,"//*[@class='core-filter-ui-b-s-headline']",logger,"zipInputScroll");
//        Thread.sleep(3000);
//        //enter a zipcode
//
//        Thread.sleep(1000);
//        //click first result
//        driver.findElement(By.xpath("//*[@id='placesAutocomplete']")).sendKeys("20052",Keys.DOWN, Keys.ENTER);
//        Thread.sleep(4000);
//    }
    @Test(priority=2)public void tc040102_PharmacyDrugSearch() throws InterruptedException {
        //hover over Shop For Plans
        ReusableActionLogger.mouseHover(driver,"//*[@data-parent='parent']",logger,"shopForPlansMenu");
        //click Prescription savings and tools
        ReusableActionLogger.clickAction(driver,"//*[contains(text(), 'Prescription savings & tools')]",logger,"clickShopMedicare");
        //scroll to header
        ReusableActionLogger.scrollByViewIndex(driver,"//*[@class='nb-h2 main-heading']",1,logger,"scrollToDrugs");
        Thread.sleep(2000);
        //click the Drug List
        ReusableActionLogger.clickActionByIndex(driver,"//*[contains(text(), 'Search the Drug List')]",0,logger,"DrugListClick");
        Thread.sleep(4000);
        //click it again
        ReusableActionLogger.clickActionByIndex(driver,"//*[@class='button-container')]",3,logger,"DrugListClick");
        //click it again
        ReusableActionLogger.clickActionByIndex(driver,"//*[@class='cta-text')]",1,logger,"DrugListClick");
        //switch tabs
        ReusableActionLogger.switchToTabByIndex(driver,1,"DrugSearchTab");
        //enter zip
        ReusableActionLogger.sendKeysAction(driver,"//*[@name='zip-code']","20052",logger,"enterZip");
        //submit
        ReusableActionLogger.submitAction(driver,"//[@class='btn btn-primary']",logger,"zipcodeSubmit");
        //handle checkboxes
        ReusableActionLogger.clickAction(driver,"//*[@class='check-box-box']",logger,"Check Network");
        Thread.sleep(1000);
        //submit
        ReusableActionLogger.submitAction(driver,"//[@class='btn btn-primary']",logger,"zipcodeSubmit");
        //click on enrolling in healthplan
        ReusableActionLogger.sendKeysAction(driver,"//*[@name='drug-name']","advil",logger,"enterDrugName");
        //add to list
        ReusableActionLogger.clickAction(driver,"//*[@id='save-button']",logger,"addToList");
        //check coverage
        ReusableActionLogger.submitAction(driver,"//[@class='btn btn-primary']",logger,"zipcodeSubmit");
        Thread.sleep(3000);
        driver.close();
    }


}
