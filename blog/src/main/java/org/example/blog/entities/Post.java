package org.example.blog.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    private String description;

    private String content;

    @OneToMany
    private List<Comment> comments = new ArrayList<>();
}
