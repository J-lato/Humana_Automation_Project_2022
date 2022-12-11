package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static Reusable_Library.ReusableAnnotationsTestNG.driver;

public class ParellelChromeTest {
    @Parameters("browserName")
    @Test(priority = 1)
    public void TC_001_SearchLocation(){
        driver.navigate().to("https://www.hotels.com/");
        WebElement search = driver.findElement(By.xpath("//*[@aria-label='Going to']"));
        search.click();

        driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys("New York\n");

    }//end of test case 1
}
