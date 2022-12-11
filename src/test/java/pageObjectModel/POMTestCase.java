package pageObjectModel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectModel.GooglePOMElements;

public class POMTestCase {
        public static void main(String[] args) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver2 = new ChromeDriver();
            GooglePOMElements abc = new GooglePOMElements(driver2);


            driver2.navigate().to("https://www.google.com/");

            // driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
            //abc.searchBar().sendKeys("cars\n");
            abc.searchBar().sendKeys("cars");
            abc.signIn().click();

            driver2.quit();
            abc.reusableElement("//*[@id='gb']/div/div[2]/a");




        }
    }

