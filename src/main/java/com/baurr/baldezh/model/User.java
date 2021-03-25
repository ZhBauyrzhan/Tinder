package com.baurr.baldezh.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "user")
public class User extends Model{
    @DatabaseField(columnName = "id", id = true)
    private int id;
    @DatabaseField(columnName = "login")
    private String login;
    @DatabaseField(columnName = "password")
    private String password;
    @DatabaseField(columnName = "firstName")
    private String firstName;
    @DatabaseField(columnName = "lastName")
    private String lastName;
    @DatabaseField(columnName = "sex")
    private String sex;
    @DatabaseField(columnName = "country")
    private String country;
    @DatabaseField(columnName = "city")
    private String city;
    @DatabaseField(columnName = "birthDay")
    private String birthDay;
    @DatabaseField(columnName = "date")
    private String date;
    @DatabaseField(columnName = "phone")
    private String phone;
    @DatabaseField(columnName = "status")
    private String status;


    public User(int id, String login, String password, String firstName, String lastName, String sex, String country, String city, String birthDay, String date, String phone, String status) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.country = country;
        this.city = city;
        this.birthDay = birthDay;
        this.date = date;
        this.phone = phone;
        this.status = status;
    }

    public User() {
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public static final String FIELD_ID = "id";
    public static final String FIELD_LOGIN = "login";
    public static final String FIELD_PASSWORD = "password";
    public static final String FIELD_FIRST_NAME = "firstName";
    public static final String FIELD_LAST_NAME = "lastName";
    public static final String FIELD_SEX = "sex";
    public static final String FIELD_COUNTRY = "country";
    public static final String FIELD_CITY = "city";
    public static final String FIELD_BIRTH_DAY = "birthDay";
    public static final String FIELD_DATE = "date";
    public static final String FIELD_PHONE = "phone";
    public static final String FIELD_STATUS = "status";
    public static final String ADMIN = "admin";
    public static final String COMMON = "common";
}
