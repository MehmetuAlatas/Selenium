package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Day12_JSExecutor extends TestBase {

        /**
         * What is JS Executor?
         * It is an API which is used to execute javascript commands in Selenium
         *
         * Why are we learning JavaScript Executor?
         * We might need some js executor method to interact with some webelements
         * When traditional methods are not enough
         * click, scrolling into a specific element
         *
         * What can we do by using JS Executor?
         * Click. It is good especially when we want to click a hidden element.
         * Scroll onto a specific webelement, scroll down/up/right/left
         * Type an input
         * Change the value of an element
         * Hover over
         * Change background colour...
         *
         *
         * */
        /*
        *JavascriptExecutor js = (JavascriptExecutor) driver;
        *Example 1: Clicking on a button
        *WebElement button =driver.findElement(By.name("btnLogin"));
        * //Perform Click on LOGIN button using JavascriptExecutor
        *js.executeScript("arguments[0].click();", button);
        *arguments[0] -> the first argument in executeScript method
        *click() -> js function to click. It can be scrollIntoView,…
        *Example 2: We will scroll down to this element
        *WebElement resentBlog = driver.findElement(By.xpath("//*[.='Recent Blog']"));
        *js.executeScript("arguments[0].scrollIntoView(true);",resentBlog);
         */

    @Test
    public void jsExecutorTest() throws InterruptedException {

       driver.get("https://www.carettahotel.com/");
       Thread.sleep(5000);
        WebElement ourRooms = driver.findElement(By.xpath("//*[.='Our Rooms']"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",ourRooms);

        Thread.sleep(3000);
        WebElement email=driver.findElement(By.xpath("//span[.='info@carettahotel.com']"));
        js.executeScript("arguments[0].scrollIntoView(true)",email);

        Thread.sleep(3000);
        WebElement checkAvaliablity=driver.findElement(By.xpath("//input[@type='submit']"));
        js.executeScript("arguments[0].scrollIntoView(true)",checkAvaliablity);


    }



}