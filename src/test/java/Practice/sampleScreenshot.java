package Practice;

import Reusable_Library.ReusableActions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class sampleScreenshot {


    public static void screenshotMethod(WebDriver driver, ExtentTest logger) throws IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy HH:mm:ss");
        Date date = new Date();
        String actualDate = dateFormat.format(date);

        //create the ss file and define the path where it should go
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String directory = "src/main/java/HTML_Report/Screenshots/";
        String ssPath = directory+actualDate+".png";
        //save the file to the path
        FileUtils.copyFile(src,new File(ssPath));
        String ss = logger.addScreenCapture("Screenshots//"+actualDate+".png");
        logger.log(LogStatus.INFO,"Screenshot",ss);
    }
}