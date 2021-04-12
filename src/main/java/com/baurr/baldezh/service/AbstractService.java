package com.baurr.baldezh.service;
import com.baurr.baldezh.Exception.MyException;
import com.baurr.baldezh.model.Meme;
import com.baurr.baldezh.model.Model;
import com.baurr.baldezh.model.User;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractService<T extends Model> implements Service<T>{
    private final Dao<T, Integer> dao;
    private final Dao<User, Integer>userDao;
    public AbstractService(Dao<T, Integer> dao, Dao<User, Integer> userDao) {
        this.dao = dao;
        this.userDao = userDao;
    }
    public User findUserByLogin(String login) throws RuntimeException{
        try {
            List<User> users = userDao.queryForAll();
            for(int i = 0; i < users.size(); i++) {
                if(users.get(i).getLogin().equals(login)) {
                    return users.get(i);
                }
            }
            throw new RuntimeException("Нет такого юзера");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MyException("SQL ex", e);
        }
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
    @Override
    public Dao<T, Integer> dao() {
        return dao;
    }
}
