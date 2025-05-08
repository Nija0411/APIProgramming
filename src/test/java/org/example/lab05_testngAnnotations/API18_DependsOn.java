package org.example.lab05_testngAnnotations;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class API18_DependsOn {

    //Output
    //Token
    //Booking Id
    //Browser
    //TC1

    @BeforeTest
    public void getToken() {
        System.out.println("Token");
    }

    @BeforeTest(dependsOnMethods = "getToken")
    public void getBookingId() {
        System.out.println("Booking Id");
    }

    @Test(dependsOnMethods = "launchBrowser")
    public void runTC() {
        System.out.println("TC1");
    }

    @Test
    public void launchBrowser() {
        System.out.println("Browser");
    }


}
