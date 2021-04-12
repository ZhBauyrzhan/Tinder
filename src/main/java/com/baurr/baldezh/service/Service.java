package com.baurr.baldezh.service;


import com.baurr.baldezh.Exception.MyException;
import com.baurr.baldezh.model.Model;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

public interface Service<T extends Model> {
    Dao<T,Integer> dao();
    default List<T> findAll(int pageNumber, int pageSize) {
        try {
            try {
                QueryBuilder queryBuilder = dao().queryBuilder().offset((long) pageNumber * pageSize).limit((long) pageSize);
                return queryBuilder.query();
            } catch (SQLException e) {
                throw new MyException(e.getMessage());
            }
        } catch (Exception e) {
            throw new MyException(e.getMessage());
        }
    }

    default T findById(int id) {
        try {
            return dao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MyException("SQL ex", e);
        }
    }

    default void save(T model) {
        try {
            dao().create(model);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MyException("SQL ex", e);
        }
    }

    default void update(T model) {
        try {
            dao().update(model);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MyException("SQL ex", e);
        }
    }

    default void delete (T model) {
        try {
            dao().delete(model);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MyException("SQL ex", e);
        }
    }
}