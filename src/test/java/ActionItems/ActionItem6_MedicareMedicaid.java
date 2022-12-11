package ActionItems;

import Reusable_Library.ReusableActionLogger;
import Reusable_Library.ReusableActions;
import Reusable_Library.ReusableAnnotationsTestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionItem6_MedicareMedicaid extends ReusableAnnotationsTestNG {
    @BeforeMethod public void popUpWindow() throws InterruptedException {
        driver.navigate().to("https://www.humana.com");
        Thread.sleep(4000);
        //handle popup
        WebDriverWait wait = new WebDriverWait(driver,10);
       try{ boolean popUp = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@aria-label='No thanks']")))).isDisplayed();
        if (popUp){
            ReusableActionLogger.clickAction(driver,"//*[@aria-label='No thanks']",logger,"noThanksPopup");}}
       catch(Exception e){
           System.out.println("popUp Not Displayed" +e);
       }
    }
    @Test() public void tc010102_MedicareZipSearch() throws InterruptedException {
//        driver.navigate().to("https://www.humana.com");
//        //handle popup
//      try{  ReusableActionLogger.clickAction(driver,"//*[@aria-label='No thanks']",logger,"noThanksPopup");}
//      catch(Exception e){
//          System.out.println("popUp not found");}
        //hover over Shop For Plans
        ReusableActionLogger.mouseHover(driver,"//*[@data-parent='parent']",logger,"shopForPlansMenu");
        //click Shop Medicare
        ReusableActionLogger.clickAction(driver,"//*[contains(text(), 'Shop Medicare Advantage plans')]",logger,"clickShopMedicare");
        //scroll to zip search field
        ReusableActionLogger.scrollByView(driver,"//*[@name='zipInput']",logger,"zipInputScroll");
        Thread.sleep(3000);
        //enter a zipcode
        ReusableActionLogger.sendKeysAction(driver,"//*[@name='zipInput']","20052",logger,"enterZip");
        Thread.sleep(1000);
        //submit
        ReusableActionLogger.clickAction(driver,"//*[@type='submit']",logger,"submitZip");
        Thread.sleep(4000);
        //id='fsrInvite
        //click skip to plans
        ReusableActionLogger.clickActionByIndex(driver, "//*[@class='text-align-left']",1,logger,"clickSkiptoPlans");
    }
    @Test(dependsOnMethods = "tc010102_MedicareZipSearch")public void tc020402_MedicaidEnrollment() throws InterruptedException {
        //hover over Shop For Plans
        ReusableActionLogger.mouseHover(driver,"//*[@data-parent='parent']",logger,"shopForPlansMenu");
        //click Enrollment
        ReusableActionLogger.clickAction(driver,"//*[contains(text(), 'Enrollment and eligibility')]",logger,"clickShopMedicare");
        //scroll to first link
        ReusableActionLogger.scrollByView(driver,"//*[@class='nc-link__text  ']",logger,"flLinkScroll");
        Thread.sleep(2000);
        //click the first link
        ReusableActionLogger.clickActionByIndex(driver,"//*[contains(text(), 'Florida State Enrollment Site (AHCA)')]",0,logger,"flLinkClick");
        Thread.sleep(4000);
        ReusableActionLogger.switchToTabByIndex(driver,1,"FloridaEnrollmentTab"); //// switch back to first tab
        //handle popUp
        ReusableActionLogger.clickAction(driver,"//*[@id='btnEligNo']",logger,"FloridaPopup");
        Thread.sleep(1000);
        //click on enrolling in healthplan
        ReusableActionLogger.clickAction(driver, "//*[contains(text(), 'Enrolling in a Health Plan')]",logger,"clicking Florida Enrollment Link");
        driver.close();
        //switch back to first tab
        ReusableActionLogger.switchToTabByIndex(driver,0,"FloridaEnrollmentTab");
    }
    @Test(dependsOnMethods = "tc020402_MedicaidEnrollment")public void tc020503_FilterDoctors() throws InterruptedException {
        //hover over Shop For Plans
        ReusableActionLogger.mouseHover(driver,"//*[@data-parent='parent']",logger,"shopForPlansMenu");
        //click Enrollment
        ReusableActionLogger.clickAction(driver,"//*[contains(text(), 'Where to get care')]",logger,"clickShopMedicare");
        //scroll to find a Doctor
        ReusableActionLogger.scrollByViewIndex(driver,"//*[@class='nc-link__text  ']",2,logger,"flLinkScroll");
        //click the Doctor Finder
        ReusableActionLogger.clickActionByIndex(driver,"//*[@class='nc-link__text  ']",2,logger,"flLinkClick");
        //switchTabs
        ReusableActionLogger.switchToTabByIndex(driver,1,"findADocTab");
        Thread.sleep(2000);
        //enter a zip
        ReusableActionLogger.sendKeysAction(driver,"//*[@name='zipCode']","34741",logger,"enterZip");
        //select multiple coverage criteria
        ReusableActionLogger.clickAction(driver,"//*[@class='coverage-type-standard']",logger,"selectCoverage");
        Thread.sleep(3000);
        try{  ReusableActionLogger.clickAction(driver,"//*[@aria-label='No thanks']",logger,"noThanksPopup");}
        catch(Exception e){
            System.out.println("popUp not found"+e);}

        ReusableActionLogger.clickAction(driver,"//*[@id='nucleus-radio-button-17-label']",logger,"selectCoverage");
        ReusableActionLogger.clickAction(driver,"//*[@id='nucleus-radio-button-20-label']",logger,"CoverageYear");
        ReusableActionLogger.clickAction(driver,"//*[@class='network nc-form-field-native-element']",logger,"SelectNetwork");
        ReusableActionLogger.clickAction(driver,"//*[@name='Employer HMO']",logger,"SelectHMONetwork");
        Thread.sleep(3000);
        //search
        ReusableActionLogger.clickAction(driver,"//*[@id='submitButton']",logger,"submitSearch");
        ReusableActionLogger.clickAction(driver,"//*[@id='searchButton']",logger,"submitSearch");
        //click on specialty
        ReusableActions.clickAction(driver, "//*[@id='ProviderSpecialty3)]","clicking Allergist Filter");
        Thread.sleep(2000);
    }
}
