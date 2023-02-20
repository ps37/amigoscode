package com.amigoscode.cli_project.user;

public class UserArrayDataAccessService implements UserDao {

    static {
        users.add(new User("John", "Wick"));
        users.add(new User("Adam", "Smith"));
    }
}
