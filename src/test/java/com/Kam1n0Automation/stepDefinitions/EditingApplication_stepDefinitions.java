package com.Kam1n0Automation.stepDefinitions;

import com.Kam1n0Automation.pages.LoginPage;
import com.Kam1n0Automation.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Random;


public class EditingApplication_stepDefinitions {

    LoginPage loginPage = new LoginPage();
    Faker faker=new Faker();
    Random random=new Random();


    //editing an application:
    @When(": an application is created")
    public void an_application_is_created() {
        System.out.println("Size of the applicationPermanentLinks list = "+( loginPage.applicationPermanentLinks.size() ) );
        if(loginPage.applicationPermanentLinks.size()<=2){
            System.out.println("Create some more applications first, then try to edit.");
        }
        else {
            System.out.println("You can process an existing application.");
        }
    }

    @Then("user can edit the application by changing the name of the application, providing username and type of access")
    public void user_can_edit_the_application_by_changing_the_name_of_the_application_providing_username_and_type_of_access() throws InterruptedException {

        int applicationIndex= random.nextInt(loginPage.applicationPermanentLinks.size());

        while(loginPage.applicationPermanentLinks.size()>0){
            int appRandomIndex= random.nextInt(loginPage.applicationPermanentLinks.size());
            if( !loginPage.applicationPermanentLinks.get(appRandomIndex).getText().contains("kam")) {
                applicationIndex = appRandomIndex;
                break;
            }

        }

        // Edit button with the right index is clicked?
        System.out.println("Application index for editing = " + applicationIndex);
        System.out.println(loginPage.editButtonListForApplicationFiles.get(applicationIndex).getText()+ " button No."+ applicationIndex+ " is clicked.");
        loginPage.editButtonListForApplicationFiles.get(applicationIndex).click();
        BrowserUtils.wait(1);

        // we need to know app name:
        // to get the text from a textfield/WebElement, we need to use 'getAttribute("value")'
        String appName=loginPage.applicationName.getAttribute("value");
        //System.out.println("Original name of the application = " + appName);

        // from the app name, we want to extract app type index and keep it unchanged:
        int appType=0;
        for(int i=0; i < appName.length(); i++) {
            boolean charIsDigit = Character.isDigit(appName.charAt(i));
            if(charIsDigit) {
                System.out.println("App type index is "+ appName.charAt(i));
                // getting the numeric value of char
                appType=Character.getNumericValue(appName.charAt(i));
                break;
            }
            // go to next

        }

        // changing the name of the app while keeping the type of app unchanged.
        loginPage.changingTheNameOfTheApplication(appType);
        BrowserUtils.wait(1);

        loginPage.userNameFieldForEditing.sendKeys(faker.name().username());
        BrowserUtils.wait(1);
        loginPage.assigningUserRights();
        BrowserUtils.wait(1);

    }


    @Then("user click update button and finish editing")
    public void user_click_update_button_and_finish_editing() throws InterruptedException {
        loginPage.finishEditing();
        // wait until the first application shows up
        BrowserUtils.waitForVisibility(loginPage.applicationPermanentLinks.get(1),2);
        //System.out.println("loginPage.applicationPermanentLinks.get(1).getText() = " + loginPage.applicationPermanentLinks.get(1).getText());
        loginPage.logout();
    }


}
