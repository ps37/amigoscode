package com.amigoscode.cli_project.user;

import java.util.UUID;

public class UserService {
    private final UserDao dao = new UserFileDataAccessService();

    public void addUser(String firstName, String lastName) {
        dao.saveUser(new User(firstName, lastName));
    }

    public User[] getAll() {
        return dao.getAll();
    }

    public User getUser(UUID userId) {
        return dao.getUser(userId);
    }

    public void addBooking(UUID userId, UUID bookingId) {
        var user = this.getUser(userId);
        user.addBooking(bookingId);
        dao.updateUser(user);
    }
}
