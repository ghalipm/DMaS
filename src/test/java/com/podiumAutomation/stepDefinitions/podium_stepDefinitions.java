package com.podiumAutomation.stepDefinitions;

import com.podiumAutomation.pages.LandingPage;
import com.podiumAutomation.pages.ProductsPage;
import com.podiumAutomation.utilities.BrowserUtils;
import com.podiumAutomation.utilities.ConfigurationReader;
import com.podiumAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class podium_stepDefinitions {
LandingPage landingPage=new LandingPage();
ProductsPage productsPage=new ProductsPage();

    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Then("User should see the podium logo")
    public void user_should_see_the_podium_logo() {
        // verify podium logo is displayed
        Assert.assertTrue("podium page is not displayed?", landingPage.podiumLogo.isDisplayed());

    }

    @Then("User should see the modules")
    public void user_should_see_the_modules(List<String> expectedModules) {
        // Write code here that turns the phrase above into concrete actions
        List<String> actualModules=new ArrayList<>();
        actualModules.add(landingPage.products.getText());
        actualModules.add(landingPage.solutions.getText());
        actualModules.add(landingPage.enterprise.getText());
        actualModules.add(landingPage.resources.getText());
        actualModules.add(landingPage.pricing.getText());
        actualModules.add(landingPage.login.getText());
        actualModules.add(landingPage.watchDemo.getText());

        for (int i = 0; i < expectedModules.size(); i++) {
           Assert.assertTrue(expectedModules.get(i).equals(actualModules.get(i)));
        }

    }


    @When("User hover over the Products module")
    public void user_hover_over_the_products_module() {
        BrowserUtils.hover(landingPage.products);

    }

    @Then("User should see the submodules")
    public void user_should_see_the_submodules(List<String> expectedSubModules) {
        // Write code here that turns the phrase above into concrete actions
        List<String> actualSubModules=new ArrayList<String>();
        actualSubModules.add(productsPage.reviews.getText());
        actualSubModules.add(productsPage.feedback.getText());
        actualSubModules.add(productsPage.payments.getText());
        actualSubModules.add(productsPage.teamchat.getText());
        actualSubModules.add(productsPage.videochat.getText());
        actualSubModules.add(productsPage.webchat.getText());
        actualSubModules.add(productsPage.inbox.getText());
        actualSubModules.add(productsPage.campaigns.getText());
        actualSubModules.add(productsPage.interest.getText());

        for (int i = 0; i < expectedSubModules.size(); i++) {
            Assert.assertTrue(expectedSubModules.get(i).equals(actualSubModules.get(i)));
        }

    }



}
