package org.example.lab07_payloadManagement.api30_pojos.manual;

public class Booking {

    //Json Request
//     "booking": {
//        "firstname": "Jim",
//                "lastname": "Brown",
//                "totalprice": 111,
//                "depositpaid": true,
//                "bookingdates": {
//            "checkin": "2018-01-01",
//                    "checkout": "2019-01-01"
//        },
//        "additionalneeds": "Breakfast"
//    }

    //Convert them to POJO's
    private String firstname = "Jim";
    private String lastname = "Brown";
    private int totalprice = 111;
    private boolean depositpaid = true;
    private BookingDates bookingDates;
    private String additionalneeds = "Breakfast";

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public BookingDates getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(BookingDates bookingDates) {
        this.bookingDates = bookingDates;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
}
