package com.amigoscode.cli_project.user;

import java.util.Arrays;
import java.util.UUID;

import com.amigoscode.cli_project.booking.BookingService;
import com.amigoscode.cli_project.utils.MyUuid;
import com.amigoscode.cli_project.booking.Booking;

public class User {
    private final UUID id;
    private String firstName;
    private String lastName;
    private final UUID[] bookings;
    public static int maxBookings = 10;
    private int currBookIndex = 0;

    public Booking[] getBookings() {
        var books = new Booking[currBookIndex];
        var bs = new BookingService();
        var currIndex = 0;
        for(UUID id : bookings) {
            if(id == null) {
                continue;
            }
            books[currIndex] = bs.get(id);
            currIndex++;
        }
        return books;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bookings=" + Arrays.toString(bookings) +
                ", currBookIndex=" + currBookIndex +
                '}';
    }

    public void addBooking(UUID booking) {
        this.bookings[this.currBookIndex] = booking;
        this.currBookIndex++;
        System.out.println(this);
    }

    public User(String firstName, String lastName) {
        this.id = MyUuid.generate();
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookings = new UUID[maxBookings];
    }

    public UUID getId() {
        return id;
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
}
