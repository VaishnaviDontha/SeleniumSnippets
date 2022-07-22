package com.selenium.Day6.WorkingWithExcelFiles;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class retrievingValues {

    @Test
    public void retrieveValues() throws IOException {
        
        String path = "/Tests.xls";

        FileInputStream inputStream = new FileInputStream(path);

        String fileExtensionName = path.substring(path.indexOf("."));
        System.out.println(fileExtensionName);

        if (fileExtensionName.equals(".xlsx")) {

            XSSFWorkbook wb = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = wb.getSheet("Sheet1");

            Row row = sheet.getRow(0);
            Cell cell = row.getCell(0);

            System.out.println(cell);
            System.out.println(sheet.getRow(0).getCell(0));

            wb.close();

        }

        else if (fileExtensionName.equals(".xls")) {

            HSSFWorkbook wb = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = wb.getSheetAt(0);

            Row row = sheet.getRow(0);
            Cell cell = row.getCell(0);

            System.out.println(cell);
            System.out.println(sheet.getRow(0).getCell(0));

            wb.close();
        }

        
        
    }
    
}
