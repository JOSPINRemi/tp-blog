package org.example.blog.service;

import org.example.blog.mapper.CommentMapper;
import org.example.blog.model.CommentDto;
import org.example.blog.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;


    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public List<CommentDto> listComments(){
        return commentRepository.findAll().stream()
                .map(commentMapper::commentToCommentDto)
                .toList();
    }


    public CommentDto addComment(CommentDto commentDto){
        return commentMapper.commentToCommentDto(commentRepository.save(commentMapper.commentDtoToComment(commentDto)));
    }
}
