package com.Kam1n0Automation.stepDefinitions;

import com.Kam1n0Automation.pages.LoginPage;
import com.Kam1n0Automation.pages.SignUpPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class A4_SignUp_stepDefinitions {

    LoginPage loginPage=new LoginPage();
    SignUpPage signUpPage=new SignUpPage();


    @Then("user click sign up link")
    public void user_click_sign_up_link()  {
        // Write code here that turns the phrase above into concrete actions
        loginPage.signUpLink.click();

    }

    @Then("user complete signing up")
    public void user_complete_signing_up() {

        //signUpPage.signUp(); // not with real credentials, signUp with Java Faker.

        // signUp with real credentials:
        signUpPage.firstSignUp();// only for the first time use when Kam1n0 is installed!
        if(signUpPage.subsribedMessage.getText().contains("The name already existed")){
            System.out.println("Already signed up successfully!");
        }else {
            Assert.assertTrue(signUpPage.subsribeMessage.getText().contains("successfully"));
            System.out.println("Sign up is successful = " + signUpPage.subsribeMessage.getText().contains("successfully"));

        }

    }

}
