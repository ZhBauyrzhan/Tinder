package com.baurr.baldezh.json.serializer;

import com.baurr.baldezh.model.User;
import com.baurr.baldezh.model.UserIntermation;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class UserIntermationSerializer extends StdSerializer<UserIntermation> {
    public UserIntermationSerializer() {
        super(UserIntermation.class);
    }
    @Override
    public void serialize(UserIntermation userIntermation, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField(UserIntermation.FIELD_ID, userIntermation.getId());
        gen.writeObjectField(UserIntermation.FIELD_SOURCE, userIntermation.getSource());
        gen.writeObjectField(UserIntermation.FIELD_TARGET, userIntermation.getTarget());
        gen.writeStringField(UserIntermation.FIELD_REACTION, userIntermation.getReaction());
        gen.writeObjectField(UserIntermation.FIELD_DATE, userIntermation.getDate());
        gen.writeEndObject();
    }
}
