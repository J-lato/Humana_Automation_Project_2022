package Practice;

import Reusable_Library.ReusableActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


//    @Test public void rightClickMenu() throws InterruptedException {
//        WebDriver driver = ReusableActions.setUpDriver();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.navigate().to("https://demoqa.com/browser-windows");
//        Actions mouseAction = new Actions(driver);
//
//        WebElement katalon = driver.findElement(By.xpath("//*[@class='RightSide-Ad']"));
//        mouseAction.contextClick(katalon).build().perform();
//        //ArrayList<WebElement> elementOpen = new ArrayList<>(driver.findElements(By.linkText("Open")));
//
//        mouseAction.sendKeys(Keys.ARROW_DOWN).build().perform();
//        Thread.sleep(3000);
//        mouseAction.sendKeys(Keys.ARROW_DOWN).perform();
//        Thread.sleep(3000);
//        mouseAction.sendKeys(Keys.RETURN).perform();
//
//
//
//        Thread.sleep(5000);
//        driver.quit();



public class SwitchWindows {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://demoqa.com/browser-windows");
        //sleep statement
        Thread.sleep(1000);
        //clicking on Katalon Academy

        //sleep statement
        // Thread.sleep(1000);
        //clicking on tab
        driver.findElement(By.xpath("//*[@id='tabButton']")).click();
        //sleep statement
        // Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='Katalon']")).click();
        //clicking on window
        driver.findElement(By.xpath("//*[@id='windowButton']")).click();
        //sleep statement
        //Thread.sleep(1000);
        //clicking on message window
        driver.findElement(By.xpath("//*[@id='msgWindowButtonWrapper']")).click();

        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(windows.get(2));
//        //sleep statement
//        Thread.sleep(3000);
//        driver.close();

        for(String s : windows){
            driver.switchTo().window(s);
            System.out.println(s+" + "+driver.getCurrentUrl());
            String myURL= "https://katalon.com/free-automation-tools";
            if(myURL.equals(driver.getCurrentUrl())){
                break;
            }

        }
        driver.close();

        Thread.sleep(4000);
        driver.quit();

        /* CDwindow-5213D40383479468F447070780FED5BE + https://demoqa.com/browser-windows
            CDwindow-3315816B9743DB4F684EE45B62F2142A + https://demoqa.com/sample
            CDwindow-599252C48C9FD7548E80231C3CBE971E + https://katalon.com/free-automation-tools
            CDwindow-B85F59497C9CAE6379BBD650CD56E6EF + https://demoqa.com/sample*/





    }//end of method



}//end of class


