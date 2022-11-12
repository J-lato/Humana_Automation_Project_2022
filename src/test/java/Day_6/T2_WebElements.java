package Day_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_WebElements {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add options for maximizing the chrome window
        //options.addArguments("start-maximized","incognito");
//        options.addArguments("headless");
        //for mac use "start-fullscreen"
        options.addArguments("start-fullscreen", "incognito");
        //define the webdriver and pass the options into the method
        WebDriver driver = new ChromeDriver(options);
        //go to google page
        driver.navigate().to("https://www.mlcalc.com");

        Thread.sleep(2000);

        WebElement pPrice = driver.findElement(By.xpath("//*[@name= 'ma']"));


        pPrice.clear();

        pPrice.sendKeys("4567ui");

        WebElement dPayment = driver.findElement(By.xpath("//*[@name='dp']"));

        dPayment.clear();

        dPayment.sendKeys("25");
    }

}
