package com.WebDriverManager.Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class launchBrowser {


    private WebDriver driver;



    @Test
    public void ChromeBrowser() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void FirefoxBrowser() {

        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "./resources/geckodriver");
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @Test
    public void EdgeBrowser() {

        WebDriverManager.edgedriver().setup();

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

        WebDriverManager.safaridriver();

        driver = new SafariDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @AfterTest
    public void teardown() {

        driver.quit();
        
    }
    
}
