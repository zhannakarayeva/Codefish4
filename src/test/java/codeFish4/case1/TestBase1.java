package codeFish4.case1;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class TestBase1 {
  WebDriver driver= DriverHelper.getDriver();
  @BeforeMethod
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
    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws InterruptedException {
        if(!iTestResult.isNotRunning()){
            Thread.sleep(2000);
            BrowserUtils.getScreenshot(driver,"blazepicture");
        }
        // driver.quit();
    }
}
