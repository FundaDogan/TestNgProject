package techproed.tests;

import org.testng.annotations.Test;
import techproed.pages.TestCenterPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class TestCenterLogin {

//    https://testcenter.techproeducation.com/index.php?page=form-authentication
//    Login the application using page object model

    @Test
    public void testCenterLogin() {

        TestCenterPage testCenterPage = new TestCenterPage();

        Driver.getDriver().get(ConfigReader.getProperty("url_testcenter.techproeducation"));
        testCenterPage.userName.sendKeys(ConfigReader.getProperty("testcenter_username"));
        testCenterPage.password.sendKeys(ConfigReader.getProperty("testcenter_pwd"));
        testCenterPage.submit.click();

        Driver.closeDriver();

    }
}
