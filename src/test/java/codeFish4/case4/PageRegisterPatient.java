package codeFish4.case4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageRegisterPatient {
        public PageRegisterPatient(WebDriver driver){
            PageFactory.initElements(driver,this);
        }
        @FindBy(linkText = "Register a patient")
        WebElement registerPatient;
        @FindBy(xpath = "//input[@name='givenName']")
        WebElement name;
        @FindBy(xpath = "//input[@name='familyName']")
        WebElement surname;
        @FindBy(css= "#genderLabel")
        WebElement gender;
        @FindBy(xpath = "//select[@id='gender-field']")
        WebElement genderBox;
        @FindBy(css = "#birthdateLabel")
        WebElement birthday;
        @FindBy(xpath = "//input[@name='birthdateDay']")
        WebElement day;
        @FindBy(xpath = "//select[@name='birthdateMonth']")
        WebElement month;
        @FindBy(xpath = "//input[@name='birthdateYear']")
        WebElement year;
        @FindBy(xpath = "//span[contains(text(),'Address')]")
        WebElement pressAdres;
        @FindBy(xpath = "//input[@id='address1']")
        WebElement address;
        @FindBy(xpath = "//input[@id='cityVillage']")
        WebElement cityVillage;
        @FindBy(xpath = "//input[@id='stateProvince']")
        WebElement state;
        @FindBy(xpath = "//input[@id='country']")
        WebElement county;
        @FindBy(xpath = "//input[@id='postalCode']")
        WebElement postcode;
        @FindBy(xpath = "//span[contains(text(),'Phone Number')]")
        WebElement phoneNum;
        @FindBy(xpath = "//input[@name='phoneNumber']")
        WebElement phoneNumber;
        @FindBy(xpath = "//span[@id='confirmation_label']")
        WebElement confirm;
        @FindBy(xpath = "//ul[@id='similarPatientsSelect']")
        WebElement informationAboutMe;
        @FindBy(xpath = "//input[@id='submit']")
        WebElement confirmButton;
        public void setRegisterPatient(String name,String surname,String day,String year,String address,
                                       String city,String state,String county,String postcode,String phoneNumber) throws InterruptedException {
            registerPatient.click();
            Thread.sleep(1000);
            this.name.sendKeys(name);
            this.surname.sendKeys(surname);
            Thread.sleep(1000);
            gender.click();
            Select select=new Select(genderBox);
            select.selectByVisibleText("Female");
            Thread.sleep(1000);
            birthday.click();
            this.day.sendKeys(day);
            Select select2=new Select(month);
            select2.selectByVisibleText("February");
            this.year.sendKeys(year);
            Thread.sleep(1000);
            pressAdres.click();
            Thread.sleep(1000);
            this.address.sendKeys(address);
            this.cityVillage.sendKeys(city);
            this.state.sendKeys(state);
            this.county.sendKeys(county);
            this.postcode.sendKeys(postcode);
            Thread.sleep(1000);
            phoneNum.click();
            this.phoneNumber.sendKeys(phoneNumber);
            Thread.sleep(3000);
            confirm.click();
            Thread.sleep(3000);
            //Assert.assertTrue(BrowserUtils.getText(informationAboutMe).contains("Zhanna Karayeva Female, 25.Feb.1995, 2200 E Devon ave Des PlainsILcook60018"));
            confirmButton.click();

        }

    }
