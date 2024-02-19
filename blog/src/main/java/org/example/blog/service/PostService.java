package org.example.blog.service;

import org.example.blog.mapper.PostMapper;
import org.example.blog.model.PostDto;
import org.example.blog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostService(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    public PostDto create(PostDto element) {
        return postMapper.postToPostDto(postRepository.save(postMapper.postDtoToPost(element)));
    }

    public List<PostDto> listPosts() {
        return postRepository.findAll().stream()
                .map(postMapper::postToPostDto)
                .toList();
    }
}
