package com.baurr.baldezh.controller;


import com.baurr.baldezh.model.Model;
import com.baurr.baldezh.model.User;
import com.baurr.baldezh.service.AbstractService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public abstract class AbstractController<T extends Model> implements Controller<T> {
    private final AbstractService<T> service;
    private final ObjectMapper objectMapper;
    private final Class<T> clazz;

    public AbstractController(AbstractService<T> service, ObjectMapper objectMapper, Class<T> clazz) {
        this.service = service;
        this.objectMapper = objectMapper;
        this.clazz = clazz;
    }
    public void bigPost(Context context) {
        try {
            List<T> objects = objectMapper.readValue(context.body(), new TypeReference<List<T>>(){});
            for(int i = 0; i < objects.size(); i++) {
                service.save(objects.get(i));
                T saved = service.findById(objects.get(i).getId());
                context.result(objectMapper.writeValueAsString(saved));
            }
            context.status(201);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            context.status(400);
        }
    }
    @Override
    public Boolean checkRights(Context context) {
        String senderPassword = context.basicAuthCredentials().getPassword();
        String senderLogin = context.basicAuthCredentials().getUsername();
        User user = service.findUserByLogin(senderLogin);
        return ((BCrypt.checkpw(senderPassword, user.getPassword()))
                || user.getStatus().equals(User.ADMIN));
    }

    @Override
    public void getAll(Context context, int pageNumber, int pageSize) {
        try {
            if(checkRights(context)) {
                List<T> returnedModels = service.findAll(pageNumber, pageSize);
                context.result(objectMapper.writeValueAsString(returnedModels));
            }
        } catch (Exception e) {
            e.printStackTrace();
            context.status(500);
        }
    }

    @Override
    public void getOne(Context context, int id) {
        T model = service.findById(id);
        if (model == null) {
            context.status(404);
        } else {
            try {
                if(checkRights(context))
                    context.result(objectMapper.writeValueAsString(model));
                else
                    context.status(404);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                context.status(500);
            }
        }
    }
    @Override
    public void post(Context context) {
        try {
            T model = objectMapper.readValue(context.body(), clazz);
            service.save(model);
            T saved = service.findById(model.getId());
            context.result(objectMapper.writeValueAsString(saved));
            context.status(201);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            context.status(400);
        }
    }

    @Override
    public void patch(Context context, int id) {
        try {
            T model = objectMapper.readValue(context.body(), clazz);
            if(checkRights(context)){
                model.setId(id);
                service.update(model);
                context.status(200);
            } else
                context.status(404);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            context.status(400);
        }
    }

    @Override
    public void delete(Context context, int id) {
        T model = service.findById(id);
        if(checkRights(context)) {
            service.delete(model);
            context.status(204);
        } else
            context.status(404);
    }

}