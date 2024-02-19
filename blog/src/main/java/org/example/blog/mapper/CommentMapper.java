package org.example.blog.mapper;

import org.example.blog.entities.Comment;
import org.example.blog.model.CommentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDto commentToCommentDto(Comment comment);

    Comment commentDtoToComment(CommentDto commentDto);
}
