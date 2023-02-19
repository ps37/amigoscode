package com.amigoscode.cli_project.booking;

import java.util.UUID;

import com.amigoscode.cli_project.car.Car;
import com.amigoscode.cli_project.user.UserService;
import com.amigoscode.cli_project.utils.MyUuid;

public class Booking {
    private static final UserService userService;
    private static final BookingService bookingService;

    private UUID id;
    private UUID userId;
    private Car car;

    static {
        userService = new UserService();
        bookingService = new BookingService();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", userId=" + userId +
                ", car=" + car +
                '}';
    }

    public Booking(UUID userId, Car car) {
        this.id = MyUuid.generate();
        this.userId = userId;
        this.car = car;
        // Save booking in DB
        bookingService.save(this);
        // Send the bookingId to user for updating user
        userService.addBooking(userId, this.id);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
