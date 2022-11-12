package Reusable_Library;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class ReusableActionLogger {



        static int timeout = 15;

        //reusable method to define and launch webdriver
        public static WebDriver setUpDriver() {
            //define the webdriver manager setup for chromedriver
            WebDriverManager.chromedriver().setup();
            //initialize chrome options
            ChromeOptions options = new ChromeOptions();
            //add argument to chrome options
            options.addArguments("start-fullscreen","incognito");
            //for mac use "start-fullscreen"
            //options.addArguments("start-fullscreen");
            //if above does not work on mac, then try --kiosk
            //options.addArguments("--kiosk");
            //initialize driver with chrome options
            WebDriver driver = new ChromeDriver(options);
            return driver;
        }//end of setup driver method


        public static void clickAction(WebDriver driver, String xpath,  ExtentTest logger, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                element.click();
                logger.log(LogStatus.PASS,"Successfully clicked on: " + elementName);
            } catch (Exception e) {
                System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
                logger.log(LogStatus.FAIL,"Unable to click on element: " + elementName + " for reason: " + e);

            }
        }//end of click action method

        public static void clickActionByIndex(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
                logger.log(LogStatus.PASS,"Successfully clicked on: " + elementName);
            } catch (Exception e) {
                System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
                logger.log(LogStatus.FAIL,"Unable to click on element: " + elementName + " for reason: " + e);
            }
        }//end of click action by index method

        public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            //declare mouse actions
            Actions actions = new Actions(driver);
            try {
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                actions.moveToElement(element).perform();
                logger.log(LogStatus.PASS,"Successfully mouse hovered to: " + elementName);
            } catch (Exception e) {
                System.out.println("Unable to hover to element : " + elementName + " for reason: " + e);
                logger.log(LogStatus.FAIL,"Unable to mouse hovered on element: " + elementName + " for reason: " + e);

            }
        }//end of mouse hover method

        public static void sendKeysAction(WebDriver driver, String xpath, String userInput, ExtentTest logger, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                element.sendKeys(userInput); element.submit();
                logger.log(LogStatus.PASS,"Successfully sendKeys to: " + elementName);
            } catch (Exception e) {
                System.out.println("Unable to send keys to : " + elementName + " for reason: " + e);
                logger.log(LogStatus.FAIL,"Unable to sendKeys to: " + elementName + " for reason: " + e);

            }
        }//end of send Keys method

        public static String getTextAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            String textOutput = "";
            try {
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                textOutput = element.getText();
                logger.log(LogStatus.PASS, "Successfully captured text for: " + elementName);

            } catch (Exception e) {
                System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
                logger.log(LogStatus.FAIL,"Unable to captured text for: " + elementName + " for reason: " + e);

            }
            return textOutput;
        }//end of get text method

        public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                element.submit();
                logger.log(LogStatus.PASS,"Successfully submitted on " + elementName);
            } catch (Exception e) {
                System.out.println("Unable to submit on element : " + elementName + " for reason: " + e);
                logger.log(LogStatus.FAIL,"Unable to submitted on element: " + elementName + " for reason: " + e);
            }
        }//end of submit action

        public static void selectByText(WebDriver driver, String xpath, String userInput, ExtentTest logger, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                Select dropDown = new Select(element);
                dropDown.selectByVisibleText(userInput);
                logger.log(LogStatus.PASS,"Successfully selected from dropdown with visible text: " + elementName);
            }catch(Exception e){
                System.out.println("unable to get dropDown : " + elementName + "for reason: " + e);
                logger.log(LogStatus.FAIL,"Unable to get dropdown element: " + elementName + " for reason: " + e);

            }//end of catch
        }//end of selectByTextAction


        public static void switchToTabByIndex(WebDriver driver, int userInput, String elementName){
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(userInput));
        }//end of switchToTabsByIndex
    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method
    public static void compareExpectedAndActualText(String expectedText, String actualText, ExtentTest logger) {
        if (actualText.equals(expectedText)) {
            logger.log(LogStatus.PASS, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " match");
        }
        else{
            logger.log(LogStatus.FAIL, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " does not match");
        }
    }//end of compareExpectedAndActualText


        public static void scrollByView(WebDriver driver, String xpath, ExtentTest logger, String elementName){
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                jse.executeScript("arguments[0].scrollIntoView(true);", element);
                logger.log(LogStatus.PASS,"Successfully scrolled to element: " + elementName);

            }catch(Exception e){
                System.out.println("unable to scroll : " + elementName + "for reason" + e);
                logger.log(LogStatus.FAIL,"Unable to scrolled into element: " + elementName + " for reason: " + e);

            }//end of catch
        }//end of scrollByView
    public static void scrollByViewIndex(WebDriver driver, String xpath,int index, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement element;
            element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            jse.executeScript("arguments[0].scrollIntoView(true);",element);
            logger.log(LogStatus.PASS,"Successfully scrolled to element: " + elementName);

        }catch(Exception e){
            System.out.println("unable to scroll : " + elementName + "for reason" + e);
            logger.log(LogStatus.FAIL,"Unable to scrolled into element: " + elementName + " for reason: " + e);

        }//end of catch
    }//end of scrollByViewIndex

    public static void selectFromDropdown(WebDriver driver, String xpath, String selectorText,ExtentTest logger, String elementname){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
            try{WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select eleSelect= new Select(ele);
            eleSelect.selectByValue(selectorText);}
            catch(Exception e){
                System.out.println("Unable to select: "+elementname+"Because: "+e);
            }
    }//end selectFromDropdown

    }//end of class
