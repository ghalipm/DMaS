package com.Kam1n0Automation.stepDefinitions;

import com.Kam1n0Automation.pages.LoginPage;
import com.Kam1n0Automation.utilities.BrowserUtils;
import com.Kam1n0Automation.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class DeletingApplication_stepDefinitions {

    LoginPage loginPage = new LoginPage();
    Random random=new Random();

    WebElement permanentLinkForDeleting;
    
    int numberOfAllAppsAndResultFiles=loginPage.applicationNameList.size()-2; //
    // in this number,  one in the app and one in the resultfiles are added up.

    // total number of resultFiles
    int numberOfResultFiles=loginPage.permanentLinksListForResultFiles.size();

    // choose an index for a delete button of an application file
    int applicationIndexForApplicationFiles= random.nextInt( loginPage.deleteButtonForAppFiles.size() );
    //int applicationIndex=3;
    // starts from index 1. Want to have some number of apps in the list.

    //deleting an application:
    // here: Application index for deleting only.
    @Then("user can delete the application by providing application name and password")
    public void user_can_delete_the_application_by_providing_application_name_and_password() {

        System.out.println("numberOfAllAppsAndResultFiles = " + numberOfAllAppsAndResultFiles);
        System.out.println("numberOfResultFiles = " + numberOfResultFiles);
        Assert.assertEquals(numberOfAllAppsAndResultFiles, numberOfResultFiles + loginPage.permanentLinksListForApplicationFiles.size() );

        System.out.println("Application index for deleting = " + applicationIndexForApplicationFiles);

        System.out.println( loginPage.deleteButtonForAppFiles.get(applicationIndexForApplicationFiles).getText() + " button No."+ applicationIndexForApplicationFiles+ " is clicked.");

        loginPage.deleteButtonForAppFiles.get(applicationIndexForApplicationFiles).click(); // works well
        //loginPage.deleteButtonForAppFiles.get(applicationIndex).sendKeys(Keys.CLEAR); // did not work!

        String thePermanentLinkName=loginPage.permanentLinksListForApplicationFiles.get(applicationIndexForApplicationFiles).getText();
        System.out.println("thePermanentLinkName = " + thePermanentLinkName);
        permanentLinkForDeleting=loginPage.permanentLinksListForApplicationFiles.get(applicationIndexForApplicationFiles);

        //String applicationName=loginPage.applicationNameList.get(applicationIndexForApplicationFiles-4).getText();
        String applicationName=loginPage.applicationNameList.get(applicationIndexForApplicationFiles+1).getText();
        System.out.println(" Permanent link name = " + applicationName);

        //Assert.assertEquals("applicationName causing problems", applicationName, "" + applicationName);
        loginPage.applicationNameFieldForDeleting.sendKeys(applicationName);
        BrowserUtils.waitForClickability(loginPage.passwordFieldForDeleting,1);
        loginPage.passwordFieldForDeleting.sendKeys(ConfigurationReader.getProperty("password"));

    }

    @Then("user click confirm or close button and to finish or abort deleting")
    public void user_click_confirm_or_close_button_and_to_finish_or_abort_deleting() throws InterruptedException {
        loginPage.finishDeleting(applicationIndexForApplicationFiles-1);

        Assert.assertFalse(loginPage.applicationNameList.contains(permanentLinkForDeleting));

        BrowserUtils.waitForVisibility(loginPage.applicationNameList.get(applicationIndexForApplicationFiles),2);

        Assert.assertTrue("Failed to go back onto Application List", loginPage.applicationNameList.get(applicationIndexForApplicationFiles).isDisplayed());

    }



}
