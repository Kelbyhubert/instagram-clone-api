package com.hori.instagram_clone_api.comment.service;

import java.util.List;

import com.hori.instagram_clone_api.comment.dto.request.CreateCommentDto;
import com.hori.instagram_clone_api.comment.model.Comment;
import com.hori.instagram_clone_api.post.model.Post;

public interface CommentService {

    public Comment createComment(Post post, Long userId, CreateCommentDto createComment);
    public List<Comment> getComments(Long postId);
    public Long totalCommentByPost(Long postId);
    
}
