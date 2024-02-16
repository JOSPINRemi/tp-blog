package org.example.blog.service;

import org.example.blog.model.Post;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PostServiceImpl implements org.example.blog.service.Service<Post> {
    private final Map<UUID, Post> posts = new HashMap<>();

    @Override
    public Post create(Post element) {
        element.setId(UUID.randomUUID());
        posts.put(element.getId(), element);
        return element;
    }

    @Override
    public List<Post> getAll() {
        return posts.values().stream().toList();
    }

    @Override
    public Post getById(UUID id) {
        return posts.get(id);
    }

    @Override
    public Post update(UUID id, Post element) {
        Post postExist = getById(id);
        if (postExist != null) {
            postExist.setTitle(element.getTitle());
            postExist.setDescription(element.getDescription());
            postExist.setContent(element.getContent());
            postExist.setComments(element.getComments());
        }
        return postExist;
    }

    @Override
    public void delete(UUID id) {
        posts.remove(id);
    }
}
