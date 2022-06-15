package com.selenium.Day6;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

public class readingPropertiesFile {

    @Test
    public void readPropFile() throws IOException {

        FileInputStream fis = new FileInputStream("./resources/Properties/config.properties");

        Properties prop = new Properties();
        prop.load(fis);

        Assert.assertEquals(prop.getProperty("url"), "https://the-internet.herokuapp.com/login");
        Assert.assertEquals(prop.getProperty("username"), "tomsmith");
        Assert.assertEquals(prop.getProperty("password"), "SuperSecretPassword!");
        
    }

    @Test
    public void readTxtFile() throws IOException {

        FileInputStream fis = new FileInputStream("./resources/Properties/config.txt");

        Properties prop = new Properties();
        prop.load(fis);

        Assert.assertEquals(prop.getProperty("url"), "https://the-internet.herokuapp.com/login");
        Assert.assertEquals(prop.getProperty("username"), "tomsmith");
        Assert.assertEquals(prop.getProperty("password"), "SuperSecretPassword!");
        
    }

    
    
}
