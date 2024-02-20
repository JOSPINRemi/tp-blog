package org.example.blog.controller;

import org.example.blog.model.PostDto;
import org.example.blog.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class PostRestController {
    private final BlogService blogService;

    public PostRestController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/post/add")
    public PostDto createPost(@RequestBody PostDto postDto) {
        System.out.println(postDto.getTitle());
        return blogService.createPost(postDto);
    }

    @GetMapping("/posts")
    public List<PostDto> getAllPosts() {
        return blogService.listPosts();
    }

    @GetMapping("/post/details/{id}")
    public PostDto getPostById(@PathVariable("id") UUID id) {
        return blogService.findPostById(id);
    }

    @PutMapping("/post/update/{id}")
    public PostDto updatePost(@PathVariable UUID id, @RequestBody PostDto postDto) {
        return blogService.updatePost(id, postDto);
    }

    @DeleteMapping("/post/delete/{id}")
    public void deletePost(@PathVariable UUID id) {
        blogService.deletePost(id);
    }
}
