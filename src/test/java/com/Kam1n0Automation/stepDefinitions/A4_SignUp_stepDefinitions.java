package com.Kam1n0Automation.stepDefinitions;

import com.Kam1n0Automation.pages.LoginPage;
import com.Kam1n0Automation.pages.SignUpPage;
import io.cucumber.java.en.Then;


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
        //signUpPage.firstSignUp();// with real credentials only for the first time use when Kam1n0 is installed!
        signUpPage.signUp(); // not with real credentials

        System.out.println("Sign up message:"+signUpPage.successAlert.getText());

    }

}
