package com.selenium.Day6.WorkingWithExcelFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class createACell {

    @Test
    public void createAndWriteValueToACell() throws IOException {
        
        String path = "./resources/Tests.xls";

        FileInputStream inputStream = new FileInputStream(path);

        String fileExtensionName = path.substring(path.indexOf("."));
        System.out.println(fileExtensionName);

        if (fileExtensionName.equals(".xlsx")) {

            XSSFWorkbook wb = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = wb.getSheet("Sheet1");

            Row r = sheet.getRow(4);
            Cell cell = r.createCell(4);

            cell.setCellValue("Write Action via Apache POI");        

            FileOutputStream fos = new FileOutputStream(path);

            wb.write(fos);
            fos.close();
            
            wb.close();

        }

        else if (fileExtensionName.equals(".xls")) {

            HSSFWorkbook wb = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = wb.getSheet("Username");

            Row r = sheet.getRow(4);
            Cell cell = r.createCell(4);

            cell.setCellValue("Write Action via Apache POI");        
            
            FileOutputStream fos = new FileOutputStream(path);

            wb.write(fos);
            fos.close();

            wb.close();
        }

    }
    
}
