package Day_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_WebDriver {
    public static void main(String[] args) throws InterruptedException{
        //define webdriver manager steup
        WebDriverManager.chromedriver().setup();
   //define the chrome driver and use it for test
        //create an instance for chrome driver to use for automation
        WebDriver driver = new ChromeDriver();
        //navigate to a site
        driver.navigate().to("https://www.google.com");
        //wait a few seconds
       // Thread.sleep(30000);
        //quit chrome
       // driver.quit();
    }//end of main

    }//end java class

