package com.selenium.Day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dropdowns {

        /* 
            1. selectByVisibleTest(String)
            2. selectByIndex(int)
            3. selectByValue(String)

        */    
        
    WebDriver driver;

    @BeforeTest
    public void Setup() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");

    }

    @Test
    public void singleDropdown() {

        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select dp = new Select(dropdown);
        // dp.selectByValue("2");
        // dp.selectByIndex(1);
        dp.selectByVisibleText("Option 2");

    }

    @Test
    public void multipleDropdown() {

        driver.get("https://chercher.tech/practice/dropdowns1");
       
        // driver.switchTo().alert().dismiss();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='second']"));

        Select dropdown = new Select(dropdownElement);
    
        // dropdown.selectByValue("donut");
        // dropdown.selectByValue("burger");  
        // dropdown.selectByIndex(1);
        // dropdown.selectByIndex(3);  

        dropdown.selectByVisibleText("Donut");
        dropdown.selectByVisibleText("Burger");
    }


    @Test
    public void deselectDropdown() {
        
        driver.get("https://chercher.tech/practice/dropdowns1");
       
        // driver.switchTo().alert().dismiss();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='second']"));

        Select dropdown = new Select(dropdownElement);
    
        // dropdown.selectByValue("donut");
        // dropdown.selectByValue("burger");  
        // dropdown.selectByIndex(1);
        // dropdown.selectByIndex(3);  

        dropdown.selectByVisibleText("Donut");
        dropdown.selectByVisibleText("Burger");

        dropdown.deselectAll();
        dropdown.deselectByIndex(1);
        dropdown.deselectByValue("donut");
        dropdown.deselectByVisibleText("Donut");

    }


    @Test
    public void otherWaysForDropdown() {
        
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        driver.findElement(By.xpath("//b[text()='Admin']")).click();
        driver.findElement(By.xpath("//a[text()='Job']")).click();

        driver.findElement(By.id("#menu_admin_employmentStatus")).click();

    }

    @AfterTest
    public void tearDown() {

        driver.quit();

    }

}
