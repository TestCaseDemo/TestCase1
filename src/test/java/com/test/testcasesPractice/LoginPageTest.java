package com.test.testcasesPractice;

import com.aventstack.extentreports.Status;
import com.test.pages.Register.actions.HomePageActions;
import org.testng.annotations.Test;
import com.test.pages.Register.actions.LoginPageActions;

public class LoginPageTest extends TestBase{

       /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
     */

    LoginPageActions loginPageActions;
    HomePageActions homePageActions;

   @Test
   public void UserRegister() throws InterruptedException {
       loginPageActions= new LoginPageActions(driver);
       homePageActions = new HomePageActions(driver);
       logger.assignAuthor("Supattra");
       logger.assignCategory("New SignUp Login Page");
       logger.log(Status.INFO,"Click on Login Button");
       homePageActions.clickOnLoginButton();
       logger.log(Status.INFO,"Verify 'New User SignUp!' is visible in Login page");
       loginPageActions.verifyNewUserSinUpFormTitle();
       logger.log(Status.INFO,"User Provide name for New signUp");
       loginPageActions.provideNameForNewSignUp();
       logger.log(Status.INFO,"User Provide email Address for New SignUp");
       loginPageActions.provideEmailAddressForNewSignUp();
       logger.log(Status.INFO,"User click on Signup");
       loginPageActions.clickOnSignUpButton();
       logger.log(Status.INFO,"Verify 'ENTER ACCOUNT INFORMATION' is visible in Signup/login page");
       loginPageActions.verifyEnterAccountInfoFormTitle();
       logger.log(Status.INFO,"Select title Options ");
       loginPageActions.selectTitle();
       logger.log(Status.INFO,"User provide name ");
       loginPageActions.sendNameForAccountInfo();
       logger.log(Status.INFO,"User provide password");
       loginPageActions.sendPasswordForAccountInfo();
       logger.log(Status.INFO,"Select Date of birth ");
       loginPageActions.selectDateOfBirth();
       logger.log(Status.INFO,"User click on Sign up for our newsletter!");
       loginPageActions.clickOnSignUpForOurNewsLetter();
       logger.log(Status.INFO,"User click on Receive special offers from our partners!");
       loginPageActions.clickOnReceiveSpecialOffer();
       logger.log(Status.INFO,"User provide First Name And Last Name");
       loginPageActions.sendFirstNameAndLastName();
       Thread.sleep(1000);
       logger.log(Status.INFO,"User provide Company name");
       loginPageActions.sendCompany();
       Thread.sleep(1000);
       logger.log(Status.INFO,"User provide AddressInfo");
       loginPageActions.sendAddress();
       Thread.sleep(1000);
       logger.log(Status.INFO,"User provide Mobile Number");
       loginPageActions.sendMobileNumber();
       Thread.sleep(1000);
       logger.log(Status.INFO,"Click on Create Account Button");
       loginPageActions.clickOnCreateAccount();
       Thread.sleep(1000);
       logger.log(Status.INFO,"Verify ACCOUNT CREATED! message ");
       loginPageActions.verifyAccountCreatedMessage();
       logger.log(Status.INFO,"Click on Continue");
       loginPageActions.clickOnContinue();
       logger.log(Status.INFO,"Verify User Name");
       loginPageActions.verifyUserNameMatchWithNameAccountInfo();
       logger.log(Status.INFO,"Click on Delete account");
       loginPageActions.clickOnDeleteAccount();
       logger.log(Status.INFO,"Verify ACCOUNT DELETED! message");
       loginPageActions.verifyAccountDeleteMsg();
       logger.log(Status.INFO,"Click on Continue after delete account");
       loginPageActions.clickInContinueAfterDeleteAccount();






   }
}
