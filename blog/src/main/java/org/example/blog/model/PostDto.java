package org.example.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private UUID id;
    private String title;
    private String description;
    private String content;
}
