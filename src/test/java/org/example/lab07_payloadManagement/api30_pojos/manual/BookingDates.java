package org.example.lab07_payloadManagement.api30_pojos.manual;

public class BookingDates {
    private String checkin = "2018-01-01";
    private String checkout = "2019-01-01";

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
