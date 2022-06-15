package com.selenium.Day6;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.itextpdf.text.pdf.codec.Base64.InputStream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class loadingPropertiesFromClassPath {

    @Test
    public void loadViaClassPath() throws IOException {

        String propFile = "config.properties";

        InputStream is = new InputStream(getClass().getClassLoader().getResourceAsStream(propFile));

        Properties prop = new Properties();

        if(is==null){
            System.out.println("No config.properties file!");
        }

        prop.load(is);
        
        

        Assert.assertEquals(prop.getProperty("url"), "https://the-internet.herokuapp.com/login");
        Assert.assertEquals(prop.getProperty("username"), "tomsmith");
        Assert.assertEquals(prop.getProperty("password"), "SuperSecretPassword!");
        
    }
    
}
