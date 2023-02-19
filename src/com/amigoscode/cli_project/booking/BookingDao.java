package com.amigoscode.cli_project.booking;

import java.util.UUID;

public class BookingDao {
    private static final Booking[] db;
    static {
         db = new Booking[10];
    }
    private int currIndex = 0;
    public void save(Booking val) {
        db[currIndex] = val;
        currIndex++;
    }

    public Booking[] getAll() {
        return db;
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
