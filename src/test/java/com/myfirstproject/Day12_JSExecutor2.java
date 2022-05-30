package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Day12_JSExecutor2 extends TestBase {
    @Test
    public void jsExecutorTest() throws InterruptedException {
        driver.get("https://www.carettahotel.com/");
        Thread.sleep(3000);
//        scroll to Our Room
        WebElement ourRooms = driver.findElement(By.xpath("//*[.='Our Rooms']"));
        scrollIntoViewByJS(ourRooms);
    }
    @Test
    public void scrollAllDownByJSTest() throws InterruptedException {
        driver.get("https://www.carettahotel.com/");
        Thread.sleep(3000);
//        scrolling all the way down
        scrollAllDownByJS();
        Thread.sleep(3000);
//        scrolling all the way up
        scrollAllUpByJS();
    }
    @Test
    public void clickByJSTest() throws InterruptedException {
        driver.get("https://www.carettahotel.com/");
        Thread.sleep(3000);
//click on check availability
        WebElement checkAvailability = driver.findElement(By.xpath("//input[@type='submit']"));
        clickByJS(checkAvailability);
//click on search button
        WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));
        clickByJS(searchButton);

    }
    @Test
    public void setValueByJS() throws InterruptedException {
        driver.get("https://www.carettahotel.com/");
        Thread.sleep(3000);

        WebElement checkOutDate = driver.findElement(By.id("checkout_date"));
//        Updating the text of checkout date
        setValueByJS(checkOutDate,"6/25/2022");

    }

    @Test
    public void getValueByJS() throws InterruptedException {
        driver.get("https://www.carettahotel.com/");
        Thread.sleep(3000);

        WebElement checkOutDate = driver.findElement(By.id("checkout_date"));
        System.out.println("checkOutDate.getText() = " + checkOutDate.getText());//returns empty string

        getValueByJS("checkout_date");
//        How you get get the value of an input box?
//        We can js executor.
//        How?
//        I can get the element using js executor, and get teh value of the element.
//        For example, I can get the element by id, and use value attribute to get the value of in an input
//        I have to do this, cause getText in this case does not return teh text in an input
    }
    @Test
    public void changeBackgroundColorByJSTest() throws InterruptedException, IOException {
        driver.get("https://www.carettahotel.com/");
        Thread.sleep(3000);
        WebElement checkAvailability = driver.findElement(By.xpath("//input[@type='submit']"));
        changeBackgroundColorByJS(checkAvailability,"red");
        takeScreenShot();
    }
    @Test
    public void addBorderWithJSTest() throws InterruptedException, IOException {
        driver.get("https://www.carettahotel.com/");
        Thread.sleep(3000);
        WebElement loginButton = driver.findElement(By.xpath("//a[.='Log in']"));
        Thread.sleep(3000);
        addBorderWithJS(loginButton,"3px solid red");
        Thread.sleep(3000);
        takeScreenShot();
    }
    /**What is javascript executor?
    js executor is an API to execute javascript comments in selenium
    When did you use it?
    when we can not interact with some webelements with a traditional selenium methods
    For example, when we cannot click, scroll, get text… then we can use js executor
    How do you scroll with selenium?
    There are 2 ways: actions class, js executor
    Actually, I am using js executor, since it is better
    For example, with js executor, I can scroll to a specific element(scrollIntoView), or right, left, all the way bottom,… We have a reusable method that I can call to scroll on a specific element
    How do you get the text in an input?
    I use getText() method for getting the text on a page. HOWEVER, we need to use jsexecutor to get the input value. I have a reusable method to get the value from an input.
    What would you do if your selenium click doesn’t work?
    I can use javascript executor click. I can get the element and click using javascript.*/

}