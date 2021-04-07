package com.baurr.baldezh.service;

import com.baurr.baldezh.Exception.MyException;
import com.baurr.baldezh.model.User;
import com.baurr.baldezh.model.UserIntermation;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

public class UserService extends AbstractService<User>{
    Dao<User, Integer> userDao;
    public UserService(Dao<User, Integer> userDao) {
        super(userDao, userDao);
    }
    public List<User> findUser(int pageNumber, int pageSize, String sex) {
        try {
            List<User> users = userDao.queryBuilder()
                    .where()
                    .eq(User.FIELD_SEX, (sex.equals(User.FEMALE) ? User.MALE : User.FEMALE )).query();
            QueryBuilder queryBuilder = dao().queryBuilder().offset((long) pageNumber * pageSize).limit((long) pageSize);
            return queryBuilder.query();
        } catch (SQLException e) {
            throw new MyException(e.getMessage());
        }
    }
}
