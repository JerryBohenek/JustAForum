package com.jaf.justaforum.model;

import java.time.LocalDateTime;

public class User {
    private Integer id;
    private String email;
    private String username;
    private String password;
    private LocalDateTime registrationDate;
    private short  active;

    public User(Integer id, String email, String username, String password, LocalDateTime registrationDate, short  active) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.registrationDate = registrationDate;
        this.active = active;
    }

    public User(String username, String email, String password, LocalDateTime registrationDate, short  active) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public short  getActive() { return active; }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
