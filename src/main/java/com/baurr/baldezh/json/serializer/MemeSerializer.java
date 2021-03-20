package com.baurr.baldezh.json.serializer;

import com.baurr.baldezh.model.Meme;
import com.baurr.baldezh.model.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class MemeSerializer extends StdSerializer<Meme> {
    public MemeSerializer() {
        super(Meme.class);
    }
    @Override
    public void serialize(Meme meme, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField(Meme.FIELD_ID, meme.getId());
        gen.writeStringField(Meme.FIELD_LINK, meme.getLink());
        gen.writeStringField(User.FIELD_PASSWORD, meme.getDate());
        gen.writeEndObject();
    }
}
