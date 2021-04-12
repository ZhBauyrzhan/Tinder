package com.baurr.baldezh.service;

import com.baurr.baldezh.Exception.MyException;
import com.baurr.baldezh.model.Meme;
import com.baurr.baldezh.model.User;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemeService extends AbstractService{
    Dao<Meme, Integer> dao;
    public MemeService(Dao<Meme, Integer> dao,  Dao<User, Integer> userDao){
        super(dao, userDao);
        this.dao = dao;
    }

    public List<Meme> findMeme(int pageNumber, int pageSize, int lastMemeNumber) {
        try {
            List<Meme> memes = dao.queryBuilder().query();
            List<Meme> returnedMemes=new ArrayList<Meme>();
            for(int i = lastMemeNumber; i < Math.min(lastMemeNumber+20, memes.size()); i++) {
                returnedMemes.add(memes.get(i));
            }
            return returnedMemes;
        } catch (SQLException e) {
            throw new MyException(e.getMessage());
        }
    }
}
