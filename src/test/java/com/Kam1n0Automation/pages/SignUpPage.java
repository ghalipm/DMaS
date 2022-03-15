package com.Kam1n0Automation.pages;


import com.Kam1n0Automation.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignUpPage extends BasePage {
    @FindBy(id="username")
//@FindBy(xpath="//input[@id='username']")
    private WebElement usernameBox;

    @FindBy(id="email")
//@FindBy(xpath="//input[@id='email']")
    private WebElement emailBox;


    @FindBy(xpath="//input[@id='aggreeTLicense1']")
    private WebElement checkBox;

    //@FindBy(id="aggreeTLicense1")
    @FindBy(xpath="//input[@id='pw']")
    private WebElement passwordBox;


    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement successAlert;

    @FindBy(xpath = "//form")
    public WebElement subsribeMessage;

    @FindBy(xpath = "//div/p")
    public WebElement subsribedMessage;


    Faker faker=new Faker();

    public void firstSignUp() {

        // if the credentials are new (first time sign up), use the following:
            usernameBox.sendKeys(ConfigurationReader.getProperty("username"));
            emailBox.sendKeys(ConfigurationReader.getProperty("email"));
            passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
            checkBox.click();
            submitButton.click();

    }

/** Sign up with Java Faker.
        public void signUp(){
        // else use the following, just for demo purpose:
        usernameBox.sendKeys(faker.name().username());
        emailBox.sendKeys(faker.internet().emailAddress());
        passwordBox.sendKeys(faker.internet().password());
        checkBox.click();
        submitButton.click();
            Assert.assertTrue(subsribeMessage.getText().contains("successfully"));
            System.out.println("Subscription is successful = "+subsribeMessage.getText().contains("successfully") );

        }

 */


}
