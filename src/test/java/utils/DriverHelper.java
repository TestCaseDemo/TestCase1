package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.module.Configuration;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverHelper {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        try {
        if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {


                switch (ConfigReader.readProperty("browser")) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;
                }
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));


            }
            }catch (Exception e) {
            System.out.println("Exception occurred during WebDriver setup " + e);
        }

        return driver;
    }

}



