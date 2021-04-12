package com.baurr.baldezh.json.deserializer;

import com.baurr.baldezh.model.Meme;
import com.baurr.baldezh.model.MemeReview;
import com.baurr.baldezh.model.User;
import com.baurr.baldezh.model.UserIntermation;
import com.baurr.baldezh.service.UserService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;

public class UserIntermationDeserializer extends StdDeserializer<UserIntermation> {
    private UserService userService;
    public UserIntermationDeserializer(UserService userService) {
        super(UserIntermation.class);
        this.userService = userService;
    }
    @Override
    public UserIntermation deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        int id = root.get(UserIntermation.FIELD_ID).asInt();
        int sourceId = root.get(UserIntermation.FIELD_SOURCE).asInt();
        int targetId = root.get(UserIntermation.FIELD_TARGET).asInt();
        String reaction = root.get(UserIntermation.FIELD_REACTION).asText();
        LocalDate date =  root.get(UserIntermation.FIELD_DATE).traverse(jsonParser.getCodec()).readValueAs(LocalDate.class);
        return new UserIntermation(id, userService.findById(sourceId), userService.findById(targetId), reaction,date);
    }
}
