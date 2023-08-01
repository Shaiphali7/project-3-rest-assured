package com.restful.booker.model;

public class RestPojo {
    private String firstname;
    private String lastname;
    private String totalprice;
    private String depositpaid;
    private String additionalneeds;

    private BookingDates bookingdates;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public String getDepositpaid() {
        return depositpaid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public void setDepositpaid(String depositpaid) {
        this.depositpaid = depositpaid;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }
}


