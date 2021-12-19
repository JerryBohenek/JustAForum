package com.jaf.justaforum.dto;

public class CommentDto {
    private Long id;
    private String content;
    private String writeDateTime;
    private String username;

    public CommentDto(Long id, String content, String writeDateTime, String username) {
        this.id = id;
        this.content = content;
        this.writeDateTime = writeDateTime;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriteDateTime() {
        return writeDateTime;
    }

    public void setWriteDateTime(String writeDateTime) {
        this.writeDateTime = writeDateTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
