package com.tensquare.user.service;

import com.tensquare.user.dao.UserDao;
import com.tensquare.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @Author : eden 2020-10-07 15:54
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User login(User user) {
        return userDao.selectOne(user);
    }

    public User selectById(String userId) {
        return userDao.selectById(userId);
    }
}
