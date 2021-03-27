package com.baurr.baldezh.controller;

import com.baurr.baldezh.model.Meme;
import com.baurr.baldezh.service.AbstractService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;

import java.util.List;

public class MemeController extends AbstractController<Meme>{
    private final AbstractService<Meme> service;
    private final ObjectMapper objectMapper;

    public MemeController(AbstractService<Meme> service, ObjectMapper objectMapper) {
        super(service, objectMapper, Meme.class);
        this.service = service;
        this.objectMapper = objectMapper;
    }
    @Override
    public void post(Context context) {
        try {
            List<Meme> memes = objectMapper.readValue(context.body(), new TypeReference<List<Meme>>() {});
            for(int i = 0; i < memes.size(); i++) {
                service.save(memes.get(i));
                Meme saved = service.findById(memes.get(i).getId());
                context.result(objectMapper.writeValueAsString(saved));
            }
            context.status(201);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            context.status(400);
        }
    }
}
