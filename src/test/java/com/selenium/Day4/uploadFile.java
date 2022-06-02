package com.selenium.Day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class uploadFile {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://the-internet.herokuapp.com/upload");
        
    }

    @Test
    public void uploaderSendKeys() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement addFile = driver.findElement(By.xpath(".//input[@type='file']"));
		addFile.sendKeys("/Users/harishkasam/Documents/Vaishnavi/Practise-Repo/snippets/resources/Papos.png");
		
		driver.findElement(By.cssSelector("input[id='file-submit']")).click();
        
        String text = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();

		if(text.equalsIgnoreCase("File Uploaded!")) {
			
            Assert.assertTrue(true, "Image Uploaded");

		}
        else
            Assert.assertTrue(false, "Image Not Uploaded");
 
    }
    
    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
}
