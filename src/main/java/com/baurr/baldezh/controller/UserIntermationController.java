package com.baurr.baldezh.controller;

import com.baurr.baldezh.model.Meme;
import com.baurr.baldezh.model.UserIntermation;
import com.baurr.baldezh.service.AbstractService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserIntermationController extends AbstractController<UserIntermation> {
    private final AbstractService<UserIntermation> service;
    private final ObjectMapper objectMapper;

    public UserIntermationController(AbstractService<UserIntermation> service, ObjectMapper objectMapper) {
        super(service, objectMapper, UserIntermation.class);
        this.service = service;
        this.objectMapper = objectMapper;
    }
}
