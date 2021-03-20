package com.baurr.baldezh;

import com.baurr.baldezh.Configuration.DataBaseConfiguration;
import com.baurr.baldezh.Configuration.JdbcConfiguration;
import com.baurr.baldezh.model.Meme;
import com.baurr.baldezh.model.MemeReview;
import com.baurr.baldezh.model.User;
import com.baurr.baldezh.model.UserIntermation;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataBaseConfiguration configuration = new JdbcConfiguration("jdbc:sqlite:base.db");
        Dao<User, Integer> userDao = DaoManager.createDao(configuration.connectionSource(), User.class);
        Dao<Meme, Integer> memeDao = DaoManager.createDao(configuration.connectionSource(), Meme.class);
        Dao<MemeReview, Integer> memeReviewDao = DaoManager.createDao(configuration.connectionSource(), MemeReview.class);
        Dao<UserIntermation, Integer> userIntermationsDao = DaoManager.createDao(configuration.connectionSource(), UserIntermation.class);

    }
}
