package com.secretdedmoroz.service;

import static java.util.Objects.isNull;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.secretdedmoroz.dao.UserDao;
import com.secretdedmoroz.model.User;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public User createNewUser(String name, String email) {
        User user = null;
        if (isNull(userDao.getUserByEmail(email))) {
            user = new User();
            user.setEmail(email);
            user.setName(name);
            userDao.createUser(user);
        }
        return user;
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }
}
