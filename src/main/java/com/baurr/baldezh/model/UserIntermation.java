package com.baurr.baldezh.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "userIntermation")
public class UserIntermation {
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
}
