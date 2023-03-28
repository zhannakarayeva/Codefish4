package codeFish4.case1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

import java.util.List;

public class testCase1 {
    /*
    Navigate to "http://uitestpractice.com/Students/Select#"
    Validate India is selected by default on drop down box
    Validate the size of the Drop down box is 4
    Validate the values for Drop down box are :India,United States of America,China,England
    Select the China with index number
    Select the England with value
    Select the United States with visible text
     */
    public testCase1(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#countriesSingle")
    WebElement IndiaAsDefault;

    @FindBy (xpath = "//select[@id=\"countriesSingle\"]//option")
    List<WebElement > dropDown;

    public void validateIndiaInTheBox(WebDriver driver) throws InterruptedException {
        Select select=new Select(IndiaAsDefault);
        select.getFirstSelectedOption();//india
        select.selectByValue("england");
        select.selectByIndex(2);
        select.selectByVisibleText("United states of America");
        Thread.sleep(2000);
        for(WebElement drop:dropDown){
            System.out.println(BrowserUtils.getText(drop));//values
        }
        System.out.println(dropDown.size());//size

    }

}
