package codeFish4.case4;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.DriverHelper;

public class TestBase4 {
    WebDriver driver;
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
}
