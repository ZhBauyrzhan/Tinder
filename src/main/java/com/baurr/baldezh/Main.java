package com.baurr.baldezh;

import com.baurr.baldezh.configuration.DataBaseConfiguration;
import com.baurr.baldezh.configuration.JdbcConfiguration;
import com.baurr.baldezh.controller.*;
import com.baurr.baldezh.json.deserializer.*;
import com.baurr.baldezh.json.serializer.*;
import com.baurr.baldezh.model.Meme;
import com.baurr.baldezh.model.MemeReview;
import com.baurr.baldezh.model.User;
import com.baurr.baldezh.model.UserIntermation;
import com.baurr.baldezh.service.MemeReviewService;
import com.baurr.baldezh.service.MemeService;
import com.baurr.baldezh.service.UserIntermationService;
import com.baurr.baldezh.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import io.javalin.Javalin;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataBaseConfiguration configuration = new JdbcConfiguration("jdbc:sqlite:base.db");
        Dao<User, Integer> userDao = DaoManager.createDao(configuration.connectionSource(), User.class);
        Dao<Meme, Integer> memeDao = DaoManager.createDao(configuration.connectionSource(), Meme.class);
        Dao<MemeReview, Integer> memeReviewDao = DaoManager.createDao(configuration.connectionSource(), MemeReview.class);
        Dao<UserIntermation, Integer> userIntermationsDao = DaoManager.createDao(configuration.connectionSource(), UserIntermation.class);

        UserService userService = new UserService(userDao);
        UserIntermationService userIntermationService = new UserIntermationService(userIntermationsDao, userDao);
        MemeService memeService = new MemeService(memeDao, userDao);
        MemeReviewService memeReviewService = new MemeReviewService(memeReviewDao, userDao);

        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.prefer405over404 = true;
            javalinConfig.enableCorsForAllOrigins();
            javalinConfig.enableDevLogging();
        });

        SimpleModule simpleModule = new SimpleModule()
                .addSerializer(LocalDate.class, new LocalDateSerializer()).addDeserializer(LocalDate.class, new LocalDateDeserializer())
                .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer()).addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer())
                .addSerializer(MemeReview.class, new MemeReviewSerializer()).addDeserializer(MemeReview.class, new MemeReviewDeserializer(userService,memeService))
                .addSerializer(Meme.class, new MemeSerializer()).addDeserializer(Meme.class, new MemeDeserializer())
                .addSerializer(UserIntermation.class, new UserIntermationSerializer()).addDeserializer(UserIntermation.class, new UserIntermationDeserializer(userService))
                .addSerializer(User.class, new UserSerializer()).addDeserializer(User.class, new UserDeserializer());
        ObjectMapper objectMapper = new ObjectMapper().registerModule(simpleModule);

        UserController userController = new UserController(userService, objectMapper);
        MemeController memeController = new MemeController(memeService, objectMapper);
        MemeReviewController memeReviewController = new MemeReviewController(memeReviewService, objectMapper);
        UserIntermationController userIntermationController = new UserIntermationController(userIntermationService, objectMapper);
        app.routes( () -> {
            path("users", () -> {
                get(ctx -> userController.getAll(ctx,
                        (ctx.queryParam("page", Integer.class).getOrNull() != null ? ctx.queryParam("page", Integer.class).get()-1 : 0),
                        (ctx.queryParam("size", Integer.class).getOrNull() != null ? ctx.queryParam("size", Integer.class).get() : 5 )));
                post(userController::bigPost);
                path(":id", () -> {
                    get(ctx -> userController.getOne(ctx, ctx.pathParam("id", Integer.class).get()));
                    post(userController::post);
                    patch(ctx -> userController.patch(ctx, ctx.pathParam("id", Integer.class).get()));
                    delete(ctx -> userController.delete(ctx, ctx.pathParam("id", Integer.class).get()));
                });
            });
            path("memes", () -> {
                get(ctx -> memeController.getAll(ctx,
                        (ctx.queryParam("page", Integer.class).getOrNull() != null ? ctx.queryParam("page", Integer.class).get()-1 : 0),
                        (ctx.queryParam("size", Integer.class).getOrNull() != null ? ctx.queryParam("size", Integer.class).get() : 5 )));
                post(memeController::bigPost);
                path(":id", () -> {
                    get(ctx -> memeController.getOne(ctx, ctx.pathParam("id", Integer.class).get()));
                    post(memeController::post);
                    patch(ctx -> memeController.patch(ctx, ctx.pathParam("id", Integer.class).get()));
                    delete(ctx -> memeController.delete(ctx, ctx.pathParam("id", Integer.class).get()));
                });
            });
            path("memeReview", () -> {
                get(ctx -> memeReviewController.getAll(ctx,
                        (ctx.queryParam("page", Integer.class).getOrNull() != null ? ctx.queryParam("page", Integer.class).get()-1 : 0),
                        (ctx.queryParam("size", Integer.class).getOrNull() != null ? ctx.queryParam("size", Integer.class).get() : 5 )));
                post(memeReviewController::bigPost);
                path(":id", () -> {
                    get(ctx -> memeReviewController.getOne(ctx, ctx.pathParam("id", Integer.class).get()));
                    post(memeReviewController::post);
                    patch(ctx -> memeReviewController.patch(ctx, ctx.pathParam("id", Integer.class).get()));
                    delete(ctx -> memeReviewController.delete(ctx, ctx.pathParam("id", Integer.class).get()));
                });
            });
            path("userIntermation", () -> {
                get(ctx -> userIntermationController.getAll(ctx,
                        (ctx.queryParam("page", Integer.class).getOrNull() != null ? ctx.queryParam("page", Integer.class).get()-1 : 0),
                        (ctx.queryParam("size", Integer.class).getOrNull() != null ? ctx.queryParam("size", Integer.class).get() : 5 )));
                post(userIntermationController::bigPost);
                path(":id", () -> {
                    get(ctx -> userIntermationController.getOne(ctx, ctx.pathParam("id", Integer.class).get()));
                    post(userIntermationController::post);
                    patch(ctx -> userIntermationController.patch(ctx, ctx.pathParam("id", Integer.class).get()));
                    delete(ctx -> userIntermationController.delete(ctx, ctx.pathParam("id", Integer.class).get()));
                });
            });
        });
        app.start(7777);
    }
}
