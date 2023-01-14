package techproed.tests.smoketest.logintests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day18_PositiveLoginTest {

//    Name: US100201_Admin_Login
//    Description:
//    User should be able login as admin
//    Acceptance Criteria:
//    As admin, I should be able to log in the application
//    https://www.bluerentalcars.com/
//    Admin email: jack@gmail.com
//    Admin password: 12345

        HomePage homePage;
        LoginPage loginPage;

        @Test
    public void US100201_Admin_Login() {

        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //cick on home page login link
            homePage = new HomePage();
            loginPage = new LoginPage();

            ReusableMethods.waitFor(3);
            homePage.homePageLoginLink.click();

        //send credentials and click on login button
            ReusableMethods.waitFor(3);
            loginPage.email.sendKeys("jack@gmail.com");
            ReusableMethods.waitFor(3);
            loginPage.pwd.sendKeys("12345");
            ReusableMethods.waitFor(3);
            loginPage.login.click();
            ReusableMethods.waitFor(3);

            //verify login is succesful
            //Assert.assertTrue(homePage.userID.isDisplayed());
            ReusableMethods.verifyElementDisplayed(homePage.userID);

            //alternatively...
            //ReusableMethods.verifyElementNotDisplayed(homePage.homePageLoginLink);




    }
}
