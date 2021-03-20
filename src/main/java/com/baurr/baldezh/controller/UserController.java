package com.baurr.baldezh.controller;

import com.baurr.baldezh.model.User;
import com.baurr.baldezh.service.AbstractService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserController extends AbstractController<User>{
    private final AbstractService<User> service;
    private final ObjectMapper objectMapper;

    public UserController(AbstractService<User> service, ObjectMapper objectMapper) {
        super(service, objectMapper, User.class);
        this.service = service;
        this.objectMapper = objectMapper;
    }

}
