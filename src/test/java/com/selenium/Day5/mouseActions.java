package com.selenium.Day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mouseActions {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        driver.get("https://the-internet.herokuapp.com/hovers");

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    }

    @Test
    public void click() {

        WebElement elem = driver.findElement(By.xpath("//div[@class='example']/div[1]/img"));
        new Actions(driver).clickAndHold(elem)
                            .perform();

        // Assert.assertEquals("name: user1", elem.getText());
        
    }


    @Test
    public void clickAndRelease() {

        WebElement elem = driver.findElement(By.xpath("//div[@class='example']/div[2]/img"));
        new Actions(driver).click(elem)
                            .perform();

        // Assert.assertEquals("name: user2", elem.getText());
        
    }

    @Test
    public void contextClick() {

        WebElement elem = driver.findElement(By.xpath("//div[@class='example']/div[1]/img"));
        new Actions(driver).contextClick(elem)
                            .perform();

        // Assert.assertEquals("name: user1", elem.getText());
        
    }


    @Test
    public void doubleClick() {

        WebElement elem = driver.findElement(By.xpath("//div[@class='example']/div[2]/img"));
        new Actions(driver).doubleClick(elem)
                            .perform();

        // Assert.assertEquals("name: user2", elem.getText());
        
    }

    @Test
    public void moveToElement() {

        driver.get("https://the-internet.herokuapp.com/dynamic_content?with_content=static");
        WebElement elem = driver.findElement(By.xpath("//div[@class='large-10 columns large-centered']/div[1]/div[2]"));
        new Actions(driver).moveToElement(elem)
                            .perform();

        String actual = "Accusantium eius ut architecto neque vel voluptatem vel nam eos minus ullam dolores voluptates enim sed voluptatem rerum qui sapiente nesciunt aspernatur et accusamus laboriosam culpa tenetur hic aut placeat error autem qui sunt.";

        Assert.assertEquals(actual, elem.getText());
        
    }

    @Test
    public void moveToElementByCoordinates() {

        driver.get("https://the-internet.herokuapp.com/dynamic_content?with_content=static");
        WebElement elem = driver.findElement(By.xpath("//div[@class='large-10 columns large-centered']/div[1]/div[2]"));
        new Actions(driver).moveToElement(elem, 10, 12)
                            .perform();

        String actual = "Accusantium eius ut architecto neque vel voluptatem vel nam eos minus ullam dolores voluptates enim sed voluptatem rerum qui sapiente nesciunt aspernatur et accusamus laboriosam culpa tenetur hic aut placeat error autem qui sunt.";

        Assert.assertEquals(actual, elem.getText());
        
    }

    @Test
    public void moveByOffset() {

        driver.get("https://the-internet.herokuapp.com/dynamic_content?with_content=static");
        WebElement elem = driver.findElement(By.xpath("//div[@class='large-10 columns large-centered']/div[1]/div[2]"));
        new Actions(driver).moveByOffset(10, 12)
                            .perform();

        String actual = "Accusantium eius ut architecto neque vel voluptatem vel nam eos minus ullam dolores voluptates enim sed voluptatem rerum qui sapiente nesciunt aspernatur et accusamus laboriosam culpa tenetur hic aut placeat error autem qui sunt.";

        Assert.assertEquals(actual, elem.getText());
        
    }


    @Test
    public void dragAndDropOnElement() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement drag = driver.findElement(By.id("column-a"));
        WebElement drop = driver.findElement(By.id("column-b")); 
        
        new Actions(driver)
                .dragAndDrop(drag, drop)
                .perform();

        Thread.sleep(3000);
    }
    

    @Test
    public void dragAndDropByOffset() {

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement drag = driver.findElement(By.xpath("//div[@id='columns']/div[1]")); 
        
        new Actions(driver)
                .dragAndDropBy(drag, 3, 2)
                .perform();
        
        
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
        
    }

    
}
