package com.Kam1n0Automation.stepDefinitions;

import com.Kam1n0Automation.pages.LoginPage;
import com.Kam1n0Automation.utilities.BrowserUtils;
import com.Kam1n0Automation.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.io.File;
import java.util.Random;
import java.util.Set;

import static com.Kam1n0Automation.utilities.Driver.getDriver;

public class B20_AMS_CloneApplications_stepDefinitions {

    LoginPage loginPage=new LoginPage();
    Random random=new Random();

    int numOfApplicationFiles=loginPage.applicationPermanentLinks.size();
    // choose an index for an application file of Type 2 for Indexing:
    int indexForApplicationFileForIndexing=0;

    @When("user click a permanent link of Type {int} application")
    public void user_click_a_permanent_link_of_type_application(Integer typeInt) {
        // match the typeName with the typeInt:
        String typeName=(typeInt==1)?"asm2vec-clone":(typeInt==2)?"asm-clone":(typeInt==3)?"sym1n0-clone":"ExecutableClassification";

        // choose indexForApplicationFileForIndexing from the application files:
        while(numOfApplicationFiles>0){
            int appRandomIndex= random.nextInt(numOfApplicationFiles);
            if( loginPage.applicationPermanentLinks.get(appRandomIndex).getText().contains(typeName)) {
                indexForApplicationFileForIndexing = appRandomIndex;
                break;
            }
        }
        Assert.assertTrue(loginPage.applicationPermanentLinks.get(indexForApplicationFileForIndexing).getText().contains(typeName));
        System.out.println("Chosen application permanent link for indexing: "+loginPage.applicationPermanentLinks.get(indexForApplicationFileForIndexing).getText());
        //click the permanent link chosen
        loginPage.applicationPermanentLinks.get(indexForApplicationFileForIndexing).click();

    }

    @Then("user click delete temporary files Tab")
    public void user_click_delete_temporary_files_tab() {
        loginPage.deleteTmpFilesTab.click();
    }

    @Then("user click delete button if there is any files")
    public void user_click_delete_button_if_there_is_any_files() {

        // click delete button if there is any files
        if(loginPage.tmpFilesContainerForDeleteTmpFiles.getText().equals("No file in tmp directory!")){
            System.out.println("Nothing to delete in temporary files folder!");
        }else{
            loginPage.deleteButtonForDeleteTmpFilesTab.sendKeys(Keys.ENTER);
            BrowserUtils.waitForClickability(loginPage.confirmButtonForDeleteTmpFilesAlert,3);
            loginPage.confirmButtonForDeleteTmpFilesAlert.sendKeys(Keys.ENTER);
        }

    }

    @Then("user see Indexing Tab in the Tasks")
    public void user_see_indexing_tab_in_the_tasks() {
        BrowserUtils.waitForClickability(loginPage.indexingTab,5);
        Assert.assertTrue(loginPage.indexingTab.isDisplayed());
    }

    @Then("user click Indexing Tab")
    public void user_click_indexing_tab() {
        loginPage.indexingTab.sendKeys(Keys.ENTER);
    }

    @Then("user drag two files from one of the class types into dropFile area")
    public void user_drag_two_files_from_one_of_the_class_types_into_drop_file_area() {

        // option1:
        //File file0=new File("malwareclasses/autoit/autoit_8fc2784ac119e5bd441218c7e43268977c6a5d63697d43ea9a21a929ac3ab76c.tmp0.json");
        //File file1=new File("malwareclasses/autoit/autoit_2dea6e440788e160217fd9fd0b4a30f97e86dbf01797f8cf6527bedb468e937b.tmp0.json");

        // option2: both work.
        File file0=new File("malwareclasses\\autoit\\autoit_8fc2784ac119e5bd441218c7e43268977c6a5d63697d43ea9a21a929ac3ab76c.tmp0.json");
        File file1=new File("malwareclasses\\autoit\\autoit_2dea6e440788e160217fd9fd0b4a30f97e86dbf01797f8cf6527bedb468e937b.tmp0.json");

        BrowserUtils.scrollToElement(loginPage.dropFileZone);
        BrowserUtils.wait(2);

        // dropFileZone caused many days (4-5) of delay (not uploading the files!):
        // different identification solved the problem
        BrowserUtils.dropFile(file0, loginPage.dropFileZone, 3);
        BrowserUtils.dropFile(file1, loginPage.dropFileZone, 3);

    }

    @Then("user click Index button")
    public void user_click_index_button() {

        loginPage.indexButton.sendKeys(Keys.ENTER);
    }

    @Then("user see Indexing Completed message")
    public void user_see_indexing_completed_message() {
        BrowserUtils.waitForVisibility(loginPage.indexingCompletedMessage,75);
        if (!loginPage.indexingCompletedMessage.isDisplayed()) {
            BrowserUtils.waitForClickability(loginPage.indexingAlertCloseButton, 75);
            loginPage.indexingAlertCloseButton.sendKeys(Keys.ENTER);
            BrowserUtils.waitForClickability(loginPage.indexButton, 5);
            loginPage.indexButton.sendKeys(Keys.ENTER);
            BrowserUtils.waitForVisibility(loginPage.indexingCompletedMessage, 75);
        }
        Assert.assertTrue(loginPage.indexingCompletedMessage.isDisplayed());

    }

    @Then("user click close button")
    public void user_click_close_button() {
        loginPage.indexingCompleteCloseButton.sendKeys(Keys.ENTER);
    }

    /**
     * Below is about Function Search:
     */

    @When("user click Function Search in the Tasks Tab")
    public void user_click_function_search_in_the_tasks_tab() {
        BrowserUtils.scrollToElement(loginPage.functionSearchTab);
        Assert.assertTrue(loginPage.functionSearchTab.isDisplayed());
        loginPage.functionSearchTab.sendKeys(Keys.ENTER);
    }

    @When("user click the Example field and select available binary file")
    public void user_click_the_example_field_and_select_available_binary_file() {
        loginPage.functionSearchSelectingFile();
    }

    String mainHandle=getDriver().getWindowHandle();

    @When("select some options and click search button")
    public void select_some_options_and_click_search_button() {
        BrowserUtils.waitForClickability(loginPage.functionSearch_SearchButton,5);
        Assert.assertTrue(loginPage.functionSearch_SearchButton.isEnabled());
        int initalHandleCount = getDriver().getWindowHandles().size();
        String mainWindow = getDriver().getWindowHandle();
        System.out.println("initalHandleCount before click = " + initalHandleCount);
        System.out.println("mainWindow = " + mainWindow);
        loginPage.functionSearch_SearchButton.click();
    }

    @When("user see Clone Graph")
    public void user_see_clone_graph() {
        // window handle of the "Search in progress" window, took a day to handle !
        int initalHandleCount = getDriver().getWindowHandles().size();
        System.out.println("handleCount after click = " + initalHandleCount);

        Set<String> handles = getDriver().getWindowHandles();
         mainHandle=getDriver().getWindowHandle();

        System.out.println(" main WindowHandle() = " + getDriver().getWindowHandle());
        System.out.println("CurrentUrl = " + getDriver().getCurrentUrl());
        System.out.println("getDriver().getWindowHandles() = " + getDriver().getWindowHandles());

        for (String handle : handles) {
            if ( !handle.equals(mainHandle)) {
                // moved from mainWindow to the second Window
                getDriver().switchTo().window(handle);
                break;
            }
        }

        BrowserUtils.waitForVisibility(loginPage.functionSearchCloneGraphNote,5);
        Assert.assertTrue(loginPage.functionSearchCloneGraphNote.getText().contains("Searching in Progress"));
        System.out.println("First child Window message = " + loginPage.functionSearchCloneGraphNote.getText());

        //System.out.println("From the first child window, try to get windowHandle for the second child!");

        // needed to move to the third Window (The second child).
        // But how? Wait a second and then ask again. That is it!

        BrowserUtils.wait(10); // if many files or too large a file,
        // then may need to increase the wait time
        Set<String> newHandles = getDriver().getWindowHandles();
        System.out.println("newHandles = " + newHandles);

        initalHandleCount = getDriver().getWindowHandles().size();
        System.out.println("handleCount after Sleep = " + initalHandleCount);

        newHandles.removeAll(handles);

        for (String handle : newHandles) {
            if ( !handle.equals(mainHandle)) {
                // moved from mainWindow to the second Window
                getDriver().switchTo().window(handle);
                break;
            }
        }

        System.out.println("After removing handles from newHandles");
        System.out.println("firstChildHandle = " + newHandles);

        BrowserUtils.waitForClickability(loginPage.functionSearchCloneGraphNote,15);
        Assert.assertTrue(loginPage.functionSearchCloneGraphNote.getText().contains("Clone Graph"));
        System.out.println("Second child Window message = " + loginPage.functionSearchCloneGraphNote.getText());

        // first node:
        BrowserUtils.waitForClickability(loginPage.functionSearchGraphNode,15);
        loginPage.functionSearchGraphNode.click();
        // second node:
        BrowserUtils.waitForClickability(loginPage.functionSearchGraphSubNode,15);
        loginPage.functionSearchGraphSubNode.click();

    }

    @When("user see different views depending on the type of application")
    public void user_see_different_views_depending_on_the_type_of_application() {
        // Function Search works for 3 types of applications: asm-clone, sym1n0-clone, asm2vec-clone
        // Each clone view is different.
        if(Driver.getDriver().getCurrentUrl().contains("asm2vec-clone")){
            // get the window handles before clicking on the view:
            Set<String> handles = getDriver().getWindowHandles();

            BrowserUtils.waitForClickability(loginPage.asm2vecFunctionSearchGraphView,25);
            BrowserUtils.clickWithJS(loginPage.asm2vecFunctionSearchGraphView);

            //after click, now new window opens up, so need to switch to the new window
            Set<String> newHandlesView1 = getDriver().getWindowHandles();
            System.out.println("newHandlesView1 = " + newHandlesView1);

            newHandlesView1.removeAll(handles);
            for (String handle : newHandlesView1) {
                // moved from mainWindow to the second Window
                getDriver().switchTo().window(handle);
                break;
            }

            Assert.assertTrue(loginPage.asm2vecFunctionSearchFlowGraphViewTitle.getText().contains("Flow Graph View"));
        }

        if(Driver.getDriver().getCurrentUrl().contains("asm-clone")){

            // get the window handles before clicking on the view:
            Set<String> handles = getDriver().getWindowHandles();

            BrowserUtils.waitForClickability(loginPage.asmCloneFunctionSearchGraphView,15);
            BrowserUtils.clickWithJS(loginPage.asmCloneFunctionSearchGraphView);

            //after click, now new window opens up, so need to switch to the new window
            Set<String> newHandlesView1 = getDriver().getWindowHandles();
            System.out.println("newHandlesView1 = " + newHandlesView1);

            newHandlesView1.removeAll(handles);
            for (String handle : newHandlesView1) {
                // moved from mainWindow to the second Window
                getDriver().switchTo().window(handle);
                break;
            }

            Assert.assertTrue(loginPage.asmCloneFunctionSearchGraphViewTitle.getText().contains("Flow Graph View"));

            //the other views need to be shown

        }

        if(Driver.getDriver().getCurrentUrl().contains("sym1n0-clone")){
            BrowserUtils.waitForClickability(loginPage.sym1n0FunctionSearchFlowGraphView,15);
            // get the window handles before clicking on the view:
            Set<String> handles = getDriver().getWindowHandles();

            BrowserUtils.waitForClickability(loginPage.sym1n0FunctionSearchFlowGraphView,15);
            loginPage.sym1n0FunctionSearchFlowGraphView.click();

            //now new window opens up, so need to switch to the new window
            //after click, now new window opens up, so need to switch to the new window
            Set<String> newHandlesView1 = getDriver().getWindowHandles();
            System.out.println("newHandlesView1 = " + newHandlesView1);

            newHandlesView1.removeAll(handles);
            for (String handle : newHandlesView1) {
                // moved from mainWindow to the second Window
                getDriver().switchTo().window(handle);
                break;
            }
            Assert.assertTrue(loginPage.sym1n0FunctionSearchFlowGraphViewTitle.getText().contains("Flow Graph View"));
        }

        BrowserUtils.wait(3); // must be removed later
        //to be able to click BinaryComposition Tab, must go to the main window
        getDriver().switchTo().window(mainHandle);

    }


    /**
     * Below is for BinaryComposition
     */

    @When("user click BinaryComposition Tab")
    public void user_click_binary_composition_tab() {
        loginPage.binaryCompositionTab.sendKeys(Keys.ENTER);
    }

    @When("user drag three files from one of the class types into dropFile area")
    public void user_drag_three_files_from_one_of_the_class_types_into_drop_file_area() {
        File file2=new File("malwareclasses\\gamarue\\gamarue_0907ed349df66da469c43efe50459ac375e555a902febac10faf99ed157b53d8.tmp0.json");
        File file3=new File("malwareclasses\\gamarue\\gamarue_67890d0062c0665563aaf203c5e9dca062899cf8746df93b487514cccc5ebcee.tmp0.json");
        File file4=new File("malwareclasses\\gamarue\\gamarue_420c37e3c877563ae548313c81a46fce2e5e74d4d490d57d1f2ec38d9e14c018.tmp0.json");

        BrowserUtils.scrollToElement(loginPage.dropFileZoneForBinaryComposition);
        BrowserUtils.wait(2);

        // dropFileZone caused many days (4-5) of delay (not uploading the files!):
        // different identification solved the problem
        BrowserUtils.dropFile(file2, loginPage.dropFileZoneForBinaryComposition, 3);
        BrowserUtils.dropFile(file3, loginPage.dropFileZoneForBinaryComposition, 3);
        BrowserUtils.dropFile(file4, loginPage.dropFileZoneForBinaryComposition, 3);
        BrowserUtils.wait(5);

    }


    @When("user click Analyze button")
    public void user_click_analyze_button() {
        BrowserUtils.hover(loginPage.analyzeButton);
        loginPage.analyzeButton.sendKeys(Keys.ENTER);
    }

    @When("user see Composition analysis Completed message")
    public void user_see_composition_analysis_completed_message() {
        BrowserUtils.waitForVisibility(loginPage.binaryCompositionAnalysisCompletedMessage,180);
        loginPage.binaryCompositionAnalysisCompletedMessage.isDisplayed();
    }

    @When("user click close button for Binary Composition")
    public void user_click_close_button_for_binary_composition() {
        loginPage.binaryCompositionAnalysisCompletedCloseButton.sendKeys(Keys.ENTER);
    }


}
