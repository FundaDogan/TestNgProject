package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class XYZBankCustomerPage {
    public XYZBankCustomerPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "userSelect")
    public WebElement yourNameDropDown;

    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    public WebElement depositButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    public WebElement amountToBeDepositedInput;

}
