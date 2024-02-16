package org.example.blog.controller;

import lombok.AllArgsConstructor;
import org.example.blog.model.Comment;
import org.example.blog.service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/comment")
@AllArgsConstructor
public class CommentRestController {
    private Service<Comment> commentService;

    @PostMapping("/add")
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.create(comment);
    }

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentService.getAll();
    }

    @GetMapping("/comment/{id}")
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
    }
}
