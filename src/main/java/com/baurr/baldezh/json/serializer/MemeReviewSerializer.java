package com.baurr.baldezh.json.serializer;

import com.baurr.baldezh.model.MemeReview;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class MemeReviewSerializer extends StdSerializer<MemeReview> {
    public MemeReviewSerializer() {
        super(MemeReview.class);
    }
    @Override
    public void serialize(MemeReview memeReview, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField(MemeReview.FIELD_ID, memeReview.getId());
        gen.writeObjectField(MemeReview.FIELD_USER_ID, memeReview.getUserId());
        gen.writeObjectField(MemeReview.FIELD_MEME_ID, memeReview.getMemeId());
        gen.writeObjectField(MemeReview.FIELD_DATE, memeReview.getDate());
        gen.writeBooleanField(MemeReview.FIELD_LIKED, memeReview.isLiked());
        gen.writeEndObject();
    }
}
