package com.baurr.baldezh.json.deserializer;

import com.baurr.baldezh.model.Meme;
import com.baurr.baldezh.model.MemeReview;
import com.baurr.baldezh.model.User;
import com.baurr.baldezh.service.MemeService;
import com.baurr.baldezh.service.UserService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

public class UserDeserializer extends StdDeserializer<User> {
    public UserDeserializer() {
        super(MemeReview.class);
    }

    @Override
    public User deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        int id = root.get(User.FIELD_ID).asInt();
        String login = root.get(User.FIELD_LOGIN).asText();
        String password = root.get(User.FIELD_PASSWORD).asText();
        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        String firstName = root.get(User.FIELD_FIRST_NAME).asText();
        String lastName = root.get(User.FIELD_LAST_NAME).asText();
        String sex = root.get(User.FIELD_SEX).asText();
        String country = root.get(User.FIELD_COUNTRY).asText();
        String city = root.get(User.FIELD_CITY).asText();
        String birthDay = root.get(User.FIELD_BIRTH_DAY).asText();
        LocalDate date = LocalDate.parse(root.get(User.FIELD_DATE).asText());
        LocalDateTime memeRequestTime =  LocalDateTime.parse(root.get(User.FIELD_MEME_REQUEST_TIME).asText());
        LocalDateTime userRequestTime=  LocalDateTime.parse(root.get(User.FIELD_USER_REQUEST_TIME).asText());
        String phone = root.get(User.FIELD_PHONE).asText();
        String status = root.get(User.FIELD_STATUS).asText();
        return new User(id, login, hashPassword, firstName, lastName, sex, country, city, birthDay, date, memeRequestTime, userRequestTime, phone, status);
    }
}
