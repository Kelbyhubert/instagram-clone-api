package com.hori.instagram_clone_api.post.service;

import java.util.List;

import com.hori.instagram_clone_api.comment.dto.request.CreateCommentDto;
import com.hori.instagram_clone_api.comment.model.Comment;
import com.hori.instagram_clone_api.post.dto.request.CreatePostDto;
import com.hori.instagram_clone_api.post.dto.response.PostDto;
import com.hori.instagram_clone_api.post.model.Post;

public interface PostService {
    
    public Post createPost(CreatePostDto createPost);
    public List<Post> getPosts();
    public List<PostDto> getPostList(Long userId , int offset , int limit);
    public Comment commentPost(Long postId,Long userId,CreateCommentDto commentDto);
    public List<Comment> getPostComments(Long postId);
    public void likePost(Long postId,Long userId);
    public void unlikePost(Long postId,Long userId);

}
