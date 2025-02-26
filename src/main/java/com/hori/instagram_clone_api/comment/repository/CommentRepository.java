package com.hori.instagram_clone_api.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hori.instagram_clone_api.comment.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    public List<Comment> findAllByPostId(Long postId);
    public Long countByPostId(Long postId);

}
