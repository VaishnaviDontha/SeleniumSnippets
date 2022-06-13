package com.selenium.Day6.ApachePOI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class creatingSheets {

    @Test
    public void createSheet() throws IOException {

        Workbook wb = new XSSFWorkbook();
        OutputStream file = new FileOutputStream("./resources/data.xlsx");

        Sheet sheetOne = wb.createSheet("Username");
        Sheet sheetTwo = wb.createSheet("Password");
        Sheet sheetThree = wb.createSheet("Notes");

        int numOfSheets = wb.getNumberOfSheets();
        System.out.println(numOfSheets);

        wb.write(file);
        wb.close();
        
    }
    
}
