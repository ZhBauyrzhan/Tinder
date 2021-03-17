package com.baurr.baldezh.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "meme")
public class Meme extends Model{
    @DatabaseField(columnName = "id", id = true)
    private int id;
    @DatabaseField(columnName = "link")
    private String link;
    @DatabaseField(columnName = "date")
    private String date;

    public Meme(int id, String link, String date) {
        this.id = id;
        this.link = link;
        this.date = date;
    }

    public Meme() {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public final static String FIELD_ID = "id";
    public final static String FIELD_LINK = "link";
    public final static String FIELD_DATE = "date";
}
