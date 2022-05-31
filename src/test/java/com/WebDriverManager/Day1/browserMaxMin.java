package com.WebDriverManager.Day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class browserMaxMin {

    private WebDriver driver;

    @BeforeTest
    public void SetUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @Test
    public void MaximizeBrowser() {

        driver.manage().window().maximize();

    }

    @Test
    public void MinimizeBrowser() {

        driver.manage().window().minimize();

    }

    @Test
    public void SpecificSize() {


        driver.manage().window().setSize(new Dimension(200, 200));
        
        // Methods related to the Browser size
        Dimension Size = driver.manage().window().getSize();
        int Height = Size.getHeight();
        int Width = Size.getWidth();
        
        System.out.println(Size);
        System.out.println(Height);
        System.out.println(Width);

    }

    @AfterTest
    public void TearDown() {

        driver.quit();

    }

}
