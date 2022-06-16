package com.WebDriverManager.Day6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class captureBrowserLogs {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        
    }

    @Test
    public void browserLogs() {

        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Log.enable());
        
        devTools.addListener(Log.entryAdded(),
                                logEntry -> {
                                    System.out.println("log: "+logEntry.getText());
                                    System.out.println("level: "+logEntry.getLevel());
                                });
        
    }

    @Test
    public void withoutDevTools() {

        Logs logs = driver.manage().logs();
        LogEntries logentries = logs.get(LogType.BROWSER);

        for (org.openqa.selenium.logging.LogEntry logEntry : logentries) {

            System.out.println(logEntry.getMessage());
            
        }

        
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
    
}
