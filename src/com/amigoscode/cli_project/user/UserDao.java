package com.amigoscode.cli_project.user;

import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    int maxUsers = 10;
    User[] users = new User[maxUsers];
    void saveUser(User user);
    default User[] getAll() {
        return users;
    }
    default User getUser(UUID id) throws RuntimeException {
        for(User user : users) {
            Optional<User> optionalUser = Optional.ofNullable(user);
            if(optionalUser.isPresent() && user.getId().compareTo(id) == 0)
                return user;
        }
        throw new RuntimeException("User with the given ID doesn't exist!");
    }
    default void updateUser(User user) {
        for (int i = 0; i < users.length; i++) {
            var u = users[i];
            if(u.getId().compareTo(user.getId()) == 0) {
                users[i] = user;
                break;
            }
        }
    }
}
