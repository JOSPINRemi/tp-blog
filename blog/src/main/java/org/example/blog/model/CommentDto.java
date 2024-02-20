package org.example.blog.model;

import java.util.UUID;

public class CommentDto {
    private UUID id;
    private String username;
    private String email;
    private String content;

    private PostDto post;

    public CommentDto(UUID id, String username, String email, String content) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.content = content;
    }

    public CommentDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
