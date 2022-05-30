package com.myfirstproject;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day09_ReadExcel {

        //    Import the apache poi dependency in your pom file => done
//    Create resources directory under java folder(right click on java and create the folder)
//    Add the Excel file on the resources' folder
//    Create a new package: excel automation
//    Create a new class : ReadExcel
//    Create a new test method : readExcel()
//    Store the path of the  file in a string
//    Open the file
//    Open the workbook using fileinputstream
//    Open the first worksheet
//    Go to first row
//    Go to first cell on that first row and print
//    Go to second cell on that first row and print
//    Go to 2nd row first cell  and assert if the data equal to the USA
//    Go to 3rd row 2nd cell-chain the row and cell
//    Find the number of row
//    Find the number of used row
//    Print country, capitol key value pairs as map object


    //    Create a new test method : readExcel()
    @Test
    public void readExcel() throws IOException {
        //    Store the path of the  file in a string
        String path = ".\\src\\test\\java\\resources\\Capitals.xlsx"; // windows
//        String path = "./src/test/java/resources/Capitals.xlsx"; //mac

        //    Open the file
        FileInputStream fileInputStream = new FileInputStream(path);


        //    Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);


        //    Open the first worksheet
        // getSheetAt() method accepts an integer snd is used for going a specific sheet
        // we should type the index, indexes starts from 0 for sheets
//        getSheet() method accepts string and we can go specific sheet by its name
//        Sheet sheet1 = workbook.getSheet("Sheet1");
        Sheet sheet1 = workbook.getSheetAt(0);


        //    Go to first row
        // getRow() method accepts an integer and is used for to go a specific row
        //to be able to go 1st row, you should type 0 inside it
        Row row1 = sheet1.getRow(0);

        //    Go to first cell on that first row and print
        //getCell() method accepts an integer, and it is used for to go a specific cell
        //to be able to go 1st cell, you should type 0 inside it
        Cell cell1 = row1.getCell(0);
        System.out.println(cell1);//COUNTRY


        /*
         * Cell objects can be converted to string easily,
         * we can manipulate the data, we can use toLowerCase(), toUpperCase(), length()..
         * */
        System.out.println(cell1.toString().toLowerCase());//country

        //    Go to second cell on that first row and print
        Cell cell2 = row1.getCell(1);
        System.out.println(cell2); //CAPITAL


        //    Go to 2nd row 1st cell  and assert if the data equal to the USA
        String r2c1 = sheet1.getRow(1).getCell(0).toString();
        Assert.assertEquals("USA",r2c1);

        //    Go to 3rd row 2nd cell-chain the row and cell
        String r3c2 = sheet1.getRow(2).getCell(1).toString();
        System.out.println(r3c2);//Paris

        //    Find the number of row
        /*getLastRowNum() => gives the last row index
                          => indexes starts from 0
                          => Checks the last row that is used
        * */
        int numberOfRow = sheet1.getLastRowNum() + 1;
        System.out.println(numberOfRow);



        //    Find the number of used row
        /*getPhysicalNumberOfRows() indexes starts from 1
         * Checks total number of rows that is used*/
        int numberOfUsedRows = sheet1.getPhysicalNumberOfRows();
        System.out.println(numberOfUsedRows);


        //  Print country, capital key value pairs as map object
        // {USA = D.C, France = Paris, England = London ...}
        Map<String,String> countriesAndCapitals = new HashMap<>();

        for(int rowNumber = 1; rowNumber <numberOfRow ; rowNumber++){
            String countries = sheet1.getRow(rowNumber).getCell(0).toString();
//            System.out.println(countries);
            String capitals = sheet1.getRow(rowNumber).getCell(1).toString();
//            System.out.println(capitals);

            countriesAndCapitals.put(countries,capitals);
        }

        System.out.println(countriesAndCapitals);
    }

}