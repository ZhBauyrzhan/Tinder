package com.baurr.baldezh.controller;

import com.baurr.baldezh.model.MemeReview;
import com.baurr.baldezh.model.User;
import com.baurr.baldezh.service.AbstractService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;

import java.util.List;

public class MemeReviewController extends AbstractController<MemeReview> {
    private final AbstractService<MemeReview> service;
    private final ObjectMapper objectMapper;

    public MemeReviewController(AbstractService<MemeReview> service, ObjectMapper objectMapper) {
        super(service, objectMapper, MemeReview.class);
        this.service = service;
        this.objectMapper = objectMapper;
    }
}
