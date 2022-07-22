package com.selenium.Day6.WorkingWithExcelFiles;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class readExcelSheetName {

    @Test
    public void readingExcel() throws IOException {

        String path = "./resources/Tests.xls";

        FileInputStream inputStream = new FileInputStream(path);

        String fileExtensionName = path.substring(path.indexOf("."));
        System.out.println(fileExtensionName);

        if (fileExtensionName.equals(".xlsx")) {

            XSSFWorkbook wb = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = wb.getSheet("Sheet1");

            int lastRow = sheet.getLastRowNum();

            for(int row =0;row<= lastRow; row++){

                for (int col = 0; col <= lastRow; col++) {

                    Row r = sheet.getRow(row);
                    Cell c = r.getCell(col);

                    System.out.println(sheet.getRow(row).getCell(col));
                }

            wb.close();

        }
    }

        else if (fileExtensionName.equals(".xls")) {

            HSSFWorkbook wb = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = wb.getSheetAt(0);

            int lastRow = sheet.getLastRowNum();

            for(int row =0;row<= lastRow; row++){

                for (int col = 0; col <= lastRow; col++) {

                    Row r = sheet.getRow(row);
                    Cell c = r.getCell(col);

                    System.out.println(sheet.getRow(row).getCell(col));
                }

            }

            wb.close();
        }
    }
}
