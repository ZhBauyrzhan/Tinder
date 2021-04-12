package com.baurr.baldezh.controller;

import com.baurr.baldezh.model.Meme;
import com.baurr.baldezh.model.MemeReview;
import com.baurr.baldezh.model.User;
import com.baurr.baldezh.model.UserIntermation;
import com.baurr.baldezh.service.AbstractService;
import com.baurr.baldezh.service.MemeReviewService;
import com.baurr.baldezh.service.UserIntermationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import org.mindrot.jbcrypt.BCrypt;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class UserController extends AbstractController<User>{
    private final AbstractService<User> service;
    private final ObjectMapper objectMapper;
    private UserIntermationService userIntermationService;
    private MemeReviewService memeReviewService;

    public UserController(AbstractService<User> service, ObjectMapper objectMapper,  UserIntermationService userIntermationService, MemeReviewService memeReviewService) {
        super(service, objectMapper, User.class);
        this.service = service;
        this.objectMapper = objectMapper;
        this.userIntermationService = userIntermationService;
        this.memeReviewService = memeReviewService;
    }

    @Override
    public void bigPost(Context context) {
        try {
            List<User> objects = objectMapper.readValue(context.body(), new TypeReference< List<User> >(){});
            for(int i = 0; i < objects.size(); i++) {
                service.save(objects.get(i));
                User saved = service.findById(objects.get(i).getId());
                context.result(objectMapper.writeValueAsString(saved));
            }
            context.status(201);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            context.status(400);
        }
    }

    @Override
    public Boolean checkRights(Context context) {
        String senderPassword = context.basicAuthCredentials().getPassword();
        String senderLogin = context.basicAuthCredentials().getUsername();
        User user = service.findUserByLogin(senderLogin);
        LocalDateTime localDateTime = LocalDateTime.now();
        return ( (BCrypt.checkpw(senderPassword, user.getPassword()) || user.getStatus().equals(User.ADMIN))
                && (user.getUserRequestTime().plusDays(User.NEED_DAYS).plusHours(User.NEED_HOURS).plusMinutes(User.NEED_MINUTES).plusSeconds(User.NEED_SECONDS).isBefore(localDateTime)) );
    }

    @Override
    public void getAll(Context context, int pageNumber, int pageSize) {
        try {
            if(checkRights(context)) {
//                for(int i = 0; i < 20; i++)
//                    System.out.println(1);
                String senderLogin = context.basicAuthCredentials().getUsername();
                User user = service.findUserByLogin(senderLogin);
                List<User> returnedModels = service.findUser(pageNumber, pageSize, user.getSex());
                List<UserIntermation> userIntermations = userIntermationService.findAll(0,100000000);
                List<MemeReview> memeReviews = memeReviewService.findAll(0,100000000);
                HashMap<Meme, Integer> userLikedMemes = new HashMap<>();
                HashMap<User, Integer> possibleUsers = new HashMap<>();
                for(int i = 0; i < memeReviews.size(); i++) {
                    if(memeReviews.get(i).isLiked() && memeReviews.get(i).getUserId().equals(user)) {
                        userLikedMemes.put(memeReviews.get(i).getMemeId(), 1);
                    }
                }
                for(int i = 0; i < memeReviews.size(); i++) {
                    if(memeReviews.get(i).isLiked()
                            && !memeReviews.get(i).getUserId().equals(user)
                            && userLikedMemes.containsKey(memeReviews.get(i))
                            && returnedModels.contains(memeReviews.get(i).getUserId())) {
                        if(possibleUsers.get(memeReviews.get(i).getUserId()) == null) {
                            possibleUsers.put(memeReviews.get(i).getUserId(), 1);
                        }
                        else {
                            possibleUsers.put(memeReviews.get(i).getUserId(), possibleUsers.get(memeReviews.get(i).getUserId()).intValue());
                        }
                    }
                }
                List<User>users = new ArrayList<>();
                int addedUserCount = 0;
//                System.out.println(userIntermations.get(0).getTarget());
//                System.out.println(user);
                for (int i = 0; i < userIntermations.size(); i++) {
                    if (userIntermations.get(i).getTarget().equals(user)
                            && userIntermations.get(i).getReaction().equals("right")
                            && returnedModels.contains(userIntermations.get(i).getTarget())
                            && !possibleUsers.containsKey(userIntermations.get(i))) {
                        addedUserCount++;
                        users.add(userIntermations.get(i).getSource());
                    }
                    if(addedUserCount + possibleUsers.size() >= 20 && addedUserCount >= 10) {
                        break;
                    }
                }
                Map<User,Integer> topTwenty =
                        possibleUsers.entrySet().stream()
                                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
                for (User key : topTwenty.keySet() ) {
                    if(!users.contains(key))
                        users.add(key);
                    if(users.size() >= 20)
                        break;
                }
                System.out.println(user.getUserRequestTime());
                user.setUserRequestTime(LocalDateTime.now());
                System.out.println(user.getUserRequestTime());
                service.update(user);
                context.result(objectMapper.writeValueAsString(users));
            }
        } catch (Exception e) {
            e.printStackTrace();
            context.status(500);
        }
    }
}
