package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class T5_ActionItem3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk", "incognito", "headless");

        WebDriver driver = new ChromeDriver(options);
//declare the Arraylist and define it
        ArrayList<String> zipCodes = new ArrayList();
        zipCodes.add("11224");
//        zipCodes.add("45678");
//        zipCodes.add("92602");
        JavascriptExecutor jse =  (JavascriptExecutor) driver;
        for (int j = 0; j < zipCodes.size(); j++) {
//navigate to weight watchers
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            Thread.sleep(4000);
            WebElement zipSearch = driver.findElement(By.xpath("//*[@id='location-search']"));
            Thread.sleep(3000);
            zipSearch.clear();
            zipSearch.sendKeys(zipCodes.get(j));
            zipSearch.submit();
            Thread.sleep(3000);

            //store the element address before leaving the page
            String streetAdd= driver.findElements(By.xpath("//*[@class='address-3-YC0']")).get(j).getText();
            //find and click the link of the Studio
            driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(j).click();
            Thread.sleep(3000);
            //find and capture first line of the address
            //String streetNum = driver.findElement(By.xpath("//*[@class='address-2PZwW']/div[1]")).getText();
            //find and capture second line of the address
           // String city = driver.findElement(By.xpath("//*[@class='address-2PZwW']/div[2]")).getText();
            //print the full address of the Studio
            //System.out.println("Studio " +j+": "+ streetNum +" "+ city);


            System.out.println("Studio " +j+": "+ streetAdd);
            Thread.sleep(3000);
            //define the Element for the schedule
            WebElement schedule = driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']"));
            //scroll to the schedule
            jse.executeScript("arguments[0].scrollIntoView(true)",schedule);
            Thread.sleep(3000);
            //print the schedule
            System.out.print(schedule.getText());
        }//end for loop
        //driver.quit();
    }//end java class


}



