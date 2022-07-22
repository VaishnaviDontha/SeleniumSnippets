package com.selenium.Day6.WorkingWithExcelFiles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class creatingSheets {

    @Test
    public void createSheet() throws IOException {

        String path = "/data.xls";
        OutputStream outputStream = new FileOutputStream(path);

        String fileExtensionName = path.substring(path.indexOf("."));
        System.out.println(fileExtensionName);

        if (fileExtensionName.equals(".xlsx")) {

            XSSFWorkbook wb = new XSSFWorkbook();

            Sheet sheetOne = wb.createSheet("Username");
            Sheet sheetTwo = wb.createSheet("Password");
            Sheet sheetThree = wb.createSheet("Notes");

            int numOfSheets = wb.getNumberOfSheets();
            System.out.println(numOfSheets);

            wb.write(outputStream);
            wb.close();

        }

        else if (fileExtensionName.equals(".xls")) {

            HSSFWorkbook wb = new HSSFWorkbook();

            Sheet sheetOne = wb.createSheet("Username");
            Sheet sheetTwo = wb.createSheet("Password");
            Sheet sheetThree = wb.createSheet("Notes");

            int numOfSheets = wb.getNumberOfSheets();
            System.out.println(numOfSheets);

            wb.write(outputStream);
            wb.close();
        }
        
    }
    
}
