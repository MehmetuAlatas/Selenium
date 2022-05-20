package com.myfirstproject.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public abstract class TestBase {
    /*
    What is TestBase?
    TestBase is a class that has repeated pre-conditions and post conditions
    We have @Before and @After methods inside this class.
    TestBase should be an abstract class.
    We just want to implement the methods in the TestBase.
    We do not want to create objects from TestBase class.

    Interview Question => Where do you use abstraction from Java while testing with Selenium?
    * */
    protected WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
