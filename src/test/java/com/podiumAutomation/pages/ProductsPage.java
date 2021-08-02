package com.podiumAutomation.pages;


import com.podiumAutomation.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

@FindBy(xpath="(//span[.='Reviews'])[1]")
    public WebElement reviews;

    @FindBy(xpath="(//span[.='Feedback'])[1]")
    public  WebElement feedback;

    @FindBy(xpath="(//span[.='Payments'])[1]")
    public  WebElement payments;

    @FindBy(xpath="(//span[.='Teamchat'])[1]")
    public  WebElement teamchat;

    @FindBy(xpath="(//span[.='Videochat'])[1]")
    public  WebElement videochat;

    @FindBy(xpath="(//span[.='Webchat'])[1]")
    public  WebElement webchat;

    @FindBy(xpath="(//span[.='Inbox'])[1]")
    public  WebElement inbox;

    @FindBy(xpath="(//span[.='Campaigns'])[1]")
    public  WebElement campaigns;

    @FindBy(xpath="(//p[.='Interested in trying our free version?'])[1]")
    public  WebElement interest;


}
