package codeFish4.case4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class testCase4 {
    public testCase4(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//li[@id='Laboratory']")
    WebElement labaratory;
    @FindBy(xpath = "//input[@id='loginButton']")
    WebElement loginButton;
    //--------------------------
    @FindBy(xpath = "//div[@class='logo']")
    WebElement backToHome;
    @FindBy(linkText = "Find Patient Record")
    WebElement patientRecordClick;
    @FindBy(xpath = "//input[@id='patient-search']")
    WebElement searchBox;
    @FindBy(xpath = "//tr//td[1]")
    List<WebElement> ID;
    @FindBy(xpath = "//input[@id='delete-reason']")
    WebElement reason;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement confirm;
    @FindBy(xpath = "//div[@id='delete-patient-creation-dialog']//button[@class='confirm right']")
    WebElement itsAnotherConfirmButton;
    @FindBy(xpath = "//a[@id='org.openmrs.module.coreapps.deletePatient']")
    WebElement deleteButton;
    @FindBy(xpath = "//h6[contains(text(),'Reason cannot be empty')]")
    WebElement reasonCantBeEmpty;
    @FindBy(xpath = "//h1")
    WebElement validatePationtWasdelated;

    public void loginMethod(String username,String password) throws InterruptedException {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        labaratory.click();
        loginButton.click();
        Thread.sleep(2000);
    }
    public void validatePationIsCreated(WebDriver driver,String searchBox,String reason) throws InterruptedException {
        Thread.sleep(2000);
        backToHome.click();
        Thread.sleep(2000);
        patientRecordClick.click();
        Thread.sleep(2000);
        this.searchBox.sendKeys(searchBox);
        Thread.sleep(2000);
        for (WebElement id : ID) {
            if (!BrowserUtils.getText(id).isEmpty()) {
                Assert.assertFalse(BrowserUtils.getText(id).isEmpty());
                Thread.sleep(2000);
                id.click();
                break;
            }
        }
//deleteButton.click();
        Thread.sleep(2000);
        //itsAnotherConfirmButton.click();
        deleteButton.click();
        Thread.sleep(1000);
        itsAnotherConfirmButton.click();
        Assert.assertEquals(BrowserUtils.getText(reasonCantBeEmpty),"Reason cannot be empty");
        Thread.sleep(2000);
        this.reason.sendKeys(reason);
        Thread.sleep(2000);
        itsAnotherConfirmButton.click();
//i need to catch that fast validation test

    }

}
