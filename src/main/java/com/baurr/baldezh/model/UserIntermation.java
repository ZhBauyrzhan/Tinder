package com.baurr.baldezh.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Objects;

@DatabaseTable(tableName = "userIntermation")
public class UserIntermation extends Model{
    @DatabaseField(columnName = "id", id = true)
    private int id;
    @DatabaseField(columnName = "source", foreign = true, foreignAutoRefresh = true)
    private User source;
    @DatabaseField(columnName = "target", foreign = true, foreignAutoRefresh = true)
    private User target;
    @DatabaseField(columnName = "reaction")
    private String reaction;
    @DatabaseField(columnName = "date")
    private String date;

    public UserIntermation(int id, User source, User target, String reaction, String date) {
        this.id = id;
        this.source = source;
        this.target = target;
        this.reaction = reaction;
        this.date = date;
    }
    public UserIntermation() {

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public User getSource() {
        return source;
    }

    public void setSource(User source) {
        this.source = source;
    }

    public User getTarget() {
        return target;
    }

    public void setTarget(User target) {
        this.target = target;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserIntermation that = (UserIntermation) o;
        return id == that.id && Objects.equals(source, that.source) && Objects.equals(target, that.target) && Objects.equals(reaction, that.reaction) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, source, target, reaction, date);
    }

    public final static String FIELD_ID = "id";
    public final static String FIELD_SOURCE = "source";
    public final static String FIELD_TARGET = "target";
    public final static String FIELD_REACTION = "reaction";
    public final static String FIELD_DATE = "date";
}
