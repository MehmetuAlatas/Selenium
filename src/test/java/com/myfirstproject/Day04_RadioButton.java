package com.myfirstproject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
public class Day04_RadioButton {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void radio(){
//        Create a class : RadioButton
//        Complete the following task
//        Go to https://www.facebook.com/
//
//        TEST CASE:
//        Click on Create new account
        driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();
//        Enter first name
        driver.findElement(By.name("firstname")).sendKeys("test f name");
//        Enter last name
        driver.findElement(By.name("lastname")).sendKeys("test l name");
//        Enter mobile number or email
        driver.findElement(By.name("reg_email__")).sendKeys("112233455");
//        Enter new password
        driver.findElement(By.name("reg_passwd__")).sendKeys("secretPass!");
//        Enter birthday(LATER)
//        Jan / 15 / 2000 => Try!
        //MONTH
        //1.Locate the dropdown
        WebElement monthDropdown = driver.findElement(By.xpath("//select[@id='month']"));
        //2.Create select object
        Select selectMonth = new Select(monthDropdown);
        //3.Choose Jan
        selectMonth.selectByVisibleText("Oca");
        //DAY
        //1.Locate the day dropdown
        WebElement dayDropdown = driver.findElement(By.xpath("//select[@id='day']"));
        //2.Create select object
        Select selectDay = new Select(dayDropdown);
        //3.Choose 15
        selectDay.selectByVisibleText("15");
        //YEAR
        //1.Locate the year dropdown
        WebElement yearDropdown = driver.findElement(By.xpath("//select[@id='year']"));
        //2.Create select object for year dropdown
        Select selectYear = new Select(yearDropdown);
        //3.Choose 2000
        selectYear.selectByVisibleText("2000");
//        Enter gender
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
//        Click Sign Up
        driver.findElement(By.name("websubmit")).click();
    }
    @After
    public void tearDown(){
//        driver.quit();
    }
}