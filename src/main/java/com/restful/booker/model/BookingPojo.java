package com.restful.booker.model;

import java.util.Date;

public class BookingPojo {
    private String firstName;
    private String lastName;
    private int totalPrice;
    private boolean depositPaid;
  //  private HashMap<Object, Object> bookingdates;
  private Date bookingdates;
    private String checkIn;
    private String checkOut;

    private String additionalneeds;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isDepositPaid() {
        return depositPaid;
    }

    public void setDepositPaid(boolean depositPaid) {
        this.depositPaid = depositPaid;
    }

   /* public HashMap<Object, Object> getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(HashMap<Object, Object> bookingdates) {
        this.bookingdates = bookingdates;
    }*/
   public Date getBookingdates() {
       return bookingdates;
   }

    public void setBookingdates(Date bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}
