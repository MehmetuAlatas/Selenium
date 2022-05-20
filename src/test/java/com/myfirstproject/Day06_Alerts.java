package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day06_Alerts extends TestBase {
//    https://the-internet.herokuapp.com/javascript_alerts

        //    acceptAlert() => click on the first alert,
//    verify the text “I am a JS Alert” ,
//    click OK ,
//    and Verify “You successfully clicked an alert”
//
//    dismissAlert()=> click on the second alert,
//    verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”

        //    sendKeysAlert()=> click on the third alert,
//    verify text “I am a JS prompt”, type “Hello World”, click OK, and Verify “You entered: Hello World”

    @Test
    public void acceptAlert() throws InterruptedException {
//        click on the first alert,
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(5000);

//    verify the text “I am a JS Alert”
        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "I am a JS Alert";
        Assert.assertEquals(expectedAlertText,actualAlertText);

//    click OK
        driver.switchTo().alert().accept();
        Thread.sleep(5000);

//    and Verify “You successfully clicked an alert”
        String actualResultText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResultText = "You successfully clicked an alert";
        Assert.assertEquals(expectedResultText,actualResultText);
    }

        //    dismissAlert()=> click on the second alert,
//    verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”

    @Test
    public void dismissAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//        click on the second alert,
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(5000);
//         verify text "I am a JS Confirm”,
        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "I am a JS Confirm";
        Assert.assertEquals(expectedAlertText,actualAlertText);

//        click cancel
        driver.switchTo().alert().dismiss();
        Thread.sleep(5000);

//        and Verify “You clicked: Cancel”
        String expectedResultText = "You clicked: Cancel";
        String actualResultText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(expectedResultText,actualResultText);
    }

    //    sendKeysAlert()=> click on the third alert,
//    verify text “I am a JS prompt”, type “Hello World”, click OK, and Verify “You entered: Hello World”
    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//        click on the third alert,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(5000);

//    verify text “I am a JS prompt”
        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "I am a JS prompt";
        Assert.assertEquals(expectedAlertText,actualAlertText);

//   type “Hello World”
        driver.switchTo().alert().sendKeys("Hello World");
        Thread.sleep(5000);

//     click OK
        driver.switchTo().alert().accept();
        Thread.sleep(5000);

//      and Verify “You entered: Hello World”
        String actualResultText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResultText = "You entered: Hello World";
        Assert.assertEquals(expectedResultText,actualResultText);

    }
}