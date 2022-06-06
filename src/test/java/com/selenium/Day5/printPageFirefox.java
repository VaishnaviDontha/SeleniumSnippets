package com.selenium.Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.print.PrintOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class printPageFirefox {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        
        System.setProperty("webdriver.gecko.driver", "./resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless", "--disable-gpu");
        FirefoxDriver driver = new FirefoxDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void printPage() throws IOException {

        Path printPage = Paths.get("./resources/PrintPageChrome.pdf");
        Pdf print = ((PrintsPage) driver).print(new PrintOptions());
        Files.write(printPage, OutputType.BYTES.convertFromBase64Png(print.getContent()));
        driver.quit();
        
    }
}
