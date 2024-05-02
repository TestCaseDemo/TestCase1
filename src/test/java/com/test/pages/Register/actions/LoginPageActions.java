package com.test.pages.Register.actions;

import com.test.pages.Register.locators.Login_Page_Locators;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;
import utils.Constants;

import java.awt.*;
import java.time.Duration;

public class LoginPageActions {


    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    public Login_Page_Locators login_page_locators = new Login_Page_Locators(driver);
    WebDriverWait wait;

    public LoginPageActions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,login_page_locators);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));


    }

    public void verifyNewUserSinUpFormTitle(){

        try{
            String actualFormTitle = BrowserUtils.getText(login_page_locators.headerNewUserSignUp);
            String expectedFormTitle = Constants.NewUserSignUpFormTitle;
            if(actualFormTitle.contains(expectedFormTitle)){
                softAssert.assertTrue(true);
                System.out.println("Correct New User SignUp Form Title. Expected: " + expectedFormTitle);

            }else{
                softAssert.assertFalse(true);
                System.out.println("Incorrect New User SignUp form Title. Expected: " + expectedFormTitle);
            }
        }catch (TimeoutException e){
            System.out.println("TimeOut Error " + e.getMessage());
        }

    }

    public void provideNameForNewSignUp() {
        try {
            login_page_locators.nameForNewUserSignUp.sendKeys(Constants.NewSignUpName);
        }catch (TimeoutException e){
            System.out.println("TimeOut Error " + e.getMessage());
        }

    }

    public void provideEmailAddressForNewSignUp()  {

        try {

            login_page_locators.emailAddress.sendKeys(Constants.NewSignUpEmailAddress);
        }catch (TimeoutException e){
            System.out.println("TimeOut Error " + e.getMessage() );
        }

    }

    public void clickOnSignUpButton() {
        try {
            login_page_locators.signUpButton.click();
        }catch (TimeoutException e){
            System.out.println("TimeOut Error " + e.getMessage());
        }

    }

    public void verifyEnterAccountInfoFormTitle(){
        try {
            String actualAccountInfoTitle = BrowserUtils.getText(login_page_locators.accountInfoFormTitle);
            String expectedAccountInfoTitle = Constants.AccountInfoFormTitle;
            if (actualAccountInfoTitle.contains(expectedAccountInfoTitle)) {
                softAssert.assertTrue(true);
                System.out.println("Account Info form title is correct. Expected: " + expectedAccountInfoTitle);


            }else{
                softAssert.assertFalse(true);
                System.out.println("Incorrect Account Info form title. Expected: " + expectedAccountInfoTitle);
            }
            softAssert.assertAll();
        }catch (TimeoutException e){
            System.out.println("TimeOut Error " + e.getMessage());
        }
    }

    public void selectTitle(){
        try{

                switch (Constants.TitleMr){
                    case "Mr.":
                        login_page_locators.titleMr.click();
                        break;
                    case "Mrs.":
                        login_page_locators.titleMrs.click();
                        break;
                    default:

                        System.out.println("Please choose correct title");
                        break;

                }



        }catch (TimeoutException e){
            System.out.println("TimeOut Error " + e.getMessage());
        }
    }

    public void sendNameForAccountInfo(){
        try{
            login_page_locators.nameForAccountInfo.clear();
            login_page_locators.nameForAccountInfo.sendKeys(Constants.NameAccountInfo);


        }catch (TimeoutException e){
            System.out.println("TimeOut Error " + e.getMessage());
        }
    }


    public void sendPasswordForAccountInfo(){
        try{
            login_page_locators.passwordForAccountInfo.sendKeys(Constants.PasswordAccountInfo);
        }catch (TimeoutException e){
            System.out.println("TimeOut Error " + e.getMessage());
        }

    }

    public void selectDateOfBirth(){
        try{
            BrowserUtils.selectBy(login_page_locators.daysOfBirth,Constants.DaysOfBirth,"text");

            BrowserUtils.selectBy(login_page_locators.monthsOfBirth,Constants.MonthsOfBirth,"text");

            BrowserUtils.selectBy(login_page_locators.yearsOfBirth,Constants.YearsOfBirth,"text");

        }catch (TimeoutException e){
            System.out.println("TimeOut Error " + e.getMessage());
        }
    }

    public void clickOnSignUpForOurNewsLetter(){
        try{
            login_page_locators.signUpForNewLettersCheckBox.click();
        }catch (TimeoutException e){
            System.out.println("TimeOut Error" +e.getMessage());
        }
    }
    public void clickOnReceiveSpecialOffer(){
        try{
            login_page_locators.receiveSpecialOffersCheckBox.click();
        }catch (TimeoutException e){
            System.out.println("TimeOut Error " + e.getMessage());
        }
    }

    public void sendFirstNameAndLastName(){
        try{
         login_page_locators.first_name.sendKeys(Constants.First_Name);
            login_page_locators.last_name.sendKeys(Constants.Last_Name);
        }catch (TimeoutException e){
            System.out.println("TimeOut Error" + e.getMessage());
        }
    }



    public void sendCompany(){
        try{
            login_page_locators.company.sendKeys(Constants.Company);
        }catch (TimeoutException e){
            System.out.println("TimeOut Error " + e.getMessage());
        }
    }
    public void sendAddress(){
        try{
            login_page_locators.address1.sendKeys(Constants.Address1);
            Thread.sleep(1000);
            BrowserUtils.scrollWithJS(driver,login_page_locators.address2);
            Thread.sleep(1000);
            login_page_locators.address2.sendKeys(Constants.Address2);
            Thread.sleep(1000);
            BrowserUtils.selectBy(login_page_locators.country,Constants.Country,"text");
            Thread.sleep(1000);
            login_page_locators.state.sendKeys(Constants.State);
            Thread.sleep(1000);
            login_page_locators.city.sendKeys(Constants.City);
            Thread.sleep(1000);
            login_page_locators.zipcode.sendKeys(Constants.Zipcode);
            Thread.sleep(1000);

        }catch (TimeoutException | InterruptedException e){
            System.out.println("TimeOut Error " + e.getMessage());
        }
    }
    public void sendMobileNumber(){
        try{
            login_page_locators.mobile_number.sendKeys(Constants.Mobile_Number);

        }catch (TimeoutException e){
            System.out.println("TimeOut Error"  + e.getMessage());
        }
    }
    public void clickOnCreateAccount(){
        try{
            login_page_locators.createAccountButton.click();
        }catch (TimeoutException e){
            System.out.println("TimeOut Error " +e.getMessage());
        }
    }
    public void verifyAccountCreatedMessage(){
        try{
            String actualMessage = login_page_locators.accountCreatedMessage.getText();
            String expectedMessage = Constants.AccountCreatedMessage;
            if(actualMessage.contains(expectedMessage)){
               softAssert.assertTrue(true);
                System.out.println("Account Created Msg is correct. Expected :" + expectedMessage);

            }else {
                softAssert.assertFalse(true);
                System.out.println("Incorrect Account Created msg. Expected : " + expectedMessage);
            }
            softAssert.assertAll();
        }catch (TimeoutException e){
            System.out.println("TimeOut Error " + e.getMessage());
        }
    }
    public void clickOnContinue(){
        try{
            login_page_locators.continueButton.click();
        }catch (TimeoutException e){
            System.out.println("TimeOut Error " + e.getMessage());
        }
    }

    public void verifyUserNameMatchWithNameAccountInfo(){
        try{
            String actualUserName = login_page_locators.userName.getText();
            String expectedUsername = Constants.NameAccountInfo;
            if(actualUserName.contains(expectedUsername)){
                softAssert.assertTrue(true);
                System.out.println("User Name is correct. Expected:" +expectedUsername);

            }else {
                softAssert.assertFalse(true);
                System.out.println("Incorrect Username. Expected : " +expectedUsername);
            }
            softAssert.assertAll();
        }catch (TimeoutException e){
            System.out.println("TimeOut Error " + e.getMessage());
        }
    }
    public void clickOnDeleteAccount(){
        try{
            login_page_locators.deleteAccount.click();
        }catch (TimeoutException e){
            System.out.println("TimeOut Error " + e.getMessage());
        }
    }

    public void verifyAccountDeleteMsg(){
        try{
            String actualMsg = login_page_locators.accountDeletedMsg.getText();
            String expectedMsg = Constants.AccountDeleteMessage;
            if(actualMsg.contains(expectedMsg)){
                softAssert.assertTrue(true);
                System.out.println("Account Delete Msg is correct. Expected : " +expectedMsg);

            }else {
                softAssert.assertFalse(true);
                System.out.println("Incorrect Account Delete Msg. Expected :" +expectedMsg);
            }
            softAssert.assertAll();
        }catch (TimeoutException e){
            System.out.println("TimeOut Error " +e.getMessage());
        }

    }

    public void clickInContinueAfterDeleteAccount(){
        try{
            login_page_locators.continueButtonAfterDeleteAccount.click();
        }catch (TimeoutException e){
            System.out.println("TimeOut Error " +e.getMessage());
        }
    }
}
