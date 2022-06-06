package com.WebDriverManager.Day5;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class screenshot {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        
        driver = new ChromeDriver();
        
        WebDriverManager.chromedriver().setup();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void webPageScreenshot() throws IOException {

        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("./resources/screenshot.png"));

    }

    @Test
    public void webElementScreenshot() {
        
    }

    @Test
    public void imageConversionWays() {
        
    }

    @Test
    public void highlightScreenshot() {
        
    }

    @Test
    public void comparingScreenshots() {

        
    }

    @Test
    public void addingScreenshotToPDF() {
        
    }



    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
    
}
