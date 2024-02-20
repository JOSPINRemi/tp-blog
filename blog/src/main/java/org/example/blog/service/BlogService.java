package org.example.blog.service;

import org.example.blog.entities.Comment;
import org.example.blog.entities.Post;
import org.example.blog.mapper.CommentMapper;
import org.example.blog.mapper.PostMapper;
import org.example.blog.model.CommentDto;
import org.example.blog.model.PostDto;
import org.example.blog.repository.CommentRepository;
import org.example.blog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BlogService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;
    private PostMapper postMapper;
    private CommentMapper commentMapper;

    public BlogService(PostRepository postRepository, CommentRepository commentRepository,
                       PostMapper postMapper, CommentMapper commentMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.postMapper = postMapper;
        this.commentMapper = commentMapper;
    }

    //<editor-fold desc="Post">
    public PostDto createPost(PostDto postDto) {
        return postMapper.postToPostDto(postRepository.save(postMapper.postDtoToPost(postDto)));
    }

    public List<PostDto> listPosts() {
        return postRepository.findAll().stream()
                .map(postMapper::postToPostDto)
                .toList();
    }

    public PostDto findPostById(UUID id) {
        Optional<Post> result = postRepository.findById(id);
        return postMapper.postToPostDto(result.orElse(null));
    }

    public PostDto updatePost(UUID id, PostDto postDto) {
        Post post = postMapper.postDtoToPost(postDto);
        post.setId(id);
        return postMapper.postToPostDto(
                postRepository.save(
                        post
                )
        );
    }

    public void deletePost(UUID id) {
        postRepository.deleteById(id);
    }
    //</editor-fold>

    //<editor-fold desc="Comment">
    public CommentDto addComment(UUID postId, CommentDto commentDto) {
        Post post = postMapper.postDtoToPost(findPostById(postId));
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

    public CommentDto findCommentById(UUID id) {
        Optional<Comment> result = commentRepository.findById(id);
        return commentMapper.commentToCommentDto(result.orElse(null));
    }

    public CommentDto updateComment(UUID id, CommentDto commentDto) {
        Comment c = commentMapper.commentDtoToComment(findCommentById(id));
        System.out.println("c : " + c);
        UUID cid = c.getId();
        System.out.println("cid : " + cid);
        Post post = postMapper.postDtoToPost(findPostById(cid));
        System.out.println("post : " + post);
        if (post != null) {
            Comment comment = commentMapper.commentDtoToComment(commentDto);
            comment.setId(id);
            comment.setPost(post);
            return commentMapper.commentToCommentDto(
                    commentRepository.save(
                            comment
                    )
            );
        }
        System.out.println("post pas mis à jour");
        return null;
    }

    public void deleteComment(UUID id) {
        commentRepository.deleteById(id);
    }
    //</editor-fold>
}
