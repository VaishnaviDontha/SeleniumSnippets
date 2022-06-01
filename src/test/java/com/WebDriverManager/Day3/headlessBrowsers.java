package com.WebDriverManager.Day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class headlessBrowsers {

    @Test
    public void Chome() {

        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        ChromeOptions cOptions = new ChromeOptions();
        cOptions.setHeadless(true);
        WebDriver driver = new ChromeDriver(cOptions);
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println(driver.getTitle());
        driver.close();

    }

    @Test
    public void Firefox() {

        System.setProperty("webdriver.gecko.driver", "./resources/geckodriver");
        FirefoxOptions cOptions = new FirefoxOptions();
        cOptions.setHeadless(true);
        WebDriver driver = new FirefoxDriver(cOptions);
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println(driver.getTitle());
        driver.close();

    }

    @Test
    public void HtmlUnitDriver() {

        WebDriver driver = new HtmlUnitDriver();
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println(driver.getTitle());
        // driver.close();

        driver.quit();

    }

}
