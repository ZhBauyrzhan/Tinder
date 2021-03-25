package com.baurr.baldezh.json.deserializer;

import com.baurr.baldezh.model.Meme;
import com.baurr.baldezh.model.MemeReview;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class MemeDeserializer extends StdDeserializer<Meme> {
    public MemeDeserializer() {
        super(Meme.class);
    }
    @Override
    public Meme deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        int id = root.get(Meme.FIELD_ID).asInt();
        String link = root.get(Meme.FIELD_LINK).asText();
        String date = root.get(MemeReview.FIELD_DATE).asText();
        return new Meme(id, link, date);
    }
}