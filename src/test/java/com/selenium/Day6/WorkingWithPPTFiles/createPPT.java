package com.selenium.Day6.WorkingWithPPTFiles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hslf.usermodel.HSLFSlide;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.testng.annotations.Test;

public class createPPT {

    @Test
    public void createPPT() throws IOException {

        String path = "/Users/harishkasam/Documents/Vaishnavi/Practise-Repo/snippets/resources/Documents/data.ppt";
        OutputStream outputStream = new FileOutputStream(path);

        String fileExtensionName = path.substring(path.indexOf("."));
        System.out.println(fileExtensionName);

        if (fileExtensionName.equals(".pptx")) {

            XMLSlideShow pptx = new XMLSlideShow();
            XSLFSlide blankslide = pptx.createSlide();

            pptx.write(outputStream);
            pptx.close();

        }

        else if (fileExtensionName.equals(".ppt")) {

            
            HSLFSlideShow ppt = new HSLFSlideShow();
            HSLFSlide blankSlide = ppt.createSlide();
            
            ppt.write(outputStream);
            ppt.close();

        }

    }
    
}
