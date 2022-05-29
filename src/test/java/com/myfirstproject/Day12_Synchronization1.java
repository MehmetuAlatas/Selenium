package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Day12_Synchronization1 extends TestBase {
    @Test
    public void synchronization1() throws InterruptedException {
//        Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        When user clicks on the Start button
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
//        Using explicit wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        //div[@id='finish']//h4 is the xpath of the Hello World! element
//        1. Waits for teh element DYNAMICALLY
//        2. returns the element. So no need to use findElement with explicit wait
        WebElement helloWord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        Assert.assertEquals("Hello World!",helloWord.getText());
//        Thread.sleep(5000);//works but this is not recommended
//        Then verify the ‘Hello World!’ Shows up on the screen
//        String helloWorld = driver.findElement(By.xpath("//div[@id='finish']//h4")).getText();
//        Assert.assertEquals("Hello World!",helloWorld);
//        Implicit wait is not enough to handle the load issue

        /**
         * 1. What are the selenium waits?
         * Implicit wait
         * Explicit wait
         * Fluent wait
         * 2. Which one do you prefer? Why?
         * It depends on the test case. I already use implicit wait in my driver class.  But explicit wait works better. So I prefer explicit wait in some cases. For example, when I work with dynamically loaded elements, then explicit wait works better for waiting and locating the elements.
         * 3. What might be the reason of test case failure?
         * Wrong locator-typo, wrong values,…
         * Not synchronized. Timing issue.
         * Page is too slow, internet is slow, database is slow, hosting problem,…
         * Element may not be visible
         * Iframe
         * Multiple window
         * Alert, pop ups, cookies
         * Captcha code
         * 4. What do you do when your test case fails?
         * Read error message on the console. I see the error message and the line of the error. Then I can read which part of the code is fails. Error message gives me which class, which line, what error, …
         * Check the locators, time issue, element visibility, iframe, pop ups, …
         * Manual testing again to see my automation logic is correct. To also check the functional is working
         * 5. Can you use implicit wait and explicit wait together?
         * Yes. Implicit wait is in driver class. When implicit doesn’t work, then I can use explicit wait. I have reusable methods for explicit waits
         * 6. What is the difference between implicit and explicit wait?
         * Implicit is global(applies wait to the driver whenever driver is used), explicit is local(I have to call explicit wait every time for new element)
         * Explicit wait works with expected condition. We have to create WebDriverWait object. Has more option such as visibility, clickibility, text be
         */
    }
}
