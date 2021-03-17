package com.baurr.baldezh.Configuration;

import com.baurr.baldezh.Exception.MyException;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class JdbcConfiguration implements DataBaseConfiguration {
    private final ConnectionSource connectionSource;
    public JdbcConfiguration(String jdbConnectionSource) {
        try {
            connectionSource = new JdbcConnectionSource(jdbConnectionSource);
//            TableUtils.createTableIfNotExists(connectionSource, User.class);
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
