package techproed.tests.smoketest.logintests;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;
import java.io.IOException;
public class Day19_NegativeLoginTest {

    HomePage homePage;
    LoginPage loginPage;
    Faker faker;

    @Test(groups = "minor-regression-group")
    public void US100208_Negative_Login() throws IOException {

//        As customer, I should not be able to log in the application
        //going blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

//        click on home page login link
        homePage = new HomePage();
        loginPage= new LoginPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();

//        sending credentials and clicking on login button
        ReusableMethods.waitFor(3);
//        Customer email: fake@bluerentalcars.com
//        Customer password: fakepass
        loginPage.email.sendKeys("fake@bluerentalcars.com");
        ReusableMethods.waitFor(3);
        loginPage.pwd.sendKeys("fakepass");
        ReusableMethods.waitFor(3);
        loginPage.login.click();
        ReusableMethods.waitFor(3);

//        Error: User with email fake@bluerentalcars.com not found
        String errorMessage = loginPage.incorrectEmailPassMessage.getText();
        Assert.assertEquals(errorMessage,"User with email fake@bluerentalcars.com not found");
        ReusableMethods.getScreenshot("NegativeLoginScreenshot");

        Driver.closeDriver();
    }


    @Test
    public void invalidCredsTest() throws IOException {

//        As customer, I should not be able to log in the application
        //going blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

//        click on home page login link
        homePage = new HomePage();
        loginPage= new LoginPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();

//        sending credentials and clicking on login button
        ReusableMethods.waitFor(3);

//        Customer email: fake@bluerentalcars.com
//        Customer password: fakepass
        faker=new Faker();
        String fakeEmail = faker.internet().emailAddress();
        loginPage.email.sendKeys(fakeEmail);
        ReusableMethods.waitFor(3);
        loginPage.pwd.sendKeys(faker.internet().password(4,6));//fake pass 4-6 digit
        ReusableMethods.waitFor(3);
        loginPage.login.click();
        ReusableMethods.waitFor(3);

//        Error: User with email fake@bluerentalcars.com not found
        String errorMessage = loginPage.incorrectEmailPassMessage.getText();
        Assert.assertEquals(errorMessage,"User with email "+fakeEmail+" not found");
        ReusableMethods.getScreenshot("NegativeLoginScreenshot");
        Driver.closeDriver();
    }
}
