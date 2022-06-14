package com.selenium.Day6.WorkingWithExcelFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class writeExcel {
   
    @Test
    public void writeDataExcel() throws IOException {

        FileInputStream fis = new FileInputStream("./resources/data.xlsx");
        Workbook wb = new XSSFWorkbook(fis);

        Sheet sh = wb.getSheetAt(0);
        // Sheet sh = wb.getSheet("Username");
        int lastRow = sh.getLastRowNum();

        for(int i =1;i<= lastRow; i++){
            Row row = sh.getRow(i);
            Cell cell = row.createCell(2);

            cell.setCellValue("Write Action via Apache POI");

        }

        FileOutputStream fos = new FileOutputStream("./resources/data.xlsx");
        wb.write(fos);
        fos.close();
        wb.close();
        
    }
}
