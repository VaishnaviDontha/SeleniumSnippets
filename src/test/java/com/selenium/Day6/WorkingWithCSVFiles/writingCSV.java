package com.selenium.Day6.WorkingWithCSVFiles;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.testng.annotations.Test;

public class writingCSV {

    @Test
    public void writeToCSV() throws IOException {

        String path = "./resources/Documents/test.csv";
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(path));

        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

        csvPrinter.printRecord("1", "Test1");
        csvPrinter.printRecord("2", "Test2");

        csvPrinter.flush();
        csvPrinter.close();

        
    }
    
}
