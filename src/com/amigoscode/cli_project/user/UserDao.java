package com.amigoscode.cli_project.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    List<User> users = new ArrayList<>();
    default void saveUser(User user) {
        users.add(user);
    }
    default User[] getAll() {
        return users.toArray(new User[0]);
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
        for (int i = 0; i < users.size(); i++) {
            var u = users.get(i);
            if(u.getId().compareTo(user.getId()) == 0) {
                users.set(i, user);
                break;
            }
        }
    }
}
