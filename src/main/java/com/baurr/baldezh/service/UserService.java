package com.baurr.baldezh.service;

import com.baurr.baldezh.model.User;
import com.j256.ormlite.dao.Dao;

public class UserService extends AbstractService<User>{
    public UserService(Dao<User, Integer> userDao) {
        super(userDao, userDao);
    }
}
