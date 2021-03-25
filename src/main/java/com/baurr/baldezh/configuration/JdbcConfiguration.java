package com.baurr.baldezh.configuration;

import com.baurr.baldezh.Exception.MyException;
import com.baurr.baldezh.model.Meme;
import com.baurr.baldezh.model.MemeReview;
import com.baurr.baldezh.model.User;
import com.baurr.baldezh.model.UserIntermation;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class JdbcConfiguration implements DataBaseConfiguration {
    private final ConnectionSource connectionSource;
    public JdbcConfiguration(String jdbConnectionSource) {
        try {
            connectionSource = new JdbcConnectionSource(jdbConnectionSource);
            TableUtils.createTableIfNotExists(connectionSource, User.class);
            TableUtils.createTableIfNotExists(connectionSource, Meme.class);
            TableUtils.createTableIfNotExists(connectionSource, MemeReview.class);
            TableUtils.createTableIfNotExists(connectionSource, UserIntermation.class);
        } catch(SQLException e){
            e.printStackTrace();
            throw new MyException("Can't initialize database connection",  e);
        }
    }
    @Override
    public ConnectionSource connectionSource() {
        return connectionSource;
    }
}
