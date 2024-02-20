package org.example.blog.controller;

import org.example.blog.model.PostDto;
import org.example.blog.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/post")
public class PostRestController {
    private final PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/add")
    public PostDto createPost(@RequestBody PostDto postDto) {
        System.out.println(postDto.getTitle());
        return postService.create(postDto);
    }

    @GetMapping("/posts")
    public List<PostDto> getAllPosts() {
        return postService.listPosts();
    }

    @GetMapping("/post/{id}")
    public PostDto getPostById(@PathVariable("id") UUID id) {
        return postService.findById(id);
    }

    @PutMapping("/post/{id}")
    public PostDto updatePost(@PathVariable UUID id, @RequestBody PostDto postDto) {
        return postService.update(id, postDto);
    }

    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable UUID id) {
        postService.delete(id);
    }
}
