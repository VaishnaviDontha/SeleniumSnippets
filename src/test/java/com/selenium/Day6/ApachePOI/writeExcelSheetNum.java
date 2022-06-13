package com.selenium.Day6.ApachePOI;

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

public class writeExcelSheetNum {
   
    @Test
    public void writeDataExcel() throws IOException {

        String path = "/Users/harishkasam/Documents/Vaishnavi/Practise-Repo/snippets/resources/Tests.xlsx";

        FileInputStream inputStream = new FileInputStream(path);

        // Find the file extension by splitting file name in substring and getting only
        // extension name

        String fileExtensionName = path.substring(path.indexOf("."));
        System.out.println(fileExtensionName);

        // Check condition if the file is xlsx file

        if (fileExtensionName.equals(".xlsx")) {

            // If it is xlsx file then create object of XSSFWorkbook class
            
            XSSFWorkbook wb = new XSSFWorkbook(inputStream);
            // XSSFSheet sheet = wb.getSheetAt(0);
            XSSFSheet sheet = wb.getSheet("Sheet1");

            int lastRow = sheet.getLastRowNum();

            for(int i =0;i<= lastRow; i++){
                Row row = sheet.getRow(i);
                Cell cell = row.createCell(1);

                cell.setCellValue("Write Action via Apache POI");

            }

            FileOutputStream fos = new FileOutputStream(path);

            wb.write(fos);
            fos.close();
            wb.close();

        }

        // Check condition if the file is xls file

        else if (fileExtensionName.equals(".xls")) {

            // If it is xls file then create object of HSSFWorkbook class

            HSSFWorkbook wb = new HSSFWorkbook(inputStream);
            // HSSFSheet sheet = wb.getSheetAt(0);
            HSSFSheet sheet = wb.getSheet("Username");

            int lastRow = sheet.getLastRowNum();

            for(int i =0;i<= lastRow; i++){
                Row row = sheet.getRow(i);
                Cell cell = row.createCell(1);

                cell.setCellValue("Write Action via Apache POI");

            }

            FileOutputStream fos = new FileOutputStream(path);

            wb.write(fos);
            fos.close();
            wb.close();
        }


        // FileInputStream fis = new FileInputStream("./resources/data.xlsx");
        // Workbook wb = new XSSFWorkbook(fis);

        // Sheet sh = wb.getSheetAt(0);
        // // Sheet sh = wb.getSheet("Username");
        // int lastRow = sh.getLastRowNum();

        // for(int i =1;i<= lastRow; i++){
        //     Row row = sh.getRow(i);
        //     Cell cell = row.createCell(2);

        //     cell.setCellValue("Write Action via Apache POI");

        // }

        // FileOutputStream fos = new FileOutputStream("./resources/data.xlsx");
        // wb.write(fos);
        // fos.close();
        // wb.close();
        
    }
}
