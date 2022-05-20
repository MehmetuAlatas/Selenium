package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day06_TestBaseDemo extends TestBase {

        //    WebDriver driver;
//    @Before
//    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//    }

    @Test
    public void test01(){
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void test02(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }

        //    @After
//    public void tearDown(){
//        driver.quit();
//    }

        //    => setUp => test01 => tearDown
//    => setUp => test02 => tearDown

}