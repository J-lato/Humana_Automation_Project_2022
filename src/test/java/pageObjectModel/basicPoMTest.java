package pageObjectModel;

import Reusable_Library.ReusableActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class basicPoMTest {
    public static void main(String[] args) {
        WebDriver thisDriver = ReusableActions.setUpDriver();

        thisDriver.get("https://www.google.com");


       // thisDriver.findElement(By.xpath("//*[@id='gb']/div/div[2]/a"));

        basicPoM abc = new basicPoM(thisDriver);

        abc.searchBar2().clear();
        abc.searchBar2().sendKeys("Hello World");

        thisDriver.quit();



    }
}
