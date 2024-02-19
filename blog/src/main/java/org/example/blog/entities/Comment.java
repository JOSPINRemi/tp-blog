package org.example.blog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String email;
    private String content;
}
