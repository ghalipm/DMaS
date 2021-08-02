package com.podiumAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LandingPage extends BasePage {
    @FindBy(xpath = "//span[.='Products']")
    public WebElement products;

    @FindBy(xpath = "//span[.='Solutions']")
    public WebElement solutions;

    @FindBy(xpath = "(//a[.='Enterprise'])[1]")
    public WebElement enterprise;

    @FindBy(xpath = "//span[.='Resources']")
    public WebElement resources;

    @FindBy(xpath = "(//a[.='Pricing'])[1]")
    public WebElement pricing;

    @FindBy(xpath = "(//a[.='Login'])[1]")
    public WebElement login;

    @FindBy(xpath = "(//a[.='Watch Demo'])[1]")
    public WebElement watchDemo;

    @FindBy(xpath = "//img[@class='logo l-black']")
    public WebElement podiumLogo;



}
