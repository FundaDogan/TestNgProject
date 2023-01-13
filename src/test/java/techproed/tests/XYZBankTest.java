package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.XYZBankCustomerPage;
import techproed.pages.XYZBankHomePage;
import techproed.pages.XYZBankManagerPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class XYZBankTest {

    //Open 5 new Accounts, deposit 100 USD and withdraw 100 USD from any account and delete all accounts.

    /*
    Given
        Go to "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"
    When
        Click on "Bank Manager Login"
    And
        Click on "Add Customer" button
     And
         Fill inputs and click on "Add Customer" submit button
    And
        Accept alert
    And
        Add 4 more customers
    And
        Click on "Open Account"  button
    And
        Click on "Customer" dropdown
    And
        Select customer name
    And
        Click on "Currency" dropdown
    And
        Select "Dollar"
    And
        Click on "Process" button
    And
        Accept alert
    And
        Open 4 more accounts
    And
        Click on "Customers" button
    And
        Count table row numbers
    Then
        Assert that you created 5 customers
    When
        Click on "Home" button
    And
        Click on "Customer Login" button
    And
        Click on "Your Name" dropdown
    And
        Select the any name you created
    And
        Click on "Login" button
    And
        Click on "Deposit" button
    And
        Type 100 into "Amount to be Deposited" input
    Then
        Click on "Deposit"(Submit) button
     And
        Assert that "Deposit Successful" is displayed


    And
        Click on "Withdrawal" button
    And
        Type 100 into "Amount to be Withdrawn" input
    And
        Click on "Withdraw"(Submit) button
    Then
        Assert that "Transaction  Successful" is displayed
    When
        Click on "Logout" button
    And
        Click on "Home" button
    And
        Click on "Bank Manager Login" button
    And
        Click on "Customers" button
    And
        Click on each "Delete" button
    And
        Count table row numbers
    Then
        Assert that number of customers is 0

     */



    @Test
    public void xyzBanktest() {

//        Go to "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"
        Driver.getDriver().get(ConfigReader.getProperty("xyz_bank_url"));

        //        Click on "Bank Manager Login"

        XYZBankHomePage xyzBankHomePage = new XYZBankHomePage();
        xyzBankHomePage.bankManagerLoginButton.click();

//        Click on "Add Customer" button
        XYZBankManagerPage xyzBankManagerPage = new XYZBankManagerPage();
        xyzBankManagerPage.addCustomerButton.click();

//        Fill inputs and click on "Add Customer" submit button

        //        Add 4 more customers
        Faker faker = new Faker();

        for (int i=0 ;i<5; i++){

            xyzBankManagerPage.firstnameInput.sendKeys(faker.name().firstName());
            xyzBankManagerPage.lastnameInput.sendKeys(faker.name().lastName());
            xyzBankManagerPage.postCodeInput.sendKeys(faker.address().zipCode());
            xyzBankManagerPage.addCustomerSubmitButton.click();

//        Accept alert

            try {
                Driver.getDriver().switchTo().alert().accept();

                //test failed in here : UnhandledAlertException  solution we ignored it with try catch
            }catch (Exception ignored){

            }
        }


//        Click on "Open Account"  button
        xyzBankManagerPage.openAccountButton.click();


//        Click on "Customer" dropdown
        // select customer name
        Select select = new Select(xyzBankManagerPage.customerDropDown);
        Select select1 = new Select(xyzBankManagerPage.currencyDropDown);

        //        Open 4 more accounts

        for (int i =6; i<11; i++){
            select.selectByIndex(6);

//        Select "Dollar"

            select1.selectByIndex(1);

//        Click on "Process" button
            xyzBankManagerPage.processSubmitButton.click();

//        Accept alert
            try {
                Driver.getDriver().switchTo().alert().accept();
            }catch (Exception ignored){

            }

        }

        //        Click on "Customers" button
            xyzBankManagerPage.customersButton.click();

//        Count table row numbers
            int numOfRows = xyzBankManagerPage.numberOfRows.size();

//        Assert that you created 5 customers
        Assert.assertEquals(10,numOfRows);

//        Click on "Home" button
        xyzBankManagerPage.homeButton.click();

//        Click on "Customer Login" button
        xyzBankHomePage.customerLoginButton.click();

//        Click on "Your Name" dropdown
//        Select the any name you created
        XYZBankCustomerPage xyzBankCustomerPage = new XYZBankCustomerPage();
        Select select2 = new Select(xyzBankCustomerPage.yourNameDropDown);
        select2.selectByIndex(6);

//        Click on "Login" button
        xyzBankCustomerPage.loginButton.click();

//        Click on "Deposit" button
        xyzBankCustomerPage.depositButton.click();

//        Type 100 into "Amount to be Deposited" input
        xyzBankCustomerPage.amountToBeDepositedInput.sendKeys("100");

//        Assert that "Deposit Successful" is displayed

//        Click on "Deposit"(Submit) button

//        Click on "Withdrawal" button

//        Type 100 into "Amount to be Withdrawn" input

//        Click on "Withdraw"(Submit) button

//        Assert that "Transaction  Successful" is displayed

//        Click on "Logout" button

//        Click on "Home" button

//        Click on "Bank Manager Login" button

//        Click on "Customers" button

//        Click on each "Delete" button

//        Count table row numbers

//        Assert that number of customers is 0


    }















}
