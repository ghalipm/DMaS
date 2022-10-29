package com.Kam1n0Automation.stepDefinitions;

import com.Kam1n0Automation.pages.LoginPage;
import com.Kam1n0Automation.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class B50_ExecutableClassification_Applications_stepDefinitions {
    LoginPage loginPage=new LoginPage();

    @Then("user click Run button")
    public void user_click_run_button() {
        loginPage.runButtonForIndexingExecutableClassification.sendKeys(Keys.ENTER);
    }

    @Then("user see Indexing Completed message for ExecutableClassification")
    public void user_see_indexing_completed_message_for_executable_classification() {
        BrowserUtils.waitForVisibility(loginPage.indexingCompletedMessageForExecClass, 75);
        loginPage.indexingCompletedMessageForExecClass.isDisplayed();
    }

    @When("user click Classification in the Tasks Tab")
    public void user_click_classification_in_the_tasks_tab() {
        loginPage.classificationTab.sendKeys(Keys.ENTER);
    }

    @When("user see Classification Completed message")
    public void user_see_classification_completed_message() {
        BrowserUtils.waitForVisibility(loginPage.classificationCompletedMessage,85);
        Assert.assertTrue(loginPage.classificationCompletedMessage.isDisplayed());
    }

    @When("user click close button for Classification")
    public void user_click_close_button_for_classification() {
        loginPage.classificationCompletionCloseButton.sendKeys(Keys.ENTER);
    }


}
