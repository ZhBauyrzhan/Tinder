package com.baurr.baldezh.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

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
    @DatabaseField(columnName = "birthDay", dataType = DataType.SERIALIZABLE)
    private LocalDate birthDay;
    @DatabaseField(columnName = "date", dataType = DataType.SERIALIZABLE)
    private LocalDate date;
    @DatabaseField(columnName = "lastMemeNumber")
    private int lastMemeNumber;
    @DatabaseField(columnName = "memeRequestTime", dataType = DataType.SERIALIZABLE)
    private LocalDateTime memeRequestTime;
    @DatabaseField(columnName = "userRequestTime", dataType = DataType.SERIALIZABLE)
    private LocalDateTime userRequestTime;
    @DatabaseField(columnName = "phone")
    private String phone;
    @DatabaseField(columnName = "status")
    private String status;


    public User() {

    }
    public User(int id, String login, String password, String firstName, String lastName, String sex, String country, String city, LocalDate birthDay, LocalDate date, int lastMemeNumber, LocalDateTime memeRequestTime, LocalDateTime userRequestTime, String phone, String status) {
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
        this.lastMemeNumber = lastMemeNumber;
        this.memeRequestTime = memeRequestTime;
        this.userRequestTime = userRequestTime;
        this.phone = phone;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(sex, user.sex) && Objects.equals(country, user.country) && Objects.equals(city, user.city) && Objects.equals(birthDay, user.birthDay) && Objects.equals(date, user.date) && Objects.equals(memeRequestTime, user.memeRequestTime) && Objects.equals(userRequestTime, user.userRequestTime) && Objects.equals(phone, user.phone) && Objects.equals(status, user.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, firstName, lastName, sex, country, city, birthDay, date, memeRequestTime, userRequestTime, phone, status);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", birthDay=" + birthDay +
                ", date=" + date +
                ", lastMemeNumber=" + lastMemeNumber +
                ", memeRequestTime=" + memeRequestTime +
                ", userRequestTime=" + userRequestTime +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getLastMemeNumber() {
        return lastMemeNumber;
    }

    public void setLastMemeNumber(int lastMemeNumber) {
        this.lastMemeNumber = lastMemeNumber;
    }

    public LocalDateTime getMemeRequestTime() {
        return memeRequestTime;
    }

    public void setMemeRequestTime(LocalDateTime memeRequestTime) {
        this.memeRequestTime = memeRequestTime;
    }

    public LocalDateTime getUserRequestTime() {
        return userRequestTime;
    }

    public void setUserRequestTime(LocalDateTime userRequestTime) {
        this.userRequestTime = userRequestTime;
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

    public static final String FIELD_ID = "id";
    public static final String FIELD_MEME_REQUEST_TIME = "memeRequestTime";
    public static final String FIELD_USER_REQUEST_TIME = "userRequestTime";
    public static final String FIELD_LAST_MEME_NUMBER = "lastMemeNumber";
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
    public static final String MALE = "male";
    public static final String FEMALE = "female";
    public static final int NEED_DAYS = 0;
    public static final int NEED_HOURS = 0;
    public static final int NEED_MINUTES = 5;
    public static final int NEED_SECONDS = 0;
}
