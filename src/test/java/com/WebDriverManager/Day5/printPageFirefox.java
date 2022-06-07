package com.WebDriverManager.Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.print.PrintOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class printPageFirefox {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        
        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void printPage() throws IOException {

        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("MM:dd:yyyy_HH:mm:ss");
        
        //get current date time with Date()
        Date date = new Date();
        
        // Now format the date
        String date1= dateFormat.format(date);

        // Appending timestamp to the path
        Path printPage = Paths.get("./resources/PrintPageFirefox_"+date1+".pdf");
        Pdf print = ((PrintsPage) driver).print(new PrintOptions());
        Files.write(printPage, OutputType.BYTES.convertFromBase64Png(print.getContent()));        
                
        driver.quit();
    }
        
}
