package com.amigoscode.cli_project.booking;

import java.util.UUID;

import com.amigoscode.cli_project.user.UserService;

public class BookingService {
    private final BookingDao dao;
    private final UserService userService;

    public BookingService(BookingDao dao, UserService userService) {
        this.dao = dao;
        this.userService = userService;
    }

    public void save(Booking val) {
        dao.save(val);
        this.userService.addBooking(val.getUserId(), val.getId());
    }

    public Booking[] getAll() {
        return dao.getAll();
    }

    public Booking get(UUID val) {
        return dao.get(val);
    }
}
