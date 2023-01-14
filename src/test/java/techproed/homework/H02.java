package techproed.homework;

import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class H02 {

    //        Name:
//        Login screen error messages
//        Description:
//        User should see error message when an invalid email is entered
//        Acceptance Criteria:
//        As admin or customer, I should be able to see error message, when I do not provide a complete valid email address in email address box
//        Error Message: email must be a valid email
//        When I enter a valid email domain, then I should not see the error message
//        https://email-verify.my-addr.com/list-of-most-popular-email-domains.php

    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        homePage = new HomePage();
        loginPage = new LoginPage();
        ReusableMethods.waitFor(3);

        homePage.homePageLoginLink.click();

        ReusableMethods.waitFor(2);
        loginPage.email.sendKeys("john");
        ReusableMethods.waitFor(2);
        loginPage.pwd.sendKeys("34567");
        ReusableMethods.waitFor(2);
        loginPage.login.click();
        ReusableMethods.waitFor(2);

        ReusableMethods.verifyElementDisplayed(loginPage.invalidEmailMessage);
    }
}
