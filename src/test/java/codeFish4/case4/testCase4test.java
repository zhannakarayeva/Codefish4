package codeFish4.case4;

import org.testng.annotations.Test;

public class testCase4test extends TestBase4 {
    @Test
    public void testCase4Runner() throws InterruptedException {
       testCase4 testCase4=new testCase4(driver);
        testCase4.loginMethod("admin","Admin123");
        PageRegisterPatient pageRegisterPatient=new PageRegisterPatient(driver);
        pageRegisterPatient.setRegisterPatient("Zhanna","Karayeva","25","1995",
                "2200 E Devon ave","Des Plains","IL","cook","60018","996 52 18 0592");
        testCase4.validatePationIsCreated(driver,"Zhanna Karayeva","Moved");

    }
}
