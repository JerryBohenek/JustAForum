package com.jaf.justaforum.model;

import java.time.LocalDateTime;

public class Post {
    private Integer id;
    private String title;
    private String content;
    private PostCategory postCategory;
    private LocalDateTime publishedDateTime;
    private Integer userId;
    private String username;

    public Post(Integer id, String title, String content, PostCategory postCategory, LocalDateTime publishedDateTime, Integer userId, String username) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.postCategory = postCategory;
        this.publishedDateTime = publishedDateTime;
        this.userId = userId;
        this.username = username;
    }

    public Post(String title, String content, PostCategory postCategory, LocalDateTime publishedDateTime, Integer userId, String username) {
        this.title = title;
        this.content = content;
        this.postCategory = postCategory;
        this.publishedDateTime = publishedDateTime;
        this.userId = userId;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostCategory getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(PostCategory postCategory) {
        this.postCategory = postCategory;
    }

    public LocalDateTime getPublishedDateTime() {
        return publishedDateTime;
    }

    public void setPublishedDateTime(LocalDateTime publishedDateTime) {
        this.publishedDateTime = publishedDateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
