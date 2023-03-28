package codeFish4.case2;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ConfigReader;
import utils.DriverHelper;

public class TestBase2 {
    WebDriver driver= DriverHelper.getDriver();
    @BeforeSuite
    public void clearTheCashes(){
        driver= DriverHelper.getDriver();
        driver.manage().deleteAllCookies();
    }
    @BeforeMethod  //it will run febore everything
    public void setup() {
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("codefish1"));
    }
//    @AfterMethod
//    public void tearDown(ITestResult iTestResult) throws InterruptedException {
//       // if(!iTestResult.isNotRunning()){
//          //  Thread.sleep(2000);
//            //BrowserUtils.getScreenshot(driver,"case2");
//        }
//        //driver.quit();
//    }

}
