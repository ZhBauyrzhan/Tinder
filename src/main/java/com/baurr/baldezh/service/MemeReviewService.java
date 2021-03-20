package com.baurr.baldezh.service;

import com.baurr.baldezh.model.MemeReview;
import com.baurr.baldezh.model.User;
import com.j256.ormlite.dao.Dao;

public class MemeReviewService extends AbstractService<MemeReview>{
    public MemeReviewService(Dao<MemeReview, Integer> dao, Dao<User, Integer> userDao){
        super(dao, userDao);
    }
}