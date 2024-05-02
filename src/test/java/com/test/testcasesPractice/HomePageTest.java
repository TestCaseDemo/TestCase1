package com.test.testcasesPractice;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import com.test.pages.Register.actions.HomePageActions;

public class HomePageTest extends TestBase {
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

HomePageActions homePageActions;
 @Test(priority = 1)
    public void navigate_To_Website_And_Verify_URL() {
     homePageActions = new HomePageActions(driver);

         logger.assignAuthor("Supatrta");
         logger.assignCategory("Home Page");
         logger.log(Status.INFO, "Verifying that home page is visible");
         homePageActions.verifyUrl();

 }





}
