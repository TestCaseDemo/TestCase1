package com.test.pages.Register.actions;

import com.test.pages.Register.locators.Home_Page_Locators;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utils.Constants;

import java.time.Duration;

public class HomePageActions {

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    public Home_Page_Locators home_Page_Locators = new Home_Page_Locators(driver);
    WebDriverWait wait;


    public HomePageActions(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,home_Page_Locators);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    public void clickOnLoginButton(){

        try{
            Actions actions = new Actions(driver);
            actions.click(home_Page_Locators.loginButton).build().perform();
           //home_Page_Locators.loginButton.click();

        }catch (TimeoutException e){
            System.out.println("TimeOut Error " + e.getMessage());
        }
    }
    public void verifyUrl(){
      try{
          String actualUrl = driver.getCurrentUrl();
          String expectedUrl = Constants.urls;

          if(actualUrl.contains(expectedUrl)){
              softAssert.assertTrue(true);
              System.out.println("url is correct " + expectedUrl);


          }else{
              softAssert.assertFalse(true,"Pop up msg is wrong , Please verify Url");
              System.out.println("incorrect Url. Expected: " + expectedUrl);


          }
          softAssert.assertAll();

      }catch (Exception e){
          System.out.println("TimeOut Error " + e.getMessage());
      }

    }


}
