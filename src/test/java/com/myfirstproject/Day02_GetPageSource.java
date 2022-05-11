package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSource {

    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");//WINDOWS
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        Navigate to amazon homepage
        driver.get("https://www.amazon.com");

//        Test if amazon contains “Registry” on the homepage

        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

        if(pageSource.contains("Registry")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();
/*
Create a new class : Homework1 
Using ChromeDriver, Go to facebook and verify if page title is “facebook”, If not, print the correct title. 
Verify if the page URL contains facebook  if not, print the right url. 
Then Navigate to https://www.walmart.com/ 
Verify if the walmart page title includes “Walmart.com” 
Navigate back to facebook 
Refresh the page 
Maximize the window 
Close the browser
 */
    }
}