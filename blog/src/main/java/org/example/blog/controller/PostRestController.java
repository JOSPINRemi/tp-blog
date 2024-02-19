package org.example.blog.controller;

import lombok.AllArgsConstructor;
import org.example.blog.entities.Post;
import org.example.blog.model.PostDto;
import org.example.blog.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/post")
@AllArgsConstructor
public class PostRestController {
    private final PostService postService;

    @PostMapping("/add")
    public PostDto createPost(@RequestBody PostDto postDto) {
        return postService.create(postDto);
    }

    @GetMapping("/posts")
    public List<PostDto> getAllPosts() {
        return postService.listPosts();
    }

    /*@GetMapping("/post/{id}")
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
    }*/
}
