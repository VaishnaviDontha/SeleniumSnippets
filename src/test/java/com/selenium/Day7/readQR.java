package com.selenium.Day7;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class readQR {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/WebDrivers/chromedriver");
        driver.get("http://qrcode.meetheed.com/qrcode_examples.php");
        
    }

    @Test
    public void readingQR() throws NotFoundException, IOException {

        String qrCodeURL=driver.findElement(By.xpath("//img[@src='images/qr_code_con.png']")).getAttribute("src");
		
		URL url=new URL(qrCodeURL);
		
		BufferedImage bufferedimage=ImageIO.read(url);
		
		LuminanceSource luminanceSource=new BufferedImageLuminanceSource(bufferedimage);
		BinaryBitmap binaryBitmap=new BinaryBitmap(new HybridBinarizer(luminanceSource));
		
		Result result =new MultiFormatReader().decode(binaryBitmap);
		System.out.println(result.getText());

    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }
    
}
