package com.selenium.Day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class remoteWebDriver__TODO {
    
    @Test
    public void Chome() {

        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        ChromeOptions cOptions = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(cOptions);
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println(driver.getTitle());
        driver.close();

    }

   /*  @Test
    public void Firefox() {

        System.setProperty("webdriver.gecko.driver", "./resources/geckodriver");
        FirefoxOptions cOptions = new FirefoxOptions();
        cOptions.setCapability("browserVersion", "67");
        cOptions.setCapability("platformName", "Windows XP");
        WebDriver driver = new RemoteWebDriver(cOptions);
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println(driver.getTitle());
        driver.close();

    } */

}
