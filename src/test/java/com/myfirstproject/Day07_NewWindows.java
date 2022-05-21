package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import java.util.Set;
public class Day07_NewWindows extends TestBase {
    //    Create a new Class Tests package: Day07_NewWindows
//    Method name:windowHandle
//    Given user is on the https://the-internet.herokuapp.com/windows
//    Then user verifies the text : “Opening a new window”
//    Then user verifies the title of the page is “The Internet”
//    When user clicks on the “Click Here” button
//    Then user verifies the new window title is “New Window”
//    Then user verifies the text:  “New Window”
//    When user goes back to the previous window and then verifies the title : “The Internet”
    @Test
    public void windowHandle() throws InterruptedException {
        //    Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
//        NOTE: Getting the window handle of the window
//        I need this, so I can switch back to this window
        String window1Handle = driver.getWindowHandle();
        System.out.println(window1Handle);
        //    Then user verifies the text : “Opening a new window”
        String window1Text = driver.findElement(By.xpath("//div[@class='example']//h3")).getText();
        Assert.assertEquals("Opening a new window",window1Text);
        //    Then user verifies the title of the page is “The Internet”
        Assert.assertEquals("The Internet", driver.getTitle());
        //    When user clicks on the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click();
        //    Then user verifies the new window title is “New Window”
//       String window2Title = driver.getTitle();
//       Assert.assertEquals("New Window", window2Title);
        //We should switch to 2nd window, We should know 2nd windowHandle
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);
        for(String eachHandle : allWindowHandles){
            if(!eachHandle.equals(window1Handle)){ //if eachHandle is NOT equal to window1Handle
                driver.switchTo().window(eachHandle);
                //Then it must equal to window 2 handle, Then switch to that window
                break;
            }
        }
        //Driver is on the 2nd window
        String window2Handele = driver.getWindowHandle();
        //    Then user verifies the new window title is “New Window”
        String window2Title =  driver.getTitle();
        Assert.assertEquals("New Window",window2Title);
        //    Then user verifies the text:  “New Window”
        String window2Text =  driver.findElement(By.xpath("//div[@class='example']//h3")).getText();
        Assert.assertEquals("New Window",window2Text);
        Thread.sleep(5000);
//    When user goes back to the previous window and then verifies the title : “The Internet”
//    now driver is still on the 2nd window
        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet",driver.getTitle());
        Thread.sleep(5000);
        driver.switchTo().window(window2Handele);
        Thread.sleep(5000);
        driver.switchTo().window(window1Handle);
        Thread.sleep(5000);
        driver.switchTo().window(window2Handele);

    }
}
