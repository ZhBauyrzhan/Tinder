package com.baurr.baldezh.controller;

import com.baurr.baldezh.model.Meme;
import com.baurr.baldezh.model.User;
import com.baurr.baldezh.model.UserIntermation;
import com.baurr.baldezh.service.AbstractService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDateTime;
import java.util.List;

public class UserIntermationController extends AbstractController<UserIntermation> {
    private final AbstractService<UserIntermation> service;
    private final ObjectMapper objectMapper;

    public UserIntermationController(AbstractService<UserIntermation> service, ObjectMapper objectMapper) {
        super(service, objectMapper, UserIntermation.class);
        this.service = service;
        this.objectMapper = objectMapper;
    }
}
