package org.example.blog.service;

import org.example.blog.entities.Post;
import org.example.blog.mapper.PostMapper;
import org.example.blog.model.PostDto;
import org.example.blog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public PostDto findById(UUID id) {
        Optional<Post> result = postRepository.findById(id);
        return postMapper.postToPostDto(result.orElse(null));
    }

    public PostDto update(UUID id, PostDto postDto) {
        Post post = postMapper.postDtoToPost(postDto);
        post.setId(id);
        return postMapper.postToPostDto(
                postRepository.save(
                        post
                )
        );
    }

    public void delete(UUID id) {
        postRepository.deleteById(id);
    }
}
