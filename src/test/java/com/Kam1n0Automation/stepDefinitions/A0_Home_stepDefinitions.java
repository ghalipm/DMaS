package com.Kam1n0Automation.stepDefinitions;

import com.Kam1n0Automation.pages.HomePage;
import com.Kam1n0Automation.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Assert;



import static com.Kam1n0Automation.utilities.Driver.*;

public class A0_Home_stepDefinitions {
    HomePage homePage=new HomePage();

    /*
    Repeated implementation is absolute TABU! Try it and see what happens!
    In Cucumber working in collaboration, no two person should work on the same thing!
     */

    @Given("user is on kam1n0 home page")
    public void user_is_on_kam1n0_home_page() {
        // Write code here that turns the phrase above into concrete actions
        getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Then("user see Kam1n0 header")
    public void user_see_kam1n0_header() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("homePage.mainPageHeader.getText() = " + homePage.mainPageHeader.getText());

        Assert.assertTrue(homePage.mainPageHeader.getText().trim().equals("Kam1n0 {Pro}"));
    }


}
