package codeFish4.case1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.DriverHelper;

public class testCase1test extends TestBase1{
    WebDriver driver= DriverHelper.getDriver();
    @Test
    public void validateIndia() throws InterruptedException {

        testCase1 page=new testCase1(driver);
        page.validateIndiaInTheBox(driver);
    }

}
