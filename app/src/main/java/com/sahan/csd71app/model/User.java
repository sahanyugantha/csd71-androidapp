package com.sahan.csd71app.model;

public class User {
    private int id;
    private String email;
    private String password;
    private String gender;
    private String mobile;
    private boolean logged_in;

    public User() {
    }

    public User(int id, String email, String password, String gender, String mobile) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isLogged_in() {
        return logged_in;
    }

    public void setLogged_in(boolean logged_in) {
        this.logged_in = logged_in;
    }
}
