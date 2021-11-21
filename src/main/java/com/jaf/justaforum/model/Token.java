package com.jaf.justaforum.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Token {
    private Integer id;
    private String token;
    private LocalDateTime createdDate;
    private Integer userId;

    public Token(Integer id, String token, LocalDateTime createdDate, Integer userId) {
        this.id = id;
        this.token = token;
        this.createdDate = createdDate;
        this.userId = userId;
    }

    public Token(Integer userId) {
        this.token = UUID.randomUUID().toString();
        this.createdDate = LocalDateTime.now();
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
