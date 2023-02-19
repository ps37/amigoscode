package com.amigoscode.cli_project.user;

import java.util.Arrays;

public class UserArrayDataAccessService implements UserDao {
    private static int nextAvailableIndex;

    static {
        users[0] = new User("John", "Wick");
        users[1] = new User("Adam", "Smith");
        nextAvailableIndex = 2;
    }

    public void saveUser(User user) {
        users[nextAvailableIndex] = user;
        nextAvailableIndex++;
    }
}
