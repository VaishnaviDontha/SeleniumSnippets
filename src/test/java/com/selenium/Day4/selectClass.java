package com.selenium.Day4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class selectClass {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");

        driver.findElement(By.xpath("//input[@name='Submit']")).click();
        
    }

    @Test
    public void fewMoreFuncInSelectClass() {

        /* 
            * getAllSelectedOptions()
            * getFirstSelectedOption()
            * getOptions()
            * isMultiple()
        */
        
        driver.findElement(By.xpath("//b[text()='Leave']")).click();

        WebElement selectElem = driver.findElement(By.xpath("//select[@id='leaveList_cmbSubunit']"));

        Select sObject = new Select(selectElem);
        sObject.selectByIndex(5);


        List<WebElement> allSelectedOptions = sObject.getAllSelectedOptions();
        System.out.println(allSelectedOptions);

        Boolean equal = sObject.equals("TechOps");
        System.out.println(equal);

        System.out.println("---------");
        
        sObject.getClass();

        WebElement selOption = sObject.getFirstSelectedOption();
        System.out.println(selOption);

        List<WebElement> allOptions = sObject.getOptions();
        System.out.println(allOptions);

        sObject.getWrappedElement();

        Boolean multipleSelections = sObject.isMultiple();
        System.out.println(multipleSelections);
    
        // sObject.wait();
        // sObject.wait(timeoutMillis);
        // sObject.wait(timeoutMillis, nanos);
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
    
}
 