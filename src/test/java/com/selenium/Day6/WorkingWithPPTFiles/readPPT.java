package com.selenium.Day6.WorkingWithPPTFiles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.poi.hslf.usermodel.HSLFSlide;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.HSLFTextBox;
import org.apache.poi.hslf.usermodel.HSLFTextParagraph;
import org.apache.poi.hslf.usermodel.HSLFTextRun;
import org.apache.poi.sl.usermodel.TextParagraph.TextAlign;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.testng.annotations.Test;

public class readPPT {

    @Test
    public void createPPT() throws IOException {

        String path = "/Users/harishkasam/Documents/Vaishnavi/Practise-Repo/snippets/resources/Documents/data.pptx";
        OutputStream outputStream = new FileOutputStream(path);

        String fileExtensionName = path.substring(path.indexOf("."));
        System.out.println(fileExtensionName);

        if (fileExtensionName.equals(".pptx")) {

            XMLSlideShow pptx = new XMLSlideShow();
            XSLFSlide blankslide = pptx.createSlide();

            List<XSLFSlide> numOfSlides = pptx.getSlides();
            System.out.println(numOfSlides.size());

            pptx.write(outputStream);
            pptx.close();

        }

        else if (fileExtensionName.equals(".ppt")) {

            
            HSLFSlideShow ppt = new HSLFSlideShow();
            HSLFSlide blankSlide = ppt.createSlide();

            List<HSLFSlide> numofSlides = ppt.getSlides();
            System.out.println(numofSlides.size());
            
            ppt.write(outputStream);
            ppt.close();

        }

    }
    
}
