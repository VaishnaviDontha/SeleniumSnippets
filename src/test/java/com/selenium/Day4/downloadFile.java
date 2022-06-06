package com.selenium.Day4;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class downloadFile {
    
    WebDriver driver;

    @BeforeTest
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.prompt_for_download", false);
		options.setExperimentalOption("prefs", prefs);
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
        driver.get("https://the-internet.herokuapp.com/download");
        
    }

    @Test
    public void downloaderBrowserProfile(){

        WebElement btnDownload = driver.findElement(By.cssSelector("a[href='download/LambdaTest.txt']"));
		btnDownload.click();
        System.out.println("Click Performed");
 
    }
    
    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }


    
}
