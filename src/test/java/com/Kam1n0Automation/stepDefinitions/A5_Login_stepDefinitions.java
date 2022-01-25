package com.Kam1n0Automation.stepDefinitions;

import com.Kam1n0Automation.pages.HomePage;
import com.Kam1n0Automation.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.Kam1n0Automation.utilities.Driver.getDriver;

public class A5_Login_stepDefinitions {

    // Login function:
    @When("user clicks login tab")
    public void user_clicks_login_tab()  {
        // create or keep the object in the method unless it is used more than once.
        HomePage homePage=new HomePage();
        homePage.loginTab.click();

    }

    @Then("user lands at login page")
    public void user_lands_at_login_page() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("login"));
    }


    @Then("with username and password user login to Kam1n0.")
    public void with_username_and_password_user_login_to_kam1n0()  {
        LoginPage loginPage=new LoginPage();
        loginPage.login();
    }


}
