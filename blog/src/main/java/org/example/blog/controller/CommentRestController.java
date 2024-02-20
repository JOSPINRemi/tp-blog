package org.example.blog.controller;

import org.example.blog.model.CommentDto;
import org.example.blog.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentRestController {
    private final CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add/{postId}")
    public CommentDto createComment(@RequestBody CommentDto commentDto, @PathVariable UUID postId) {
        return commentService.addComment(postId, commentDto);
    }

    @GetMapping("/comments")
    public List<CommentDto> getAllComments() {
        return commentService.listComments();
    }

    @GetMapping("/comment/{id}")
    public CommentDto getCommentById(@PathVariable("id") UUID id) {
        return commentService.findById(id);
    }

    @PutMapping("/comment/{id}")
    public CommentDto updateComment(@PathVariable UUID id, @RequestBody CommentDto commentDto) {
        return commentService.update(id, commentDto);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable UUID id) {
        commentService.delete(id);
    }
}
