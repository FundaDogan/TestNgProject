package techproed.homework;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TestCenterPage;
import techproed.pages.TestHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class TestCenterLogin {

//    https://testcenter.techproeducation.com/index.php?page=form-authentication
//    Login the application using page object model

    @Test
    public void testCenterLogin() {

        TestCenterPage testCenterPage = new TestCenterPage();

        Driver.getDriver().get(ConfigReader.getProperty("url_testcenter.techproeducation"));
        testCenterPage.userName.sendKeys("techproed");
        testCenterPage.password.sendKeys("SuperSecretPassword");
        testCenterPage.submit.click();

        //verify login is succesful
        TestHomePage testHomePage = new TestHomePage();
        Assert.assertTrue(testHomePage.loginMessage.isDisplayed());

       // ReusableMethods.verifyElementDisplayed(testHomePage.loginMessage);  done with reusable method, recommended

        Driver.closeDriver();

    }
}
