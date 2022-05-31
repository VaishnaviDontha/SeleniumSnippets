package com.selenium.Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class launchBrowser {

    private WebDriver driver;

    @Test
    public void ChromeBrowser() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void FirefoxBrowser() {

        driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "./resources/geckodriver");
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @Test
    public void EdgeBrowser() {

        driver = new EdgeDriver();
        System.setProperty("webdriver.edge.driver", "./resources/msedgedriver");
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @Test
    public void HTMLBrowser() {

        driver = new HtmlUnitDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @Test
    public void SafariBrowser() {

        driver = new SafariDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @AfterTest
    public void tearDown() {

        driver.close();
        
    }

}
