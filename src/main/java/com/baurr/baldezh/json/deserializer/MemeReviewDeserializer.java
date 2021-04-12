package com.baurr.baldezh.json.deserializer;

import com.baurr.baldezh.model.Meme;
import com.baurr.baldezh.model.MemeReview;
import com.baurr.baldezh.service.MemeService;
import com.baurr.baldezh.service.UserService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;

public class MemeReviewDeserializer extends StdDeserializer<MemeReview> {
    private UserService userService;
    private MemeService memeService;

    public MemeReviewDeserializer(UserService userService, MemeService memeService) {
        super(MemeReview.class);
        this.memeService = memeService;
        this.userService = userService;
    }

    @Override
    public MemeReview deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException{
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        int id = root.get(MemeReview.FIELD_ID).asInt();
        int userId = root.get(MemeReview.FIELD_USER_ID).asInt();
        int memeId = root.get(MemeReview.FIELD_MEME_ID).asInt();
        LocalDate date =  root.get(MemeReview.FIELD_DATE).traverse(jsonParser.getCodec()).readValueAs(LocalDate.class);
        boolean liked = root.get(MemeReview.FIELD_LIKED).asBoolean();
        return new MemeReview(id, userService.findById(userId), (Meme) memeService.findById(memeId), date, liked);
    }
}
