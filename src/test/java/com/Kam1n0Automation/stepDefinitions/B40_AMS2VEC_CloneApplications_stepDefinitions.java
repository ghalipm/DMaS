package com.Kam1n0Automation.stepDefinitions;

import com.Kam1n0Automation.pages.LoginPage;
import io.cucumber.java.en.Then;

public class B40_AMS2VEC_CloneApplications_stepDefinitions {

    @Then("user click RebuildIndex button")
    public void user_click_rebuild_index_button() {
        LoginPage loginPage=new LoginPage();
        loginPage.rebuildIndexButton.click();
    }

}
