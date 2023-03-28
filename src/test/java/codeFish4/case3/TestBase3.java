package codeFish4.case3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.DriverHelper;

public class TestBase3 {
    /*
    Navigate to "http://codefish.ninja/openmrs/login.htm"
    username:admin -- password: Admin123
    Select Labratory location and login
    Click Register patient
    Name  and last name (Use your name  and last name)
    Gender (Choose one of the given gender)
    Birthdate (use birthday younger than 90 years and older than 15 years old) estimated years "empty"
    Address 2200 E Devon ave city "Des Plains" state "IL" county cook zip 60018 Steps
     */
WebDriver driver= DriverHelper.getDriver();

    @BeforeSuite
    public void clearTheCashes(){
        driver= DriverHelper.getDriver();
        driver.manage().deleteAllCookies();
    }
    @BeforeMethod  //it will run febore everything
    public void setup() {
        driver= DriverHelper.getDriver();
        driver.get("http://codefish.ninja/openmrs/login.htm");
    }
//    @AfterMethod
//    public void tearDown(ITestResult iTestResult) throws InterruptedException {
//        if(!iTestResult.isNotRunning()){
//            Thread.sleep(2000);
//            BrowserUtils.getScreenshot(driver,"blazepicture");
//        }
//       // driver.quit();
//    }
}
