package Day_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_Drive {
    public static void main(String[] args) throws InterruptedException {
        //define webdriver manager steup
        WebDriverManager.chromedriver().setup();
        //define the chrome driver and use it for test
        //create an instance for chrome driver to use for automation
        WebDriver driver = new ChromeDriver();
        //navigate to a site
        driver.navigate().to("https://www.google.com");

        driver.manage().window().fullscreen();
        Thread.sleep(2000);

        //search cars in the search field
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("AMG GT 4-door coupe");


        //hit submit on the google search button
        driver.findElement(By.xpath("//*[@name='btnI']")).submit();
        //sleep statement
        Thread.sleep(3000);

        //capture the search result text
        String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //split message to extract out the search number
        String[] splitResult = result.split(" ");
        System.out.println("the search number is " + splitResult[1]);

        //quit the driver to end the session
        //driver.quit();
    }
}
