package com.baurr.baldezh.controller;

import com.baurr.baldezh.model.Meme;
import com.baurr.baldezh.model.User;
import com.baurr.baldezh.service.AbstractService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDateTime;
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
    public Boolean checkRights(Context context) {
        String senderLogin = context.basicAuthCredentials().getUsername();
        User user = service.findUserByLogin(senderLogin);
        String senderPassword = context.basicAuthCredentials().getPassword();
        LocalDateTime localDateTime = LocalDateTime.now();
        return ( (BCrypt.checkpw(senderPassword, user.getPassword()) || user.getStatus().equals(User.ADMIN))
                && (user.getMemeRequestTime().plusDays(User.NEED_DAYS).plusHours(User.NEED_HOURS).plusMinutes(User.NEED_MINUTES).plusSeconds(User.NEED_SECONDS).isAfter(localDateTime)) );
    }

    @Override
    public void getAll(Context context, int pageNumber, int pageSize) {
        try {
            if(super.checkRights(context)) {
                List<Meme> returnedModels = service.findAll(pageNumber, pageSize);
                context.result(objectMapper.writeValueAsString(returnedModels));
            }
        } catch (Exception e) {
            e.printStackTrace();
            context.status(500);
        }
    }
}
