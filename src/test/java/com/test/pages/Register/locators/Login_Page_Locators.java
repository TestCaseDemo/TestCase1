package com.test.pages.Register.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page_Locators {


    public Login_Page_Locators(WebDriver driver) {
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//h2[.='New User Signup!']")
    public WebElement headerNewUserSignUp;
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement nameForNewUserSignUp;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement emailAddress;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signUpButton;

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    public WebElement accountInfoFormTitle;
    @FindBy(xpath = "//label[@for='id_gender1']")
    public WebElement titleMr;
    @FindBy(xpath = "//label[@for='id_gender2']")
    public WebElement titleMrs;
    @FindBy(css = "#name")
    public WebElement nameForAccountInfo;
    @FindBy(css = "#password")
    public WebElement passwordForAccountInfo;
    @FindBy(css = "#days")
    public WebElement daysOfBirth;
    @FindBy(css = "#months")
    public WebElement monthsOfBirth;
    @FindBy(css = "#years")
    public WebElement yearsOfBirth;

    @FindBy(css = "#newsletter")
    public WebElement signUpForNewLettersCheckBox;

    @FindBy(css = "#optin")
    public WebElement receiveSpecialOffersCheckBox;
    @FindBy(css = "#first_name")
    public WebElement first_name;
    @FindBy(css = "#last_name")
    public WebElement last_name;
    @FindBy(css = "#company")
    public WebElement company;
    @FindBy(css = "#address1")
    public WebElement address1;
    @FindBy(css = "#address2")
    public WebElement address2;
    @FindBy(css = "#country")
    public WebElement country;
    @FindBy(css = "#state")
    public WebElement state;
    @FindBy(css = "#city")
    public WebElement city;
    @FindBy(css = "#zipcode")
    public WebElement zipcode;
    @FindBy(css = "#mobile_number")
    public WebElement mobile_number;
    @FindBy(xpath = "//button[@type='submit' and @data-qa='create-account']")
    public WebElement createAccountButton;
    @FindBy(xpath = "//b[text()='Account Created!']")
    public WebElement accountCreatedMessage;
    @FindBy(xpath = "//a[text()='Continue']")
    public WebElement continueButton;
    @FindBy(xpath = "//li//a//i[@class]/following-sibling::b")
    public WebElement userName;
    @FindBy(xpath = "//a[.=' Delete Account']")
    public WebElement deleteAccount;

    @FindBy(xpath = "//b[text()='Account Deleted!']")
    public WebElement accountDeletedMsg;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButtonAfterDeleteAccount;
}
