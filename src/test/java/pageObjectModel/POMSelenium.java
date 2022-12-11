package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POMSelenium {
        private WebDriver driver;
        public POMSelenium(WebDriver driver){
            this.driver =driver;
        }

        @FindBy(xpath = "//*[@name='q']")
        public WebElement searchBar;
}