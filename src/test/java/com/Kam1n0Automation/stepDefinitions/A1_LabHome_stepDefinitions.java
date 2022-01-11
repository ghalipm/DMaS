package com.Kam1n0Automation.stepDefinitions;

import com.Kam1n0Automation.pages.HomePage;
import com.Kam1n0Automation.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class A1_LabHome_stepDefinitions {
    HomePage homePage=new HomePage();

    @When("user click Data Mining and Security Lab - McGill University link")
    public void user_click_data_mining_and_security_lab_mc_gill_university_link() {

        homePage.dmasLabLink.click();

    }

    @Then("user see url title includes lab title")
    public void user_see_url_title_includes_lab_title() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dmas.lab"));
    }

}
