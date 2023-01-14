package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class LoginPage {
    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "formBasicEmail")
    public WebElement email;

    @FindBy(id = "formBasicPassword")
    public WebElement pwd;

    @FindBy(xpath = " //button[text()=' Login']")
    public WebElement login;

    @FindBy(xpath = "//*[text()='Bad credentials']")
    public WebElement alert;

    @FindBy(xpath = "//*[text()='email must be a valid email']")
    public WebElement invalidEmailMessage;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement incorrectEmailPassMessage;

}
