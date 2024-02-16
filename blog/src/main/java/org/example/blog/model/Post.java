package org.example.blog.model;

import lombok.*;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Post {
    private UUID id;
    private String title;
    private String description;
    private String content;
    private Map<UUID, Comment> comments;
}
