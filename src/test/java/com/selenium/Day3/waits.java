package com.selenium.Day3;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class waits {

    WebDriver driver;

    @BeforeTest
    public void SetUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        driver.findElement(By.xpath("//a[@href='/dropdown']")).click();

        WebElement elem = driver.findElement(By.cssSelector("#dropdown"));
        Select dropdown = new Select(elem);
        dropdown.selectByValue("2");
    } 

    @Test
    public void explicitWait() {

        driver.findElement(By.xpath("//a[text()='JavaScript Alerts']")).click();
        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        
        // Alert is Present
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        WebElement locator = driver.findElement(By.xpath("//p[@id='result']"));

        // Text to be Present
        wait.until(ExpectedConditions.textToBePresentInElement(locator, "You successfully clicked an alert"));


        WebElement elem = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));

        // Element to be CLickable
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        WebElement locator2 = driver.findElement(By.xpath("//p[@id='result']"));

        // Text Present 
        wait.until(ExpectedConditions.textToBePresentInElement(locator2, "You clicked: Ok"));

        // Title present
        wait.until(ExpectedConditions.titleIs("The Internet"));

        // Title contains
        wait.until(ExpectedConditions.titleContains("The Internet"));

        // URL to be so and so
        wait.until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/javascript_alerts"));

        driver.navigate().back();
        
    }
 
    @Test
    public void fluentWait() {

        driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();

        Wait<WebDriver> fw = new FluentWait<WebDriver>(driver)
                                            .withTimeout(Duration.ofMinutes(1))
                                            .pollingEvery(Duration.ofSeconds(30))
                                            .ignoring(NoSuchElementException.class);
    

        WebElement feelingLuckyButton = (WebElement) fw.until(new Function<WebDriver, WebElement>() {
                                            public WebElement apply(WebDriver driver) {
                                                    System.out.println("Polling for Add Element Button");
                                                    // return the button as webelement
                                                    return driver.findElement(By.cssSelector("button[onclick='addElement()']"));
                                                }
                                            });
        System.out.println("clicking Add Element button");
        
        // click feeling lucky button
        feelingLuckyButton.click();
        
    } 

    @AfterTest
    public void TearDown() {
        driver.close();
        
    }

}