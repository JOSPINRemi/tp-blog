package org.example.blog.controller;

import lombok.AllArgsConstructor;
import org.example.blog.model.Post;
import org.example.blog.service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/post")
@AllArgsConstructor
public class PostRestController {
    private Service<Post> postService;

    @PostMapping("/add")
    public Post createPost(@RequestBody Post post) {
        return postService.create(post);
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAll();
    }

    @GetMapping("/post/{id}")
    public Post getPostById(@PathVariable("id") UUID id) {
        return postService.getById(id);
    }

    @PutMapping("/post/{id}")
    public Post updatePost(@PathVariable UUID id, @RequestBody Post post) {
        return postService.update(id, post);
    }

    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable UUID id) {
        postService.delete(id);
    }
}
