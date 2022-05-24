package com.selenium.Day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class checkboxes {

    WebDriver driver;

    @BeforeTest
    public void Setup() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");

    }
/* 
    @Test
    public void singleDropdown() {

        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dp = new Select(dropdown);
        // dp.selectByValue("2");
        // dp.selectByIndex(1);
        dp.selectByVisibleText("Option 2");
        
    } */

    @Test
    public void multipleDropdown() {
        driver.get("https://www.spirit.com/");
        // driver.switchTo().alert().dismiss();

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));

        



        
    }

}
