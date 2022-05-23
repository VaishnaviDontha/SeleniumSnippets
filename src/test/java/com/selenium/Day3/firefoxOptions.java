package com.selenium.Day3;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class firefoxOptions {

    WebDriver driver;

    @Test
    public void setBinary() {

        // Generally used to perform VERSION testing ; having browser installer in a
        // custom path
        System.setProperty("webdriver.gecko.driver", "./resources/geckodriver");
        FirefoxOptions cOptions = new FirefoxOptions();

        cOptions.setBinary("/Applications/Firefox.app");
        driver = new FirefoxDriver();
        driver.get("https://www.google.com");
    } 

    @Test
    public void acceptCert() {

        System.setProperty("webdriver.gecko.driver", "./resources/geckodriver");
        FirefoxOptions cOptions = new FirefoxOptions();
        cOptions.setAcceptInsecureCerts(true);
        driver = new FirefoxDriver(cOptions);
        driver.get("https://www.cacert.org/");

    }


    @Test
    public void arguments() {

        System.setProperty("webdriver.gecko.driver", "./resources/geckodriver");
        FirefoxOptions cOptions = new FirefoxOptions();
        cOptions.addArguments("--disable-infobars");
        driver = new FirefoxDriver(cOptions);
        driver.get("https://www.google.com");
        
    }
 
    @Test
    public void browserHeadless() {

        System.setProperty("Webdriver.gecko.driver", "./resources/geckodriver");
        FirefoxOptions cOptions = new FirefoxOptions();
        cOptions.setHeadless(true); // or cOptions.addArguments("--headless");
        cOptions.addArguments("--incognito");
        cOptions.setAcceptInsecureCerts(true);

        cOptions.addArguments("--disable-infobars");
        DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, cOptions);
		cOptions.merge(capabilities);
		driver = new FirefoxDriver(cOptions);
        driver.get("https://www.google.com");

        String ver = cOptions.getBrowserVersion();
        System.out.println(ver);

        String name = cOptions.getBrowserName();
        System.out.println(name);

    } 

    @Test
    public void fewMoreArguments() {

        System.setProperty("webdriver.gecko.driver", "./resources/geckodriver");
        FirefoxOptions cOptions = new FirefoxOptions();

        // Page Load Strategy
        cOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        cOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        cOptions.setPageLoadStrategy(PageLoadStrategy.NONE);

        // TimeOuts
        cOptions.setScriptTimeout(Duration.ofMinutes(1));
        cOptions.setPageLoadTimeout(Duration.ofMinutes(1));
        cOptions.setImplicitWaitTimeout(Duration.ofMinutes(1));

        driver = new FirefoxDriver(cOptions);
        driver.get("https://www.google.com");
        
    }


    @AfterTest
    public void TearDown() {

        driver.quit();
        
    }

    
}
