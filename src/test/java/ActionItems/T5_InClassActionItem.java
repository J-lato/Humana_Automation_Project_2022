package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class T5_InClassActionItem {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

//initialize chrome options
        ChromeOptions options = new ChromeOptions();
// add the options for maximizing the chrome meeting
// options.addArguments("start-fullscreen") for mac
        options.addArguments("start-fullscreen", "incognito");
        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> places = new ArrayList<>();
        places.add("Toronto");
        places.add("San Diego");
        places.add("Santorini");

        int[] adultsNum = new int[]{3, 4, 2};


        ArrayList<String> childages = new ArrayList<>();
        childages.add("6");
        childages.add("3");
        childages.add("2");


        for (int i = 0; i < places.size(); i++) {
            driver.navigate().to("https://www.hotels.com");
            //Thread.sleep(3000);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']")).click();
            //create web element to find the search field
            WebElement whereto = driver.findElement(By.xpath("//*[@id='destination_form_field']"));
            whereto.click();
            //enter destinations into search field
            whereto.sendKeys(places.get(i));
            //Thread.sleep(1000);
            //find all elements that pop up in the search field autofill and choose the first one
            driver.findElements(By.xpath("//*[@data-stid='destination_form_field-result-item-button']")).get(0).click();
            //Thread.sleep(1000);

            //Click the element to change room parameters
            driver.findElement(By.xpath("//*[@data-stid='open-room-picker']")).click();
            //Thread.sleep(1000);
            //decrease the number of adults to 1
            driver.findElement(By.xpath("//*[@aria-label='Decrease the number of adults in room 1']")).click();
            //Thread.sleep(2000);
         //Create a nested for loop to change the number of adults to the desired amount
            //this for loop says: there is an integer j; when j is less that the desired number; run the code and add 1 to j
       try {
           for (int j = 1; j < adultsNum[i]; j++) {
               //add one adult
               driver.findElements(By.xpath("//*[@class='uitk-icon uitk-step-input-icon uitk-icon-medium']")).get(1).click();
               //Thread.sleep(2000);
           }
       } catch( Exception e){
           System.out.println("Nested for loop Failure: " + e);
       }

            //Click the element to reduce the number of children to 1
            driver.findElement(By.xpath("//*[@aria-label='Increase the number of children in room 1']")).click();

            //Create selector to choose the age of the child
            WebElement childage = driver.findElement(By.xpath("//*[@id='age-traveler_selector_children_age_selector-0-0']"));
            Select childageSelector = new Select(childage);
            childageSelector.selectByValue(childages.get(i));
            //Thread.sleep(2000);
            //Click done
            driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
            //Thread.sleep(2000);
            //click search
            driver.findElement(By.xpath("//*[@id='submit_button']")).click();
            //Make an arraylist of hotel search results
            ArrayList<WebElement> resorts = new ArrayList<>(driver.findElements(By.xpath("//*[@data-stid='open-hotel-information']")));
            //create conditional statements to click a different link for each iteration
            if (i == 0) {
                resorts.get(0).click();
            } else if (i == 1) {
                resorts.get(2).click();
            } else if (i == 2) {
                resorts.get(1).click();
            }
            //Thread.sleep(4000);
            //Use window manager to switch tabs
            //create an ArrayList to manage windows
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            //Thread.sleep(3000);
            //create a webelement to capture the name of the resort then print it
            WebElement resortname = driver.findElement(By.xpath("//*[@class='uitk-heading uitk-heading-3']"));
            System.out.println("The " + places.get(i) + " resort is: " + resortname.getText());
            //Thread.sleep(8000);
            //Click Reserve a room
            driver.findElement(By.xpath("//*[@data-stid='navbar-quick-reserve-button']")).click();
            //Thread.sleep(2000);
            //print price per night
            System.out.println(driver.findElement(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).getText() + " per night");
            //click on reserve
            ArrayList<WebElement> reservation = new ArrayList<>(driver.findElements(By.xpath("//*[@data-stid='submit-hotel-reserve']")));
            reservation.get(0).click();
            ////Thread.sleep(16000);
            // reservation.get(15).click();
            //Thread.sleep(2000);
            //capture checkin and checkout dates and print them
            try {
                System.out.println(driver.findElement(By.xpath("//*[@class='booking-details-travel-details-wrapper fs-base clear bg-white mb-none--xs bd-all bdra-big mt-mouse']")).getText());
            } catch (Exception e) {
                System.out.println("unable to capture dates..." + e);
            }
            //close tab
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }//end for loop
        driver.quit();
    }//end main
}//end java class
