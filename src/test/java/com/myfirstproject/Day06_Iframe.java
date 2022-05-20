package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day06_Iframe extends TestBase {
    //    Create a class: IFrameTest
//    Create a method: iframeTest
//    Go to https://the-internet.herokuapp.com/iframe
//    Verify the Bolded text contains "Editor"
//    Locate the text box
//    Delete the text in the text box
//    Type "This text box is inside the iframe"
//    Verify the text Elemental Selenium text is displayed on the page
    @Test
    public void iframeTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");
      String boldedText =  driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(boldedText.contains("Editor"));
    }
}
