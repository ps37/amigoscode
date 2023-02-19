package com.amigoscode.cli_project.booking;

import java.util.UUID;

public class BookingService {
    private static final BookingDao dao = new BookingDao();

    public void save(Booking val) {
        dao.save(val);
    }

    public Booking[] getAll() {
        return dao.getAll();
    }

    public Booking get(UUID val) {
        return dao.get(val);
    }
}
