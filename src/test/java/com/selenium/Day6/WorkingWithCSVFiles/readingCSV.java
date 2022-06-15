package com.selenium.Day6.WorkingWithCSVFiles;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.Test;

public class readingCSV {

    @Test
    public void readCSVWithHeadersAutoDetection() throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get("./resources/Documents/test.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

        for (CSVRecord csvRecord : csvParser) {

            String num = csvRecord.get(0);
            String name = csvRecord.get(1);

            System.out.println("Record - " +csvRecord.getRecordNumber());
            System.out.println(num);
            System.out.println(name);
            
        }
        
    }

   
    
}
