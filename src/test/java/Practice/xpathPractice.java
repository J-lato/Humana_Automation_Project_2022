package Practice;

import Reusable_Library.ReusableActionLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;

public class xpathPractice {
    public static void main(String[] args) {

        WebDriver driver = ReusableActionLogger.setUpDriver();

        driver.get("https://demo.applitools.com/app.html#");

        WebElement creditAvailable = driver.findElements(By.xpath("//*[@class='balance-value']")).get(1);

        String availableCredit = creditAvailable.getText();
        String[] number = availableCredit.split("");

        System.out.println(creditAvailable.getText());
        System.out.println(number[0]);

        String ebay = driver.findElements(By.xpath("//*[@class='cell-with-media']/span")).get(4).getText();
        String ebay2 = driver.findElement(By.xpath("(//*[@class='cell-with-media'])[5]")).getText();
        System.out.println(ebay2);




        driver.quit();
    }
}
