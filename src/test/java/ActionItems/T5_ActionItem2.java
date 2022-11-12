package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class T5_ActionItem2 {
    public static void main(String[] args) throws InterruptedException {
        //define the web driver manager setup for Chrome browser
        WebDriverManager.chromedriver().setup();
        //create an instance of chromedriver for automation use
        WebDriver driver0 = new ChromeDriver();

        ArrayList<String> sports = new ArrayList<>();
        sports.add("Cricket");
        sports.add("Football");
        sports.add("Soccer");
        sports.add("Polo");

        //maximize window chrome
        driver0.manage().window().fullscreen();
        Thread.sleep(3000);
        for (int j=0; j < sports.size(); j++) {
            //navigate to webpage
            driver0.navigate().to("https://www.bing.com");
            //locate the search feild's relative xpath and enter some keywords
            driver0.findElement(By.xpath("//*[@name='q']")).sendKeys(sports.get(j));
            //hit the search button
            driver0.findElement(By.xpath("//*[@name='search']")).submit();
           //This text originally to test the search function
            // System.out.println(j+" "+ sports.get(j));
            Thread.sleep(3000);


            //capture the target data
            String data = driver0.findElement(By.xpath("//*[@data-bm='4']")).getText();
            System.out.println("There are: " + data + "for " + sports.get(j));
        }//end for loop
        driver0.quit();


    }//end main
}//end ActionItem2
