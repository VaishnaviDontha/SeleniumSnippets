package com.selenium.Day5;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class captureTimestamp {


    @Test
    public void TimestampAndAppend() throws IOException {

        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("MM:dd:yyyy_HH:mm:ss");

        // or
        DateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy ");

        // OR
        DateFormat dateFormat3 = new SimpleDateFormat("dd");

        // OR
        DateFormat dateFormat4 = new SimpleDateFormat("MM");

        
        //get current date time with Date()
        Date date = new Date();
        
        // Now format the date
        String date1 = dateFormat.format(date);
        String date2 = dateFormat2.format(date);
        String date3 = dateFormat3.format(date);
        String date4 = dateFormat4.format(date);

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
        System.out.println(date4); 
        
    }

}