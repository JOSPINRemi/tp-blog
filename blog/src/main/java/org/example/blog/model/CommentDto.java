package org.example.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private UUID id;
    private String username;
    private String email;
    private String content;
}
