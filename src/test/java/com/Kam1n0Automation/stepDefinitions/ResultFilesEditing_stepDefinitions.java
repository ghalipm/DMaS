package com.Kam1n0Automation.stepDefinitions;

import com.Kam1n0Automation.pages.LoginPage;
import com.Kam1n0Automation.utilities.BrowserUtils;
import com.Kam1n0Automation.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.Random;

public class ResultFilesEditing_stepDefinitions {


    LoginPage loginPage = new LoginPage();
    Random random=new Random();

    int initialNumberOfResultFiles=loginPage.permanentLinksListForResultFiles.size();
    int indexForResultFiles=0;

    String oldName="";
    String newName="";

    @When(": a result file is available")
    public void a_result_file_is_available() {
        //choosing index to delete for a ResultFile which is not null type
        if (initialNumberOfResultFiles > 0) {
            while (initialNumberOfResultFiles > 0) {
                int appRandomIndex = random.nextInt(initialNumberOfResultFiles);
                if (!loginPage.fileTypesListForResultFiles.get(appRandomIndex).getText().contains("null")) { // problem is here!
                    indexForResultFiles = appRandomIndex;
                    BrowserUtils.scrollToElement(loginPage.permanentLinksListForResultFiles.get(indexForResultFiles));
                    Assert.assertTrue(loginPage.permanentLinksListForResultFiles.get(indexForResultFiles).isDisplayed());
                    System.out.println("There is at least one ResultFile available for editing or deleting.");
                    System.out.println("The ResultFile to be treated = " + loginPage.permanentLinksListForResultFiles.get(indexForResultFiles).getText());
                    break;
                }
            }
        }else {
            System.out.println("A ResultFile is not available! First create a result file, then you can edit or delete.");
        }

    }


    @Then("user can edit a result file by changing the name of the file")
    public void user_can_edit_a_result_file_by_changing_the_name_of_the_file() {

        // click the edit button of the result file
        //loginPage.editButtonListForResultFiles.get(indexForResultFiles).click(); // none of SendKey() or submit() worked

        // Only Option: using JavascriptExecutor
        if(initialNumberOfResultFiles==0){
            System.out.println("There is no ResultFile to edit or delete!");
        }else {
            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].click()", loginPage.editButtonListForResultFiles.get(indexForResultFiles));

            // modification on the file name

            String resultFileName = loginPage.permanentLinksListForResultFiles.get(indexForResultFiles).getText();
            //System.out.println("Result file name before editing = " + resultFileName);
            oldName = resultFileName;

            // clear the name of the file by clicking the X sign button
            loginPage.clearXForResultsFileEditing.click();
            BrowserUtils.wait(1);

            // modified name
            String resultFileNameModified = "Mod" + resultFileName;
            //System.out.println("resultFileNameModified = " + resultFileNameModified);
            newName = resultFileNameModified;

            // write the new name
            loginPage.editableTextBoxForResultsFileEditing.sendKeys(resultFileNameModified);

            // confirm the modification
            loginPage.checkBoxEditableTextBoxForResultsFileEditing.click();
        }


    }

    @Then("user see the name of the file is changed")
    public void user_see_the_name_of_the_file_is_changed() {

        if(initialNumberOfResultFiles==0){
            System.out.println("There is nothing to see: no ResultFile edited or deleted!");
        }else {

            System.out.println("oldName = " + oldName);
            System.out.println("newName = " + newName);
            Assert.assertNotEquals("ResultFile name is not changed! ", newName, oldName);
        }

    }


}
