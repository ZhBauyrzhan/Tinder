package com.baurr.baldezh.controller;

import com.baurr.baldezh.model.Meme;
import com.baurr.baldezh.model.MemeReview;
import com.baurr.baldezh.service.AbstractService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MemeReviewController extends AbstractController<MemeReview> {
    private final AbstractService<MemeReview> service;
    private final ObjectMapper objectMapper;

    public MemeReviewController(AbstractService<MemeReview> service, ObjectMapper objectMapper) {
        super(service, objectMapper, MemeReview.class);
        this.service = service;
        this.objectMapper = objectMapper;
    }
}
