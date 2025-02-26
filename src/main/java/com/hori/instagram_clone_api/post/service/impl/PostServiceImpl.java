package com.hori.instagram_clone_api.post.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.hori.instagram_clone_api.comment.dto.request.CreateCommentDto;
import com.hori.instagram_clone_api.comment.model.Comment;
import com.hori.instagram_clone_api.comment.service.CommentService;
import com.hori.instagram_clone_api.post.dto.request.CreatePostDto;
import com.hori.instagram_clone_api.post.dto.response.PostDto;
import com.hori.instagram_clone_api.post.model.Post;
import com.hori.instagram_clone_api.post.repository.PostRepository;
import com.hori.instagram_clone_api.post.service.PostService;
import com.hori.instagram_clone_api.user.model.User;
import com.hori.instagram_clone_api.user.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    
    private final PostRepository postRepository;
    private final UserService userService;
    private final CommentService commentService;
    
    @Override
    @Transactional
    public Post createPost(CreatePostDto createPost) {

        User user = userService.getUserDetails(createPost.userId());

        Post newPost = new Post();
        newPost.setUser(user);
        newPost.setCaption(createPost.caption());
        newPost.setImageUrl(createPost.imageUrl());
    
        return postRepository.save(newPost);
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    @Transactional
    public Comment commentPost(Long postId,Long userId, CreateCommentDto commentDto) {
        Post post = getPost(postId);

        return commentService.createComment(post,userId,commentDto);
    }

    @Override
    public List<PostDto> getPostList(Long userId, int offset , int limit) {

        List<Post> posts = postRepository.findPostsWithLimitAndOffset(offset,limit);
        User user = userService.getUserDetails(userId);

        //refactor (not optimized cause N+1)
        List<PostDto> postDtos = posts.stream()
                                    .map(post -> PostDto
                                        .from(
                                            post, 
                                            commentService.totalCommentByPost(post.getId()), 
                                            postRepository.countLikesByPostId(post.getId()), 
                                            post.getLikes().contains(user)
                                        )
                                    ).toList();

        return postDtos;
        
    }

    @Override
    public List<Comment> getPostComments(Long postId) {
        getPost(postId);
        return commentService.getComments(postId);
    }

    private Post getPost(Long postId) {
        return postRepository.findById(postId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post Not Found")
        );
    }

    @Override
    @Transactional
    public void likePost(Long postId, Long userId) {
        User user = userService.getUserDetails(userId);

        Post post = getPost(postId);
        if(!post.getLikes().contains(user)){
            post.getLikes().add(user);
        }

        postRepository.save(post);
    }

    @Override
    @Transactional
    public void unlikePost(Long postId, Long userId) {
        User user = userService.getUserDetails(userId);

        Post post = getPost(postId);
        post.getLikes().remove(user);
        
        postRepository.save(post);
    }

    @Override
    public List<PostDto> getUserPostList(Long userId) {
        User user = userService.getUserDetails(userId);

        List<PostDto> postDtos = user.getLikedPosts().stream()
                                        .map(post -> PostDto
                                            .from(
                                                post, 
                                                commentService.totalCommentByPost(post.getId()), 
                                                postRepository.countLikesByPostId(post.getId()), 
                                                post.getLikes().contains(user)
                                            )
                                        ).toList();
        return postDtos;
    }


    
    
}
