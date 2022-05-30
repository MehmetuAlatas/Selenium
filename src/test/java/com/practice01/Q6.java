package com.practice01;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Q6 {
    @Test
    public void name() throws IOException {
        String path=".\\src\\test\\java\\resources\\Capitals.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet1 = workbook.getSheetAt(0);
        Row row = sheet1.getRow(0);
        Cell cell =row.getCell(0);
        System.out.println("cell = " + cell);


        String r2c1 = sheet1.getRow(1).getCell(0).toString();


        Assert.assertEquals("USA",r2c1);

        String r3c2 = sheet1.getRow(2).getCell(1).toString();
        Map<String,String> countriesAndCapitals = new HashMap<>();
        for (int rowNumber = 1; rowNumber <sheet1.getLastRowNum()+1 ; rowNumber++) {
            String countries = sheet1.getRow(rowNumber).getCell(0).toString();
            String capitals = sheet1.getRow(rowNumber).getCell(1).toString();
            System.out.println(capitals+" "+countries);
            countriesAndCapitals.put(countries,capitals);
        }
        System.out.println("countriesAndCapitals = " + countriesAndCapitals);

      //  sheet1.getRow(0).createCell(2).setCellValue("population");


    }
}
