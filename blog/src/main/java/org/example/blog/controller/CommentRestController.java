package org.example.blog.controller;

import org.example.blog.entities.Post;
import org.example.blog.model.CommentDto;
import org.example.blog.model.PostDto;
import org.example.blog.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class CommentRestController {
    private final BlogService blogService;

    public CommentRestController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/comment/add/{postId}")
    public CommentDto createComment(@RequestBody CommentDto commentDto, @PathVariable UUID postId) {
        return blogService.addComment(postId, commentDto);
    }

    @GetMapping("/comments")
    public List<CommentDto> getAllComments() {
        return blogService.listComments();
    }

    @GetMapping("/comment/details/{id}")
    public CommentDto getCommentById(@PathVariable("id") UUID id) {
        return blogService.findCommentById(id);
    }

    @PutMapping("/comment/update/{id}")
    public CommentDto updateComment(@PathVariable UUID id, @RequestBody CommentDto commentDto) {
        return blogService.updateComment(id, commentDto);
    }

    @DeleteMapping("/comment/delete/{id}")
    public void deleteComment(@PathVariable UUID id) {
        blogService.deleteComment(id);
    }
}
