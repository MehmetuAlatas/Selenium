package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day07_Cookies extends TestBase {
//        Class: Day07_Cookies
//        Method: handleCookies
//                -Go to amazon and automate the tasks:
//        1. Find the total number of cookies
//        2. Print all the cookies
//        3. Get the cookies by their name
//        4. Add new cookie
//        5. Delete cookie by name
//        6. Delete all the cookies


    @Test
    public void handleCookies(){
//                -Go to amazon and automate the tasks:
        driver.get("https://www.amazon.com");

//        1. Find the total number of cookies
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numberOfCookies = allCookies.size();
        System.out.println("Number of cookies: " + numberOfCookies);

//        2. Print all the cookies
        for (Cookie eachCookie : allCookies){
            System.out.println("Each Cookie: " + eachCookie);
            System.out.println("Each Cookie Name: " + eachCookie.getName());
            System.out.println("Each Cookie Value: " + eachCookie.getValue());
            System.out.println();
        }

//        3. Get the cookies by their name
//        sp-cdn="L5Z9:TR"; expires=Cmt, 20 May 2023 07:37:36 EET; path=/; domain=.amazon.com;secure;
        System.out.println(driver.manage().getCookieNamed("sp-cdn"));
//        sp-cdn="L5Z9:TR"; expires=Cmt, 20 May 2023 07:40:03 EET; path=/; domain=.amazon.com;secure;


//        4. Add new cookie
        Cookie myCookie = new Cookie("MyFavCookie","Chocolate");
        driver.manage().addCookie(myCookie);
        //Check if cookie number is increased
        Set<Cookie> updatedCookies = driver.manage().getCookies();
        System.out.println("Size after addition: " + updatedCookies.size()); // 9

//        5. Delete cookie by name
        driver.manage().deleteCookieNamed("session-id");//deletes the cookie whose name is session-id


//        6. Delete all the cookies
        driver.manage().deleteAllCookies();//deletes all the cookies from the browser
        Set<Cookie> cookieSetAfterDelete = driver.manage().getCookies();
        System.out.println("Number of cookies after deletion: " + cookieSetAfterDelete.size()); //0



    }
}