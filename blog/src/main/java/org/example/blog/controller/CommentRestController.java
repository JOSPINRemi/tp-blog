package org.example.blog.controller;

import lombok.AllArgsConstructor;
import org.example.blog.entities.Comment;
import org.example.blog.model.CommentDto;
import org.example.blog.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/comment")
@AllArgsConstructor
public class CommentRestController {
    private final CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    public CommentDto createComment(@RequestBody CommentDto commentDto) {
        return commentService.addComment(commentDto);
    }

    @GetMapping("/comments")
    public List<CommentDto> getAllComments() {
        return commentService.listComments();
    }

    /*@GetMapping("/comment/{id}")
    public Comment getCommentById(@PathVariable("id") UUID id) {
        return commentService.getById(id);
    }

    @PutMapping("/comment/{id}")
    public Comment updateComment(@PathVariable UUID id, @RequestBody Comment comment) {
        return commentService.update(id, comment);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable UUID id) {
        commentService.delete(id);
    }*/
}
