package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//    Create A Class: AmazonDropdown
public class AmazonDropdown {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //    Create A Method dropdownTest
    @Test
    public void dropdownTest() {
//    Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");
//    Find the element of the dropdown element. HINT:By.id(“searchDropdownBox")
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
//    Print the first selected option and assert if it equals “All Departments”
        Select select = new Select(dropdown);
        String actualFirstSelected = select.getFirstSelectedOption().getText();
        System.out.println("actualFirstSelected = " + actualFirstSelected);
        String expectedFirstSelected = "All Departments";
        Assert.assertEquals(actualFirstSelected, expectedFirstSelected);
//    Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
//    (after you select you need to use get first  selected option method)
        select.selectByIndex(3);
        String actualSelected = select.getFirstSelectedOption().getText();
        String expectedSelected = "Baby";
        Assert.assertEquals(actualSelected, expectedSelected);
//    Print all of the dropdown options-getOptions(); method returns the
//    List<WebElement>. Using loop, print all options.
        List<WebElement> dropdownList = select.getOptions();
        for (WebElement each : dropdownList) {
            System.out.println(each.getText());
        }

//    Print the the total number of options in the dropdown Check if ‘Appliances’
//    is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
        System.out.println("totalNumberOfOptions = " + dropdownList.size());
        boolean flag = false;
        for (WebElement each : dropdownList) {
            if (each.getText().equals("Appliances")) {
                flag = true;
            }
        }
        System.out.println(flag ? "true" : "false");
//        Assert.assertTrue(flag);
//    BONUS: Check if the dropdown is in Alphabetical Order
        List<String> actualList = new ArrayList<>();
        for (WebElement each : dropdownList) {
            actualList.add(each.getText());
        }
        List<String> sortedList = new ArrayList<>();
        sortedList.addAll(actualList);
        Collections.sort(sortedList);
        if (actualList.equals(sortedList)) {
            System.out.println("Alphabetical Order");
        } else {
            System.out.println("It does not in Alphabetical Order");
        }
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
