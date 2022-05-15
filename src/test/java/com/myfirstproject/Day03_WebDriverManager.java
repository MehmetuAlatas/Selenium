package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day03_WebDriverManager {

        //   Verify the Google title

    public static void main(String[] args) {
        //Set the path
//        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");//windows
//        No longer no need to use System.setProperty() method
//        Instead of this we will use WebDriverManager

//        Calling chrome driver and setting it up
        WebDriverManager.chromedriver().setup();


//        Create chrome driver object
        WebDriver driver = new ChromeDriver();

//        Maximize the window
        driver.manage().window().maximize();

//        Go to Google homepage
        driver.get("https://www.google.com");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

//        Assert the title
        if(actualTitle.equals(expectedTitle)){
            System.out.println("PASSED");
//            System.out.println("Expected Title: " + expectedTitle);
//            System.out.println("Actual Title: " + actualTitle);

        } else {
            System.out.println("FAILED");
            System.out.println("Expected Title: " + expectedTitle);
            System.out.println("Actual Title: " + actualTitle);
        }

        driver.quit();

    }

}