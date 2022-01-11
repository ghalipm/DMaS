package com.Kam1n0Automation.pages;

import com.Kam1n0Automation.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
