package com.baurr.baldezh.controller;


import com.baurr.baldezh.model.Model;
import io.javalin.http.Context;

public interface Controller<T extends Model>{
    void getAll(Context context, int pageNumber, int pageSize);
    void getOne(Context context, int id);
    void post(Context context);
    void patch(Context context, int id);
    void delete(Context context, int id);
    void bigPost(Context context);
    Boolean checkRights(Context context);
}