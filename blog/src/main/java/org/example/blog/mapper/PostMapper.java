package org.example.blog.mapper;

import org.example.blog.entities.Post;
import org.example.blog.model.PostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostDto postToPostDto(Post post);

    Post postDtoToPost(PostDto postDto);
}
