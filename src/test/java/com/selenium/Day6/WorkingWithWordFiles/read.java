package com.selenium.Day6.WorkingWithWordFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.testng.annotations.Test;

public class read {

    @Test
    public void readingWord() throws IOException {

        FileInputStream fis = new FileInputStream("./resources/Documents/data.docx");

        XWPFDocument docx = new XWPFDocument(fis);
        XWPFWordExtractor wordextractor = new XWPFWordExtractor(docx);
        String text = wordextractor.getText();
        System.out.println(text);

        
    }
    
}
