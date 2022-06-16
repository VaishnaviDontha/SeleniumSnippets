package com.selenium.Day6.WorkingWithWordFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.testng.annotations.Test;

public class create_Write {

    @Test
    public void creatingWordFile() throws IOException {

        

        FileInputStream fis = new FileInputStream("./resources/Documents/data.docx");
        FileOutputStream out = new FileOutputStream("./resources/Documents/data.docx");

        XWPFDocument docx = new XWPFDocument(fis);

        XWPFParagraph p1 = docx.createParagraph();
        p1.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun r1 = p1.createRun();
        r1.setCapitalized(true);
        r1.setFontSize(20);
        r1.setFontFamily("Calibri");
        r1.setText("From Apache POI");

        XWPFParagraph p2 = docx.createParagraph();
        p2.setAlignment(ParagraphAlignment.CENTER);
        
        XWPFRun r2 = p2.createRun();
        r2.setText("I am second paragraph. My Text is Red in color and is embossed");
        r2.setColor("ff0000");
        r2.setEmbossed(true);
        r2.setStrikeThrough(true);

        XWPFHeader head = docx.createHeader(HeaderFooterType.DEFAULT);
            head.createParagraph()
                    .createRun()
                    .setText("This is document header");

        XWPFFooter foot = docx.createFooter(HeaderFooterType.DEFAULT);
            foot.createParagraph()
                    .createRun()
                    .setText("This is document footer");

        docx.write(out);

    }

}
