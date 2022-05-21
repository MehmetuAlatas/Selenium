package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Day06_Iframe extends TestBase {

        //    Create a class: IFrameTest
//    Create a method: iframeTest
//    Go to https://the-internet.herokuapp.com/iframe
//    Verify the Bolded text contains “Editor”
//    Locate the text box
//    Delete the text in the text box
//    Type “This text box is inside the iframe”
//    Verify the text Elemental Selenium text is displayed on the page

    @Test
    public void iframeTest() throws InterruptedException {
//    Go to https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");

        //    Verify the Bolded text contains “Editor”
        String boldedText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(boldedText.contains("Editor"));

//    Locate the text box
//    Delete the text in the text box
//        driver.findElement(By.xpath("//p")).clear();


//        TextBox is in the iFrame, I should switch to iframe firstly.
//        There are 3 ways to switch to iFrame => index, id, WebElement

//     1.Way:   by using index
//        driver.switchTo().frame(0);
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//p")).clear();
//        Thread.sleep(5000);

//      2.Way: by using id => id of iframe
//        driver.switchTo().frame("mce_0_ifr");
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//p")).clear();
//        Thread.sleep(5000);

//      3.Way: WebElement
        WebElement iFrame = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iFrame);
        Thread.sleep(5000);
//        driver.findElement(By.xpath("//p")).clear();
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        Thread.sleep(5000);

//    Type “This text box is inside the iframe”
        textBox.sendKeys("This text box is inside the iframe");
        Thread.sleep(5000);

//    Verify the text Elemental Selenium text is displayed on the page
        driver.switchTo().parentFrame(); //get 1 upper level by using parentFrame()
        driver.switchTo().defaultContent();//get us to default level
        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSelenium.isDisplayed());


//      How do you find how many iframes are there in a page?
        List<WebElement> iframes=driver.findElements(By.tagName("iframe"));
        System.out.println("iframe number :"+iframes.size());

    }

}