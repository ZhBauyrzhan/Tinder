package com.baurr.baldezh.controller;

import com.baurr.baldezh.model.Meme;
import com.baurr.baldezh.service.AbstractService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MemeController extends AbstractController<Meme>{
    private final AbstractService<Meme> service;
    private final ObjectMapper objectMapper;

    public MemeController(AbstractService<Meme> service, ObjectMapper objectMapper) {
        super(service, objectMapper, Meme.class);
        this.service = service;
        this.objectMapper = objectMapper;
    }
}
