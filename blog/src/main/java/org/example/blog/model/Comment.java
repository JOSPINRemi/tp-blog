package org.example.blog.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Comment {
    private UUID id;
    private String username;
    private String email;
    private String content;
}
