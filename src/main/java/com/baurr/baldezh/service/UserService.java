package com.baurr.baldezh.service;

import com.baurr.baldezh.model.User;
import com.j256.ormlite.dao.Dao;
public class UserService extends AbstractService<User>{
    Dao<User, Integer> userDao;
    public UserService(Dao<User, Integer> userDao) {
        super(userDao, userDao);
    }
}
