package com.Kam1n0Automation.pages;

import com.Kam1n0Automation.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}

/**
 * Best Practices in Cucumber Testing
 * Here are some of the best practices in Cucumber Testing:
 *
 * The versions of Cucumber-java, Cucumber-junit, and Cucumber-core jars should be
 * the same for seamless connectivity.
 * Adding an after hook to the code for capturing screenshots when the test fails
 * can help diagnose the issue and debug it.
 * Use Tags for organizing tests based on tag definition. This helps in cases where
 * all tests don’t have to be run every time. Such tests can be marked using tags
 * and run only when required. This saves time and processing capacity of the system
 * and resources.
 */