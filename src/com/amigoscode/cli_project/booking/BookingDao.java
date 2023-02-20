package com.amigoscode.cli_project.booking;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookingDao {
    private static final List<Booking> db;
    static {
         db = new ArrayList<>();
    }
    public void save(Booking val) {
        db.add(val);
    }

    public Booking[] getAll() {
        return db.toArray(new Booking[0]);
    }

    public Booking get(UUID val) {
        for (Booking b : db) {
            if(b.getId().compareTo(val) == 0) {
                return b;
            }
        }
        return null;
    }
}
