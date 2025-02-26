package com.hori.instagram_clone_api.comment.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hori.instagram_clone_api.comment.dto.request.CreateCommentDto;
import com.hori.instagram_clone_api.comment.model.Comment;
import com.hori.instagram_clone_api.comment.repository.CommentRepository;
import com.hori.instagram_clone_api.comment.service.CommentService;
import com.hori.instagram_clone_api.post.model.Post;
import com.hori.instagram_clone_api.user.model.User;
import com.hori.instagram_clone_api.user.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;

    @Override
    @Transactional
    public Comment createComment(Post post , Long userId, CreateCommentDto createComment) {
        Comment newComment = new Comment();

        User user = userService.getUserDetails(userId);
        newComment.setUser(user);
        newComment.setPost(post);
        newComment.setComment(createComment.comment());

        return commentRepository.save(newComment);
    }

    @Override
    public List<Comment> getComments(Long postId) {
        return commentRepository.findAllByPostId(postId);
    }

    @Override
    public Long totalCommentByPost(Long postId) {
        return commentRepository.countByPostId(postId);
    }

    
    
}
