package com.Kam1n0Automation.stepDefinitions;

import com.Kam1n0Automation.pages.LoginPage;
import com.Kam1n0Automation.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.Random;
import java.util.Set;

import static com.Kam1n0Automation.utilities.Driver.getDriver;

public class ResultFilesCheckingDetails_stepDefinitions {

    LoginPage loginPage = new LoginPage();
    Random random=new Random();

    int numOfResultFiles=loginPage.permanentLinksListForResultFiles.size();
    int indexForResultFiles=0;

    @Then("user click a result file link")
    public void user_click_a_result_file_link() {

        //choosing index to delete for a ResultFile which is not null type
        if (numOfResultFiles > 0) {
            while (numOfResultFiles > 0) {
                int appRandomIndex = random.nextInt(numOfResultFiles);
                if (!loginPage.fileTypesListForResultFiles.get(appRandomIndex).getText().contains("null")) { // null is the problem!
                    indexForResultFiles = appRandomIndex;
                    break;
                }
            }

            // click a permanent link to open a new page/window
            String mainHandle = getDriver().getWindowHandle();
            BrowserUtils.clickWithJS(loginPage.permanentLinksListForResultFiles.get(indexForResultFiles));
            Set<String> handles = getDriver().getWindowHandles();

            // need to switch to the new window using Window handle to see items on the new Window
            for (String handle : handles) {

                if (!handle.equals(mainHandle)) {
                    // moved from mainWindow to the second Window
                    getDriver().switchTo().window(handle);
                    break;
                }
            }

            Assert.assertTrue(loginPage.headerForPermanentLinkResultFiles.isDisplayed());
            BrowserUtils.wait(1);
            Assert.assertTrue("Failed to show the header!", loginPage.headerForPermanentLinkResultFiles.getText().contains("SUMMARY"));

        }else{
            System.out.println("First create a result file, then you can edit, delete the file or view its details.");
        }
    }

    @Then("user click details and click one of the functions in the list")
    public void user_click_details_and_click_one_of_the_functions_in_the_list() {
        if(numOfResultFiles>0) {
            BrowserUtils.wait(1);
            loginPage.detailsInHeaderForPermanentLinkResultFiles.click();
            BrowserUtils.wait(2);
            loginPage.rowOneOfDetailsForPermanentLinkResultFiles.click();
        }else{
            System.out.println("Nothing to click when there is no ResultFile available");
        }

    }

    @Then("user see the effective address")
    public void user_see_the_effective_address() {
        if(numOfResultFiles==0){
            System.out.println("There is nothing to see: no ResultFile edited or deleted!");
        }else {
            BrowserUtils.wait(1);
            Assert.assertTrue(loginPage.treeAnchorOfRowOfDetailsForPermanentLinkResultFiles.getText().contains("effective address"));
        }

    }



}
