package com.amigoscode.cli_project.user;

import java.util.UUID;

public class UserDao {
    private static final User[] users;
    public static int maxUsers = 10;
    private int currIndex = 2;

    static {
        users = new User[maxUsers];
        users[0] = new User("John", "Wick");
        users[1] = new User("Adam", "Smith");
    }

    public void saveUser(User user) {
        users[currIndex] = user;
        currIndex++;
    }

    public User[] getAll() {
        return users;
    }

    public User getUser(UUID id) {
        for(User user : users) {
            if(user.getId().compareTo(id) == 0) {
                return user;
            }
        }
        return null;
    }

    public void updateUser(User user) {
        for (int i = 0; i < users.length; i++) {
            var u = users[i];
            if(u.getId().compareTo(user.getId()) == 0) {
                users[i] = user;
                break;
            }
        }
    }
}
