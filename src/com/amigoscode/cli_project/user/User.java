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
    private final UUID[] bookings = new UUID[maxBookings];
    public static int maxBookings = 10;

    public int getCurrBookIndex() {
        return currBookIndex;
    }

    private int currBookIndex = 0;

    public UUID[] getBookings() {
        return this.bookings;
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

    public User(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName) {
        this.id = MyUuid.generate();
        this.firstName = firstName;
        this.lastName = lastName;
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
