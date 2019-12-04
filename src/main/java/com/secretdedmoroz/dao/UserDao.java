package com.secretdedmoroz.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.secretdedmoroz.model.User;

@Repository
public class UserDao {

    private static List<User> users = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(final List<User> users) {
        UserDao.users = users;
    }

    public User getUserByEmail(String email) {
        return users.stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
    }

    public boolean createUser(User user) {
        return users.add(user);
    }
}
