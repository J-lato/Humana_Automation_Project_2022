package Reusable_Library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ReusableActions {
    public static int timeout = 15;
    public static WebDriver setUpDriver() {
        //setup your chromedriver with WebDriverManager
        WebDriverManager.chromedriver().setup();
        //initialize chromeOptions
        ChromeOptions options = new ChromeOptions();
        //add some arguments to chromeOptions (options.addArguments("--kiosk");
        options.addArguments("start-fullscreen", "incognito");
        //initialize the chromeDriver with options
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
    public static void doubleClickAction(WebDriver driver, String xpath, String elementName){
        Actions act = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        act.doubleClick(element).perform();}
        catch(Exception e){
            System.out.println("Unable to double click element: "+elementName+" Because: "+e);
        }
    }

    public static void clickAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
        }
    }


    public static void clickActionByIndex(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
        }
    }
    public static void clickableWaitAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            element.click();

        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
        }
    }

    public static void mouseHover(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover to element: " + elementName + " for reason: " + e);
        }
    }
        public static void sendKeysAction(WebDriver driver, String xpath, String userInput, String elementName) {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            try {
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                element.sendKeys(userInput);
            } catch (Exception e) {
                System.out.println("Unable to send keys to : " + elementName + " for reason: " + e);
            }
        }
    public static String getTextAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String textOutput = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            textOutput = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to get text for : " + elementName + " for reason: " + e);
        }
        return textOutput;
    }
    public static void submitAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element: " + elementName + " for reason: " + e);}
    }//end of submit action

    public static void selectByText(WebDriver driver, String xpath, String text, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{ WebElement theElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        Select selector = new Select(theElement);
        selector.selectByVisibleText(text);}
        catch(Exception e) {
            System.out.println("Unable to select text: "+ elementName+ "because: "+ e);}
    }//end of selectByText

    public static void switchToTabByIndex(WebDriver driver, int tabIndex ){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
       ArrayList <String> tabs = new ArrayList<>(driver.getWindowHandles());
       driver.switchTo().window(tabs.get(tabIndex));
    }//end of switchToTabByIndex

    public static void scrollByView(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
       try{ WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);}
       catch(Exception e) {
           System.out.println("Unable to scroll to element: "+ elementName+ "Because: "+ e);}
    }//end of scrollByView
    public static void scrollByPixel(WebDriver driver, int X, int Y) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        try{String scroll = "scroll(" + String.valueOf(X) + "," + String.valueOf(Y) + ")";
        jse.executeScript(scroll);}
        catch(Exception e) {
            System.out.println("Unable to scroll by pixel because: "+e);
        }

    }

}//end of class
