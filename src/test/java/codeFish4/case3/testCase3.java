package codeFish4.case3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class testCase3 {
    /*
Navigate to "http://codefish.ninja/openmrs/login.htm" username:admin -- password: Admin123
Select Labratory location and login Validate your location is Laboratory
Validate "Logged in as Super User (admin) at Laboratory."
Change location to Pharmacy and click to OPENMRS  logo
Validate "Logged in as Super User (admin) "location change to Pharmacy ."
Select Find patient record Find the John johns patient and validate his identifier is unic Steps
     */
    public testCase3(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//li[@id='Laboratory']")
    WebElement labaratoryLocation;
    @FindBy(xpath = "//input[@id='loginButton']")
    WebElement loginButton;

    @FindBy(xpath = "//input[@id='username']")
    WebElement userName;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;


    @FindBy(xpath = "//span[@id='selected-location']")
    WebElement labaratoryChangeToParmacy;

    @FindBy(xpath = "//li[@locationname='Pharmacy']")
    WebElement Pharmacy;

    @FindBy(xpath = "//div[@class='logo']")
    WebElement logo;

    @FindBy(xpath = "//i[@class='icon-search']")
    WebElement findPationRecord;

    @FindBy(xpath = "//td[2]")
    List<WebElement> allPations;

    public void ValidateLabaratory() throws InterruptedException {
        labaratoryLocation.click();
        Assert.assertTrue(BrowserUtils.getText(labaratoryLocation).contains("Laboratory"));
        Thread.sleep(2000);
        userName.sendKeys("admin");
        password.sendKeys("Admin123");
        loginButton.click();
        Thread.sleep(1000);
        labaratoryChangeToParmacy.click();
        Pharmacy.click();
        Thread.sleep(1000);
        logo.click();
        Thread.sleep(1000);
        Assert.assertTrue(BrowserUtils.getText(labaratoryChangeToParmacy).contains("Pharmacy"));
        findPationRecord.click();

        Thread.sleep(2000);
        for(WebElement pationt:allPations){
            if(pationt.equals("John Johns")){
                Assert.assertEquals(BrowserUtils.getText(pationt),"Joh");
                System.out.println(pationt.getText());
            }
        }
    }
}
