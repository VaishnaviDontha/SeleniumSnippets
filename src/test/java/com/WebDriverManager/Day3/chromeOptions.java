package com.WebDriverManager.Day3;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chromeOptions {

    @Test
    public void setBinary() {

        

        // Generally used to perform VERSION testing ; having browser installer in a
        // custom path
        // System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        ChromeOptions cOptions = new ChromeOptions();

        // cOptions.setBinary("/Applications/Google Chrome.app");
        // Or
        cOptions.setBinary(new File("Applications/Google Chrome.app"));
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
    } 

    @Test
    public void acceptCert() {

        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();

        ChromeOptions cOptions = new ChromeOptions();
        cOptions.setAcceptInsecureCerts(true);
        
        driver.get("https://www.cacert.org/");

    }


    @Test
    public void arguments() {

        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();


        ChromeOptions cOptions = new ChromeOptions();
        cOptions.addArguments("--disable-infobars");
        driver = new ChromeDriver(cOptions);
        driver.get("https://www.google.com");
        
    }
 
    @Test
    public void browserHeadless() {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        

        ChromeOptions cOptions = new ChromeOptions();
        cOptions.setHeadless(true); // or cOptions.addArguments("--headless");
        cOptions.addArguments("--incognito");
        cOptions.setAcceptInsecureCerts(true);

        cOptions.addArguments("--disable-infobars");
        DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, cOptions);
		cOptions.merge(capabilities);
		driver = new ChromeDriver(cOptions);
        driver.get("https://www.google.com");

        String ver = cOptions.getBrowserVersion();
        System.out.println(ver);

        String name = cOptions.getBrowserName();
        System.out.println(name);

    } 

    @Test
    public void fewMoreArguments() {

        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        ChromeOptions cOptions = new ChromeOptions();

        // Page Load Strategy
        cOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        cOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        cOptions.setPageLoadStrategy(PageLoadStrategy.NONE);

        // TimeOuts
        cOptions.setScriptTimeout(Duration.ofMinutes(1));
        cOptions.setPageLoadTimeout(Duration.ofMinutes(1));
        cOptions.setImplicitWaitTimeout(Duration.ofMinutes(1));

        WebDriver driver = new ChromeDriver(cOptions);
        driver.get("https://www.google.com");

        driver.quit();
        
    }

}