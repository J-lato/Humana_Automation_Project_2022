package Day_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_xpathTextFind {
    public static void main(String[] args) throws InterruptedException {
        //setup webdriver
        WebDriverManager.chromedriver().setup();
//define the new webdriver
        WebDriver driver = new ChromeDriver();
//go to the homepage
        driver.navigate().to("https://www.yahoo.com");
//make the window fullscreen
        driver.manage().window().fullscreen();
//find the relative xpath using contains
        driver.findElement(By.xpath("//*[text() = 'Sign in']"));
        //wait two seconds
        Thread.sleep(2000);
//close the window
        driver.close();

    }
}
