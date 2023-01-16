package techproed.tests.smoketest.reservationtests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Day19_ReservationTest {

    HomePage homePage = new HomePage();
    Faker faker = new Faker();

    @Test
    public void reservationTest(){
//        Given user is on the home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

//        And select a car
        Select carSelect = new Select(homePage.selectACar);
        carSelect.selectByIndex(3);

//        And enter pick up field
        homePage.pickUpLocation.sendKeys(Faker.instance(Locale.CANADA).address().cityName());

//        And enter drop off field
        homePage.dropOfLocation.sendKeys(Faker.instance(Locale.CANADA).address().cityName());

//        pick up date
//        pick up time
//        drop off date
//        drop off time

        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("hhmmaa");
        Calendar calendar=Calendar.getInstance();

//        enter pick up date
        homePage.pickUpDate.sendKeys("10/10/2023");
//        enter pick up hour
        homePage.pickUpTime.sendKeys(simpleDateFormat1.format(calendar.getTime()));
//       enter drop of date
        homePage.dropOffDate.sendKeys("12/11/2023");
//        enter drop of hour
        homePage.dropOffTime.sendKeys(simpleDateFormat1.format(calendar.getTime()));


//        homePage.pickUpTime.sendKeys("07:00");
//        And click continue reservation
//        And verify complete reservation screen pops up
//        And enter card number
//        And enter name on the card
//        And enter expire date and CVC
//        And checks the agreement
//        And click complete reservation
//        Then verify ‘Reservation created successfully’ pop up
//        And naviaged to Reservations screen
//        And verify the last reservation is created
//        When you click on the last reservation
//        Then verify reservation detail page is displayed
//        And verify the table has the following fields: Model, Doors, Seats, Luggage, Transmission, Air Conditioning, Fuel Type, Age
//        And click on back to reservations
//        And verify Reservations page is displayed
//        And click on Home link
//        Then verify the home page is displayed
    }
}
