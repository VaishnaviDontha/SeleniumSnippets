package com.WebDriverManager.Day5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class screenshot {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        
        driver = new ChromeDriver();
        
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
    public void highlightScreenshot() throws InterruptedException, IOException {

        WebElement element = driver.findElement(By.cssSelector("h2"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='3px solid yellow'", element);

        Thread.sleep(3000);

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("./resources/highlightedScreenshot.png"));
        
    }

    @Test
    public void comparingScreenshots() throws InterruptedException {
        
		String screenshotOne = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64); 
        Thread.sleep(3000);
        String screenshotTwo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

        if(screenshotOne.equals(screenshotTwo)){
            System.out.println("Matching");
        }
        else
            System.out.println("NOT Matching");        
    }

    @Test
    public void addingScreenshotToPDF() throws DocumentException, MalformedURLException, IOException {
        
        DateFormat dateFormat = new SimpleDateFormat("_MM:dd:yyyy_HH:mm:ss");
        Date dt = new Date();
        String timestamp= dateFormat.format(dt);


        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

        Document doc = new Document();
        String out = "./resources/PDF" + timestamp + ".pdf";

        FileOutputStream fos = new FileOutputStream(out);
        
        PdfWriter writer = PdfWriter.getInstance(doc,fos);
        writer.open();
        doc.open();

        Image im = Image.getInstance(screenshot);
        im.scaleToFit(PageSize.A4.getWidth()/2, PageSize.A4.getHeight()/2);

        doc.add(im);
        doc.add(new Paragraph("Adding Image to PDF!"));

        doc.close();
        writer.close();
        
    }



    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
    
}
