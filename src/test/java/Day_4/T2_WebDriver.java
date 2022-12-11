package Day_4;

import Reusable_Library.ReusableActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_WebDriver {
    public static void main(String[] args) throws InterruptedException{
        String aba = "hello world";
        aba.split(" ");
        

                //define webdriver manager steup
        WebDriverManager.chromedriver().setup();
   //define the chrome driver and use it for test
        //create an instance for chrome driver to use for automation
        WebDriver driver = new ChromeDriver();
        //navigate to a site
        driver.navigate().to("https://www.google.com");
        //wait a few seconds
       Thread.sleep(3000);
        boolean a =false;
        System.out.println(a);
        if(ReusableActions.getTextAction(driver,"//*[@class='gb_e gb_f']/a","gmail").equals("Gmail")){
            a=true;
            System.out.println(a);
        }
        System.out.println(a);
        while(a==true){
            driver.navigate().refresh();
        }
        //quit chrome
        driver.quit();
    }//end of main

    }//end java class

