package com.Kam1n0Automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//h1")
    public WebElement mainPageHeader;

    @FindBy(xpath = "(//a/i)[2]")
    public WebElement downloadsTab;

    @FindBy(xpath = "//a[@class='navbar-brand']")
    public WebElement dmasLabLink;

    //@FindBy(xpath = "//a[@href='/McGill-DMaS/Kam1n0-Community/releases']")
    @FindBy(xpath = "(//*[@href=\"https://github.com/McGill-DMaS/Kam1n0-Community/releases\"])[1]")
    public WebElement downloadsKam1noServerButton; // DOWNLOAD KAM1N0 SERVER BUTTON

    @FindBy(xpath = "//a[@id='link-login']")
    public WebElement loginTab;

    @FindBy(xpath = "(//a/i)[4]")
    public WebElement gitHubTab;

    @FindBy(xpath = "(//a[.='release page'])[2]")
    public WebElement releaseLink;

    @FindBy(xpath = "(//*[@href='/McGill-DMaS/Kam1n0-Community/releases/latest'])[1]")
    public WebElement kam1noLatestVersionLink;

    @FindBy(xpath = "//*[.='Kam1n0-Server.exe']")
    public WebElement actualKam1n0DownloadLink;





}
