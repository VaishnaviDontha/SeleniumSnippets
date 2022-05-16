package com.selenium.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class usingJSExecutor {

    /*
     * Includes two methods
     * 1. executeASyncScript =
     * 2. executeScript = Executes JS in current Window or Frame.
     */

    WebDriver driver;

    @BeforeTest
    public void SetUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://the-internet.herokuapp.com/");

    }

    @Test
    public void JSExecutorMethods() throws InterruptedException {

        /*
         * STEPS :
         * 1. Import Package - JavacriptExecutor;
         * 2. Create Reference of the JS Executor
         * 3. Call the JS Executor method
         */

        JavascriptExecutor js = (JavascriptExecutor) driver;

        /*
         * Methods
         * 1. To refresh
         * 2. Display Alert Box
         * 3. Scroll
         * 4. Grab inner Text
         * 5. Grab Title of the page
         * 6. Pass Text
         */

        // Refresh
        js.executeScript("location.reload()");

        driver.findElement(By.cssSelector("a[href='/login']")).click();

        // Passing data

        js.executeScript("document.getElementById('username').value='tomsmith';");
        js.executeScript("document.getElementById('password').value='SuperSecretPassword!';");

        // Extracting Inner Text
        String sText = js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(sText);

        // Extracting title

        String sTitle = js.executeScript("return document.title;").toString();
        System.out.println(sTitle);

        driver.manage().window().maximize();

        // Scroll Down functionality

        js.executeScript("window.scrollBy(0,150)");

        js.executeScript("window.scrollBy(10,3000)");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        js.executeScript("alert('JS Execution')");

    }

}
