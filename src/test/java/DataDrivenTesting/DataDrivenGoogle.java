package DataDrivenTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataDrivenGoogle {

    @Test
    public void navigateGoogle() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.navigate().to("https://www.google.com");

        JXL_library input = new JXL_library("src/main/resources/DataDriven.xls");

        String sendData = "";
        for (int i =0; i<3; i++){
            driver.navigate().to("https://www.google.com");
            Thread.sleep(2000);
            sendData += input.getCellValue(0,0,i) + " ";
            sendData += input.getCellValue(0,1,i);

            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(sendData + "\n");
            Thread.sleep(2000);
            sendData = "";
        }

        //String sendData = input.getCellValue(0,0,0);
        //driver.findElement(By.xpath("//*[@name='q']")).sendKeys(sendData + "\n");

    }

}//end of class
