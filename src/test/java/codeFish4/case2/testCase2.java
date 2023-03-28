package codeFish4.case2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class testCase2 {
    /*
Navigate to Navigate to "http://uitestpractice.com/Students/Select#"
Validate the values for Multiple Select are :India,United States of America,China,England,Select China and England
Validate "China England" is displayed
Deselect all the countries
Select All the countries
Validate "India United states of America China,England" is displayed
Deselect the China with index number
Deselect the England with value Steps
     */
    public testCase2(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//select[@id='countriesMultiple']//option")
    List<WebElement> countryMultiple;

    @FindBy(xpath = "//select[@id='countriesMultiple']")
    WebElement box;
    @FindBy(xpath = "//select[@id='countriesMultiple']//option[contains(text(),'China')]")
    WebElement China;
    @FindBy(xpath = "//select[@id='countriesMultiple']//option[contains(text(),'United states of America')]")
    WebElement USA;
    @FindBy(xpath = "//select[@id='countriesMultiple']//option[contains(text(),'India')]")
    WebElement India;

    @FindBy(xpath = "//select[@id='countriesMultiple']//option[contains(text(),'England')]")
    WebElement England;


    public void validateCountries() throws InterruptedException {
        Thread.sleep(2000);
        for (int i=0;i<countryMultiple.size();i++ ){
            if(countryMultiple.size()>0){
                Assert.assertTrue(BrowserUtils.getText(countryMultiple.get(i)).contains("India,United States of America,China,England"));
            }
        }

    }
}
