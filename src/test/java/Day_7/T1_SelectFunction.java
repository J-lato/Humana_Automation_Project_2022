package Day_7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_SelectFunction {
    public static void main(String[] args) throws InterruptedException {
        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();

        //initialize chrome options
        ChromeOptions options = new ChromeOptions();

        // add the options for maximizing the chrome meeting
        // options.addArguments("start-fullscreen") for mac
        options.addArguments("start-fullscreen");

        //define the chrome driver to use for your test
        //creating an instance for a chrome driver(browser) to use for automation
        WebDriver driver = new ChromeDriver(options);

        //navigate to website
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Show advanced options']")).click();
        Thread.sleep(2000);

        //use select command for month dropdown
        WebElement srtMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        Select startMonthDropdown = new Select(srtMonth);
        //select by visible text
        startMonthDropdown.selectByVisibleText("Nov");

//        //use select command for year dropdown
//        WebElement startYear = driver.findElement(By.xpath("//*[@name='sy']"));
//        Select startYearDropdown = new Select(startYear);
//        startYearDropdown.selectByVisibleText("2023");

        driver.findElement(By.xpath("//*[@name='sy']")).click();
        driver.findElement(By.xpath("//*[text()='2023']")).click();



    }
}
