package com.WebDriverManager.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class extractingInfo {

    WebDriver driver;

    @BeforeTest
    public void SetUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        
    }

    @Test
    public void getText() {

        String txt = driver.findElement(By.id("logInPanelHeading")).getText();
        System.out.println(txt);
        
    }

    @Test
    public void getAttribute() {

        String attribute = driver.findElement(By.id("btnLogin")).getAttribute("class");
        System.out.println(attribute);
        
    }
    
    @Test
    public void getSizeOfAnElement() {

        Dimension size = driver.findElement(By.id("logInPanelHeading")).getSize();
        System.out.println(size.getHeight());
        System.out.println(size.getWidth());
        System.out.println(size.height);
        System.out.println(size.width);
        
    } 

    @Test
    public void Isenabled() {

        driver.navigate().to("https://the-internet.herokuapp.com/jqueryui/menu#");
        Boolean elem = driver.findElement(By.xpath("//a[normalize-space()='Enabled']")).isEnabled();
        System.out.println(elem);
        
    }

    @Test
    public void isDisplayed() {

        Boolean elem = driver.findElement(By.xpath("//a[normalize-space()='Disabled']")).isDisplayed();
        System.out.println(elem);
        
    }

    @Test
    public void isSelected() {
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");

        Boolean elem = driver.findElement(By.xpath("//input[2]")).isSelected();
        System.out.println(elem);
        
    }
}
