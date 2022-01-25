package com.Kam1n0Automation.stepDefinitions;

import com.Kam1n0Automation.pages.HomePage;
import com.Kam1n0Automation.pages.LoginPage;
import com.Kam1n0Automation.utilities.BrowserUtils;
import com.Kam1n0Automation.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import static com.Kam1n0Automation.utilities.Driver.getDriver;

public class A6_CreatingApplication_stepDefinitions {
    HomePage homePage=new HomePage();
    LoginPage loginPage = new LoginPage();

    // common for all creating, deleting, editing cases:
    @Given(": user login into Kam1n0")
    public void user_login_into_kam1n0()  {
        getDriver().get(ConfigurationReader.getProperty("url"));
        homePage.loginTab.click();
        loginPage.login();
    }

    @When(": user click CREATE AN APPLICATION module")
    public void user_click_create_an_application_module() throws InterruptedException {
        Thread.sleep(1000);// must be taken out later
        loginPage.creatingApplicationTab.click();
    }

    // creating an application: general mode - with random application type
    @When("user choose Application Type, provide application name and description and choose instruction set")
    public void user_choose_application_type_provide_application_name_and_description_and_choose_instruction_set() throws InterruptedException {

        //selecting application type from loginPage.getApplicationTypeIndex()=1,2,3,4:
        int applicationTypeIndex=loginPage.getApplicationTypeIndex();
        switch(applicationTypeIndex){
            // case 1 begins
            case 1:
                //selecting application type(1)
                BrowserUtils.wait(1); // must be taken out later
                loginPage.selectingApplicationTypeByIndex(applicationTypeIndex); // ams2vec-clone
                BrowserUtils.wait(1); // must be taken out later

                // provide name and description of the application
                loginPage.provideNameAndDescriptionByApplicationTypeIndex(applicationTypeIndex);
                BrowserUtils.wait(1); // must be taken out later

                //choice of checking privateApplication checkbox (0 is not checking, 1 is checking)
                loginPage.checkingPrivateApplicationCheckBox();
                BrowserUtils.wait(1); // must be taken out later

                // selecting instructionsSet - choosing one out of 6 options
                loginPage.choosingInstructionSet();
                BrowserUtils.wait(1); // must be taken out later
                break;
            // case 1 is ended

            case 2:
                Thread.sleep(1000); // must be taken out later
                loginPage.selectingApplicationTypeByIndex(applicationTypeIndex); // ams-clone
                BrowserUtils.wait(1); // must be taken out later

                //checking of privateApplication checkbox:
                loginPage.checkingPrivateApplicationCheckBox();
                BrowserUtils.wait(1); // must be taken out later

                // provide name and description of the application
                loginPage.provideNameAndDescriptionByApplicationTypeIndex(applicationTypeIndex);
                BrowserUtils.wait(1); // must be taken out later

                // selecting NormalizationLevel - choosing one out of 5 options
                BrowserUtils.wait(1); // must be taken out later
                loginPage.choosingNormalizationLevel();
                BrowserUtils.wait(1); // must be taken out later

                // selecting instructionsSet - choosing one out of 6 options
                loginPage.choosingInstructionSet();
                BrowserUtils.wait(1); // must be taken out later
                break;
            // case 2 ends here

            case 3:
                BrowserUtils.wait(1); // must be taken out later
                loginPage.selectingApplicationTypeByIndex(applicationTypeIndex); // sym1n0-clone
                BrowserUtils.wait(1); // must be taken out later

                // provide name and description of the application
                loginPage.provideNameAndDescriptionByApplicationTypeIndex(applicationTypeIndex);
                BrowserUtils.wait(1); // must be taken out later

                //checking of privateApplication checkbox:
                loginPage.checkingPrivateApplicationCheckBox();
                BrowserUtils.wait(1); // must be taken out later
                break;
            // case 3 ends here

            case 4:
                BrowserUtils.wait(1); // must be taken out later
                loginPage.selectingApplicationTypeByIndex(applicationTypeIndex); // ams-clone
                BrowserUtils.wait(1); // must be taken out later

                /*
                //checking of privateApplication checkbox:
                loginPage.checkingPrivateApplicationCheckBox();
                BrowserUtils.wait(1); // must be taken out later
                 */

                // provide name and description of the application
                loginPage.provideNameAndDescriptionByApplicationTypeIndex(applicationTypeIndex);
                BrowserUtils.wait(1); // must be taken out later

                // selecting instructionsSet - choosing one out of 6 options
                loginPage.choosingInstructionSet();
                BrowserUtils.wait(1); // must be taken out later
                // write the names of the folders which contains class lists/files as a String.
                loginPage.classFilesUploadField.sendKeys("autoit,emotet,gamarue",Keys.ENTER);
                break;
            // case 4 ends here

        }

    }


    @When("click the create button")
    public void click_the_create_button() {
        loginPage.createButton.click();
    }

    @Then("user lands at application list page and see the options to edit or delete existing applications")
    public void user_lands_at_application_list_page_and_see_the_options_to_edit_or_delete_existing_applications() throws InterruptedException {
        Assert.assertTrue(loginPage.editButton.get(0).getText().contains("EDIT"));
        Assert.assertTrue(loginPage.deleteButton.get(0).getText().contains("DELETE"));
        //loginPage.logout();

    }


    // ams2vec-clone  or type (1) application:
    @When("user choose ams2vec-clone application type, provide name, description and instruction set")
    public void user_choose_ams2vec_clone_application_type_provide_name_description_and_instruction_set() throws InterruptedException {
        Thread.sleep(1000); // must be taken out later
        loginPage.selectingApplicationTypeByIndex(1); // ams2vec-clone
        Thread.sleep(1000); // must be taken out later

        /*
        //checking of privateApplication checkbox
        loginPage.checkingPrivateApplicationCheckBox();
        Thread.sleep(1000);// must be taken out later
         */


        // provide name and description of the application
        loginPage.provideNameAndDescriptionByApplicationTypeIndex(1);
        Thread.sleep(1000); // must be taken out later
        // selecting instructionsSet - choosing one out of 6 options
        loginPage.choosingInstructionSet();
        Thread.sleep(1000); // must be taken out later

    }


    // ams-clone or type (2) application:
    @When("user choose ams-clone application type, provide name, description and instruction set")
    public void user_choose_ams_clone_application_type_provide_name_description_and_instruction_set() throws InterruptedException {
        int applicationTypeIndex=2;
        Thread.sleep(1000); // must be taken out later
        loginPage.selectingApplicationTypeByIndex(applicationTypeIndex); // ams-clone
        Thread.sleep(1000); // must be taken out later

        /*
        //checking of privateApplication checkbox
        loginPage.checkingPrivateApplicationCheckBox();
        Thread.sleep(1000);// must be taken out later
         */

        // provide name and description of the application
        loginPage.provideNameAndDescriptionByApplicationTypeIndex(applicationTypeIndex);
        Thread.sleep(1000); // must be taken out later

        // selecting NormalizationLevel - choosing one out of 5 options
        Thread.sleep(1000); // must be taken out later
        loginPage.choosingNormalizationLevel();
        Thread.sleep(1000); // must be taken out later

        // selecting instructionsSet - choosing one out of 6 options
        loginPage.choosingInstructionSet();
        Thread.sleep(1000); // must be taken out later

    }


    // sym1n0-clone or type (3) application:
    @When("user choose sym1n0-clone application type, provide name and description")
    public void user_choose_sym1n0_clone_application_type_provide_name_and_description() throws InterruptedException {
        int applicationTypeIndex=3;
        Thread.sleep(1000); // must be taken out later
        loginPage.selectingApplicationTypeByIndex(applicationTypeIndex); // sym1n0-clone
        Thread.sleep(1000); // must be taken out later

        // provide name and description of the application
        loginPage.provideNameAndDescriptionByApplicationTypeIndex(applicationTypeIndex);
        Thread.sleep(1000); // must be taken out later

        /*
        //checking of privateApplication checkbox
        loginPage.checkingPrivateApplicationCheckBox();
        Thread.sleep(1000);// must be taken out later
         */

    }



    // ExecutableClassification or type (4) application:
    @When("user choose ExecutableClassification application type, provide name and description and instruction set")
    public void user_choose_executable_classification_application_type_provide_name_and_description_and_instruction_set() throws InterruptedException {
        int applicationTypeIndex=4;
        Thread.sleep(1000); // must be taken out later
        loginPage.selectingApplicationTypeByIndex(applicationTypeIndex); // ams-clone
        Thread.sleep(1000); // must be taken out later

        /*
        //checking of privateApplication checkbox
        loginPage.checkingPrivateApplicationCheckBox();
        Thread.sleep(1000);// must be taken out later
         */

        // provide name and description of the application
        loginPage.provideNameAndDescriptionByApplicationTypeIndex(applicationTypeIndex);
        Thread.sleep(1000); // must be taken out later

        // selecting instructionsSet - choosing one out of 6 options
        loginPage.choosingInstructionSet();
        Thread.sleep(1000); // must be taken out later

    }

    @When("choose folder names of class list files")
    public void choose_folder_names_of_class_list_files() {

        // write the names of the folders which contains class lists/files as a String.
        // Folder names must be separated by comma and no space before or after comma.
        loginPage.classFilesUploadField.sendKeys("autoit,emotet,gamarue",Keys.ENTER);
        // do not try to click the create button! If you do, then you are repeating
        // the create command and your test fails. Clicking the create button is taken
        // care of by other statement. Here is only about "choose folder names of class list files"!

    } // application creation ends here




}
