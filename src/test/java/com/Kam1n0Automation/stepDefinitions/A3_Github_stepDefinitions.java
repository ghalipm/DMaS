package com.Kam1n0Automation.stepDefinitions;

import com.Kam1n0Automation.pages.HomePage;
import com.Kam1n0Automation.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.Kam1n0Automation.utilities.Driver.getDriver;

public class A3_Github_stepDefinitions {

    HomePage homePage=new HomePage();

    // Kam1n0 downloading at github
    @When("user clicks GitHub button")
    public void user_clicks_git_hub_button() {
        // click on the GitHub tab on Homepage
        homePage.gitHubTab.click();
        // this will open Kam1n0-Community on github,
        //but here, we are still on homepage: http://127.0.0.1:8571/
        // even though we did the click, the effect will be visible only outside the method.
        System.out.println("Driver.getDriver().getCurrentUrl() = " + getDriver().getCurrentUrl());
        // we are on the homepage, i.e., on the parent window:
        String parentWindowHandle = getDriver().getWindowHandle();
        System.out.println("Parent window's handle -> " + parentWindowHandle);

    }

    @Then("user lands at GitHub page of Kam1n0 Community")
    public void user_lands_at_git_hub_page_of_kam1n0_community() {
        // now we are on a new window, i.e., on the child window:
        // but the Driver is still on the parent windows
        // so we need to get all window handles
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
        // we see the effect of the previous method here: we are at: https://github.com/McGill-DMaS/Kam1n0-Community
        System.out.println("Driver.getDriver().getCurrentUrl() = " + getDriver().getCurrentUrl());

    }

    @Then("user clicks releases page link of Kam1n0-Server")
    public void user_clicks_releases_page_link_of_kam1n0_server(){

        homePage.releaseLink.click();
        System.out.println("after release link is clicked");


    }


    @Then("user lands at Kam1n0 Community releases page on GitHub")
    public void user_lands_at_kam1n0_community_releases_page_on_git_hub(){
        System.out.println("Driver.getDriver().getCurrentUrl() = " + getDriver().getCurrentUrl());

    }

    @Then("user either confirm or cancel download")
    public void user_either_confirm_or_cancel_download() throws AWTException, InterruptedException {

        homePage.actualKam1n0DownloadLink.click();
        System.out.println("Kam1n0-Server.exe is clicked = "+homePage.actualKam1n0DownloadLink.isDisplayed());

        // scrolling to kamCommuGitHubPage.actualKam1n0DownloadLink:
        //((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", kamCommuGitHubPage.actualKam1n0DownloadLink);

        //in order to click one of the buttons in the Windows alert (Not Web Alert!)
        // following effort is needed.
/**

        Robot robot = new Robot();
        //robot.mouseMove(370,1000); // position of "Keep" button
        //robot.mouseMove(450,1000); // position of "Dismiss" button
        // both buttons are outside of the window and impossible to find by inspection
        // got these positions for MY PC (Large monitor) by trial and error.

        robot.mouseMove(370,1000); // Navigating through mouse hover.
        // Note that the coordinates might differ, kindly check
        // the coordinates of x and y axis and update it accordingly.
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        BrowserUtils.wait(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        BrowserUtils.wait(2);

 */




        // after each execution of the test,
        // you see an "Unconfirmed xxxxxx.crdownload" with
        // very recent time stamp in your download folder

        /*
         * Selenium can click download button, but cannot confirm/verify download
         * For uploading one needs to use AutoIt.
         *
         */

    }

}
