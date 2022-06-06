package com.selenium.Day5;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class handlingCookies {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://the-internet.herokuapp.com");     
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
        
    }

    @Test
    public void cookiesFunc() {

            /* 
                * Cookie cookieName = new Cookie("Key", "Value");
                * .addCookie(cookiename)
                
                * .getName()
                * .getCookieNamed("key")
                
                * .getCookies()
                
                * .deleteCookie(cookieName)
                * .deleteCookieNamed("Key")
                * .deleteAllCookies()
                
                * .getValue()
                * .getPath()
                * .getExpiry()
                * .getDomain()
                * .isSecure()
                * .isHttpOnly()
            */

        Cookie testcookie = new Cookie("test", "1234");
        driver.manage().addCookie(testcookie);

        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies);


        System.out.println(driver.manage().getCookieNamed("rack.session").getClass());
        System.out.println(driver.manage().getCookieNamed("rack.session").getDomain());
        System.out.println(driver.manage().getCookieNamed("rack.session").getExpiry());
        System.out.println(driver.manage().getCookieNamed("rack.session").getName());
        System.out.println(driver.manage().getCookieNamed("rack.session").getPath());
        System.out.println(driver.manage().getCookieNamed("rack.session").getValue());
        System.out.println(driver.manage().getCookieNamed("rack.session").getSameSite());

        
        driver.manage().deleteCookie(testcookie);
        driver.manage().deleteCookieNamed("optimizelyEndUserId");
        driver.manage().deleteAllCookies();

        Set<Cookie> postcookies = driver.manage().getCookies();
        System.out.println(postcookies);
    
        
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
    
}
