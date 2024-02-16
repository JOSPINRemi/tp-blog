package org.example.blog.service;

import org.example.blog.model.Comment;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CommentServiceImpl implements org.example.blog.service.Service<Comment> {
    private final Map<UUID, Comment> comments = new HashMap<>();
    @Override
    public Comment create(Comment element) {
        element.setId(UUID.randomUUID());
        comments.put(element.getId(), element);
        return element;
    }

    @Override
    public List<Comment> getAll() {
        return comments.values().stream().toList();
    }

    @Override
    public Comment getById(UUID id) {
        return comments.get(id);
    }

    @Override
    public Comment update(UUID id, Comment element) {
        Comment commentExist = getById(id);
        if (commentExist != null) {
            commentExist.setUsername(element.getUsername());
            commentExist.setEmail(element.getEmail());
            commentExist.setContent(element.getContent());
        }
        return commentExist;
    }

    @Override
    public void delete(UUID id) {
        comments.remove(id);
    }
}
