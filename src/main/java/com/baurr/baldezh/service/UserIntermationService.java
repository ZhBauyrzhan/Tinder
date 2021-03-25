package com.baurr.baldezh.service;

import com.baurr.baldezh.model.User;
import com.baurr.baldezh.model.UserIntermation;
import com.j256.ormlite.dao.Dao;

public class UserIntermationService extends AbstractService<UserIntermation>{
    public UserIntermationService(Dao<UserIntermation, Integer> dao, Dao<User, Integer> userDao){
        super(dao, userDao);
    }
}
