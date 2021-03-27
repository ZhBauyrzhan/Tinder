package com.baurr.baldezh.controller;

import com.baurr.baldezh.model.User;
import com.baurr.baldezh.service.AbstractService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;

import java.util.List;

public class UserController extends AbstractController<User>{
    private final AbstractService<User> service;
    private final ObjectMapper objectMapper;

    public UserController(AbstractService<User> service, ObjectMapper objectMapper) {
        super(service, objectMapper, User.class);
        this.service = service;
        this.objectMapper = objectMapper;
    }
    @Override
    public void post(Context context) {
        try {
            List<User> users = objectMapper.readValue(context.body(), new TypeReference<List<User>>(){});
            for(int i = 0; i < users.size(); i++) {
                service.save(users.get(i));
                User saved = service.findById(users.get(i).getId());
                context.result(objectMapper.writeValueAsString(saved));
            }
            context.status(201);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            context.status(400);
        }
    }

}
