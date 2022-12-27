package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basicPoM {
     WebDriver driver;


    public basicPoM(WebDriver driver){
        driver = this.driver;
    }


    public WebElement reusableElement (String xpath){

        WebElement element = driver.findElement(By.xpath(xpath));
        return element;
    }
    public WebElement searchBar2(){
        return reusableElement("//*[@name='q']");

    }
}

