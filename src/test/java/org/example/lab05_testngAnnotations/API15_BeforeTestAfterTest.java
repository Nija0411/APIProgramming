package org.example.lab05_testngAnnotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class API15_BeforeTestAfterTest {

    //In Order to Update booking we should first generate:
    // token & bookingId - so mark these with @BeforeTest
    // Once the test is done we need to close
    // closeBooking() - so mark this with @AfterTest

    //Output
    // BookingId Provided -- Bcz TestNG follows aplhbetic order that's why method bookingid first
    // Token Generated
    // Booing Updated
    // Booking Closed

    @BeforeTest
    public void getToken() {
        System.out.println("Token Generated");
    }

    @BeforeTest
    public void getBookingId() {
        System.out.println("BookingId Provided");
    }

    @Test
    public void updateBooking() {
        System.out.println("Booing Updated");
    }

    @AfterTest
    public void closeBooking() {
        System.out.println("Booking Closed");
    }
}
