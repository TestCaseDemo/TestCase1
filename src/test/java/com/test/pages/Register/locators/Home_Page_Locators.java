package com.test.pages.Register.locators;


import org.apache.commons.lang3.exception.ExceptionContext;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Home_Page_Locators {

    public Home_Page_Locators(WebDriver driver){
        PageFactory.initElements(driver,this);

    }



    @FindBy(xpath = "//a[@href='/login']")
    public WebElement loginButton;
//make a change some thing





}
