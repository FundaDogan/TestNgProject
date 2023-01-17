package techproed.tests;

import org.testng.annotations.*;

public class Day16_Annotations {
    /*
    suite > test > group > class > method
    @Test : creates test case
    @Before and @After : 10 Before and After annotations are used to control FLOW and DESIGN of the tests.
    @Ignore : skip test case
    @Test(enable=false) : Disable the test case. By default, enable=true.
    @Test(priority=number) : prioritize/order test case execution.
    NOTE: Tests that has no priority parameter, has a priority of 0. Test(priority=0)
    test execute in alphabetical order.
    -3,0(Also tests with no priority),4,9...ascending order.
    don't give same priority.
    if no priority , tests will run in alphabetical order.
     */
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("Before Suit");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suit");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @Test(priority = 2)
    public void test1() {
        System.out.println("test1");
    }
    @Ignore
    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test(enabled = false)
    public void test3() {
        System.out.println("test3");
    }

    @Test(priority = 3)
    public void test4() {
        System.out.println("test4");
    }

    @Test(priority = 1,groups = "minor-regression-group")
    public void test5() {
        System.out.println("test5");
    }

    @Test(groups = "minor-regression-group")
    public void test6() {
    }
}
