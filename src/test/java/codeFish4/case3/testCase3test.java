package codeFish4.case3;

import org.testng.annotations.Test;

public class testCase3test extends TestBase3{
    @Test
    public void validation() throws InterruptedException {
        testCase3 testCase3=new testCase3(driver);
        testCase3.ValidateLabaratory();


    }

}
