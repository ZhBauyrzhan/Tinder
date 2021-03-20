package com.baurr.baldezh.json.serializer;

import com.baurr.baldezh.model.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class UserSerializer extends StdSerializer<User> {
    public UserSerializer() {
        super(User.class);
    }
    @Override
    public void serialize(User user, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField(User.FIELD_ID, user.getId());
        gen.writeStringField(User.FIELD_LOGIN, user.getLogin());
        gen.writeStringField(User.FIELD_PASSWORD, user.getPassword());
        gen.writeStringField(User.FIELD_FIRST_NAME, user.getFirstName());
        gen.writeStringField(User.FIELD_LAST_NAME, user.getLastName());
        gen.writeStringField(User.FIELD_SEX, user.getSex());
        gen.writeStringField(User.FIELD_COUNTRY, user.getCountry());
        gen.writeStringField(User.FIELD_CITY, user.getCity());
        gen.writeStringField(User.FIELD_BIRTH_DAY, user.getBirthDay());
        gen.writeStringField(User.FIELD_DATE, user.getDate());
        gen.writeStringField(User.FIELD_PHONE, user.getPhone());
        gen.writeStringField(User.FIELD_STATUS, user.getStatus().toString());
        gen.writeEndObject();
    }
}
