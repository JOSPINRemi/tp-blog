package org.example.blog.service;

import org.example.blog.entities.Comment;
import org.example.blog.entities.Post;
import org.example.blog.mapper.CommentMapper;
import org.example.blog.mapper.PostMapper;
import org.example.blog.model.CommentDto;
import org.example.blog.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    private final PostService postService;
    private final PostMapper postMapper;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper,
                          PostService postService, PostMapper postMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
        this.postService = postService;
        this.postMapper = postMapper;
    }

    public CommentDto addComment(UUID postId, CommentDto commentDto) {
        Post post = postMapper.postDtoToPost(postService.findById(postId));
        if (post != null) {
            Comment comment = commentMapper.commentDtoToComment(commentDto);
            comment.setPost(post);
            return commentMapper.commentToCommentDto(
                    commentRepository.save(
                            comment
                    )
            );
        } else return null;
    }

    public List<CommentDto> listComments() {
        return commentRepository.findAll().stream()
                .map(commentMapper::commentToCommentDto)
                .toList();
    }

    public CommentDto findById(UUID id) {
        Optional<Comment> result = commentRepository.findById(id);
        return commentMapper.commentToCommentDto(result.orElse(null));
    }

    public CommentDto update(UUID id, CommentDto commentDto) {
        Comment comment = commentMapper.commentDtoToComment(commentDto);
        comment.setId(id);
        return commentMapper.commentToCommentDto(
                commentRepository.save(
                        comment
                )
        );
    }

    public void delete(UUID id) {
        commentRepository.deleteById(id);
    }
}
