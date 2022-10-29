package com.Kam1n0Automation.stepDefinitions;

import com.Kam1n0Automation.pages.HomePage;
import com.Kam1n0Automation.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.Kam1n0Automation.utilities.Driver.getDriver;

public class A2_Downloads_stepDefinitions {
    HomePage homePage=new HomePage();

    // downloading Kam1n0-Server with downloads tab:
    @When("user click on downloads tab")
    public void user_click_on_downloads_tab() {

        System.out.println("Before clicking download tab: ");
        System.out.println("Driver.getDriver().getCurrentUrl() = " + getDriver().getCurrentUrl());

        homePage.downloadsTab.click();

        System.out.println("\"After Clicking download button\" = " + "After Clicking download button");
        System.out.println("Driver.getDriver().getCurrentUrl() = " + getDriver().getCurrentUrl());

        String parentWindowHandle = getDriver().getWindowHandle();
        System.out.println("Parent window's handle -> " + parentWindowHandle);

    }


    @Then("user click download Kam1n0-Server button")
    public void user_click_download_kam1n0_server_button() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(homePage.downloadsKam1noServerButton.isDisplayed());
        homePage.downloadsKam1noServerButton.click();

        Set<String> allWindowHandles = getDriver().getWindowHandles();

        /*
        for(String handle : allWindowHandles)
        {
            System.out.println("Window handle - > " + handle);
        }

         */

        List<String> list = new ArrayList<>(allWindowHandles);
        String childWindowHandle = list.get(1);

        System.out.println("childWindowHandle = " + childWindowHandle);
        // now we have switch to child window: bring the driver to child window
        getDriver().switchTo().window(childWindowHandle);
        // we see the effect of the previous method here:
        // we are at: https://github.com/McGill-DMaS/Kam1n0-Community/releases
        System.out.println("Driver.getDriver().getCurrentUrl() = " + getDriver().getCurrentUrl());

    }

    @When("user click on Latest version of Kam1n0")
    public void user_click_on_latest_version_of_kam1n0(){
        // Write code here that turns the phrase above into concrete actions
        homePage.kam1noLatestVersionLink.click();
        System.out.println("Driver.getDriver().getCurrentUrl() = " + getDriver().getCurrentUrl());
    }

    @Then("user click Kam1n0-Server Exec link")
    public void user_click_kam1n0_server_exec_link() {
        // Write code here that turns the phrase above into concrete actions
        BrowserUtils.waitForVisibility(homePage.actualKam1n0DownloadLink, 5);
        BrowserUtils.scrollToElement(homePage.actualKam1n0DownloadLink);
        BrowserUtils.clickWithJS(homePage.actualKam1n0DownloadLink);
    }

}
