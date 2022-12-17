package WindowHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Try2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://demoqa.com/browser-windows");
        //sleep statement
        Thread.sleep(1000);
        //clicking on Katalon Academy
        driver.findElement(By.xpath("//*[@id='Katalon']")).click();
        //sleep statement
       // Thread.sleep(1000);
        //clicking on tab
        driver.findElement(By.xpath("//*[@id='tabButton']")).click();
        //sleep statement
       // Thread.sleep(1000);
        //clicking on window
        driver.findElement(By.xpath("//*[@id='windowButton']")).click();
        //sleep statement
        //Thread.sleep(1000);
        //clicking on message window
        driver.findElement(By.xpath("//*[@id='msgWindowButtonWrapper']")).click();

        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(2));
        //sleep statement
        Thread.sleep(3000);
        driver.close();





    }//end of method

}//end of class
