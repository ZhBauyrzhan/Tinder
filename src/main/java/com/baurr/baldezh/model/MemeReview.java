package com.baurr.baldezh.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.time.LocalDate;
import java.util.Objects;

@DatabaseTable(tableName = "memeReview")
public class MemeReview extends Model{
    @DatabaseField(columnName = "id", id = true)
    private int id;
    @DatabaseField(columnName = "userId", foreign = true, foreignAutoRefresh = true)
    private User userId;
    @DatabaseField(columnName = "memeId", foreign = true, foreignAutoRefresh = true)
    private Meme memeId;
    @DatabaseField(columnName = "date", dataType = DataType.SERIALIZABLE)
    private LocalDate date;
    @DatabaseField(columnName = "liked")
    private boolean liked;

    public MemeReview(int id, User userId, Meme memeId, LocalDate date, boolean liked) {
        this.id = id;
        this.userId = userId;
        this.memeId = memeId;
        this.date = date;
        this.liked = liked;
    }

    public MemeReview() {
        super();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Meme getMemeId() {
        return memeId;
    }

    public void setMemeId(Meme memeId) {
        this.memeId = memeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemeReview that = (MemeReview) o;
        return id == that.id && liked == that.liked && Objects.equals(userId, that.userId) && Objects.equals(memeId, that.memeId) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, memeId, date, liked);
    }

    public final static String FIELD_ID = "id";
    public final static String FIELD_USER_ID = "userId";
    public final static String FIELD_MEME_ID = "memeId";
    public final static String FIELD_DATE = "date";
    public final static String FIELD_LIKED = "liked";
}
