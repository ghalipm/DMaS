package com.Kam1n0Automation.stepDefinitions;

import com.Kam1n0Automation.pages.LoginPage;
import com.Kam1n0Automation.utilities.BrowserUtils;
import com.Kam1n0Automation.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ResultsFileDeleting_stepDefinitions {

    LoginPage loginPage = new LoginPage();
    Random random=new Random();

    // Initial number of ResultFiles before deleting:
    int initialNumberOfResultFiles=loginPage.permanentLinksListForResultFiles.size();

    int indexForResultFiles=0;

    List<String> oldListOfResultFiles=new ArrayList<>();
    List<String> newListOfResultFiles=new ArrayList<>();

    int newNumberOfResultFiles=0;
    String toBeDeletedResultFile="";

    // start working here and remember just like how it is done in
    // EditResultFiles, File Type: null should be excluded if any (not deletable)

    @Then("user can delete the result file by clicking the DELETE button and")
    public void user_can_delete_the_result_file_by_clicking_the_delete_button_and() {

        if (initialNumberOfResultFiles > 0){
        // Initial number of ResultFiles before deleting:
        System.out.println(" Number of ResultFiles before deleting = " + initialNumberOfResultFiles );

        //list before deleting:
        for (int i = 0; i < initialNumberOfResultFiles; i++) {
            oldListOfResultFiles.add(loginPage.permanentLinksListForResultFiles.get(i).getText());
        }


        //choosing index to delete for a ResultFile which is not null type
            while (initialNumberOfResultFiles > 0) {
                int appRandomIndex = random.nextInt(initialNumberOfResultFiles);
                if (!loginPage.fileTypesListForResultFiles.get(appRandomIndex).getText().contains("null")) { // problem is here!
                    indexForResultFiles =(appRandomIndex>0)?appRandomIndex:appRandomIndex+1;
                    BrowserUtils.scrollToElement(loginPage.permanentLinksListForResultFiles.get(indexForResultFiles));
                    Assert.assertTrue(loginPage.permanentLinksListForResultFiles.get(indexForResultFiles).isDisplayed());
                    System.out.println("indexForResultFiles = " + indexForResultFiles);
                    System.out.println("There is at least one result file available for editing or deleting.");
                    break;
                }
            }


        // element to be DELETED
         toBeDeletedResultFile=loginPage.permanentLinksListForResultFiles.get(indexForResultFiles).getText();
        System.out.println( " ResultFile chosen for deleting = " + toBeDeletedResultFile);

        // click the DELETE button

        //loginPage.deleteButton.get(indexForResultFiles).submit();// none of click(), submit(), sendKeys() work here!
        //loginPage.deleteButtonForResultFiles.get(indexForResultFiles).sendKeys(Keys.ENTER);// none of click(), submit(), sendKeys() work here!

        // Only Option: using JavascriptExecutor
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click()", loginPage.deleteButtonForResultFiles.get(indexForResultFiles));

        }else {
            System.out.println("No ResultFile is available! First create a result file, then it can be edited or deleted.");
        }

    }

    @Then("click confirm button of the warning alert")
    public void click_confirm_button_of_the_warning_alert() {

        if (initialNumberOfResultFiles > 0) {
            // click confirm button
            loginPage.confirmButtonForResultsFileDeleting.click();

            // number after clicking delete confirm button
            newNumberOfResultFiles = loginPage.permanentLinksListForResultFiles.size();
            System.out.println(" Number of ResultFiles after deleting = " + newNumberOfResultFiles);
        }else {
            System.out.println("No button to click when there is no ResultFile available!");
        }

    }

    @Then("user confirm that the result file is no longer in the list")
    public void user_confirm_that_the_result_file_is_no_longer_in_the_list() {
        if (initialNumberOfResultFiles == 0){
            System.out.println("Nothing to confirm when there is no ResultFile available!");
        }else {
            //list after deleting:
            for (int i = 0; i < newNumberOfResultFiles; i++) {
                newListOfResultFiles.add(loginPage.permanentLinksListForResultFiles.get(i).getText());
                //System.out.println("newListOfApps.get("+i+") = " + newListOfApps.get(i));

            }

            System.out.println("===========================================");
            Assert.assertTrue(oldListOfResultFiles.contains(toBeDeletedResultFile));
            Assert.assertFalse(newListOfResultFiles.contains(toBeDeletedResultFile));
        }
    }



}
