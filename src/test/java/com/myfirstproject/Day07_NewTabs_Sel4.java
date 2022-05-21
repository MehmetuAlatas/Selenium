package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.WindowType;
public class Day07_NewTabs_Sel4 extends TestBase {
    @Test
    public void newTabs() throws InterruptedException {
//        replace WindowType.WINDOW ==>>> WindowType.TAB
//        We are able to open a new tab and do testing on that tab
        //        Open google on window 1
        driver.get("https://www.google.com");
        System.out.println("Google Title: " + driver.getTitle());
        String googleWindowHandle = driver.getWindowHandle();
        //        Open amazon on TAB 2
        driver.switchTo().newWindow(WindowType.TAB); //creates a new TAB and switches to that TAB
        driver.get("https://www.amazon.com");//opens amazon in the 2nd TAB
        System.out.println("Amazon Title: " + driver.getTitle());
        String amazonWindowHandle = driver.getWindowHandle();
        //        Open linkedin on TAB 3
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        System.out.println("LinkedIn Title: " + driver.getTitle());
        String linkedInWindowHandle = driver.getWindowHandle();
        //        Switch between TABS
        //        Switch to amazon
        Thread.sleep(5000);
        driver.switchTo().window(amazonWindowHandle);
        //        Switch to google
        Thread.sleep(5000);
        driver.switchTo().window(googleWindowHandle);
        //        Switch back to linkedin
        Thread.sleep(5000);
        driver.switchTo().window(linkedInWindowHandle);

        /*
         * With Selenium 4 we are able to create and switch between new windows or tabs
         *
         * driver.switchTo().newWindow(WindowType.WINDOW);
         * driver.switchTo().newWindow(WindowType.TAB);
         *
         * */

    }
}