package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePOMElements {

    WebDriverWait wait;

    public GooglePOMElements(WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
    }
    public WebElement reusableElement (String xpath){

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return element;
    }

    public WebElement searchBar (){

       return reusableElement("//*[@name='q']");

    }

    public WebElement signIn(){
        return  reusableElement("//*[@id='gb']/div/div[2]/a");
    }
}

