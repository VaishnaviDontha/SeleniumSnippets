package com.selenium.Day6.ApachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcel {

    // WebDriver driver;

    // @BeforeTest
    // public void setUp() {

    //     driver = new ChromeDriver();
    //     System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
        
    // }

    @Test
    public void readExcelData() throws IOException {

        FileInputStream fis = new FileInputStream("./resources/data.xlsx");
        
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        XSSFSheet sheet = wb.getSheetAt(0);

        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(sheet.getRow(0).getCell(0));
        System.out.println(cell);

        Row row1 = sheet.getRow(1);
        Cell cell1 = row1.getCell(1);
        System.out.println(sheet.getRow(0).getCell(1));
        System.out.println(cell1);

        Row row2 = sheet.getRow(1);
        Cell cell2 = row2.getCell(1);
        System.out.println(sheet.getRow(1).getCell(0));
        System.out.println(cell2);

        Row row3 = sheet.getRow(1);
        Cell cell3 = row3.getCell(1);
        System.out.println(sheet.getRow(1).getCell(1));
        System.out.println(cell3);
        
        wb.close();
    }
    
}
