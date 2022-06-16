package com.selenium.Day6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;


public class writingPropertiesFile {

    @Test
    public void readPropFile() throws IOException {

        FileOutputStream fos = new FileOutputStream("./resources/Properties/config.properties");

        Properties prop = new Properties();
        prop.setProperty("User1", "Client");
        prop.setProperty("Environment", "Test");

        prop.store(fos, "Comments");

    }

    @Test
    public void readTxtFile() throws IOException {

        FileOutputStream fos = new FileOutputStream("./resources/Properties/config.txt");

        Properties prop = new Properties();
        
        prop.setProperty("User1", "Client");
        prop.setProperty("Environment", "Test");

        prop.store(fos, "Comments");
        
        
    }
    
}
