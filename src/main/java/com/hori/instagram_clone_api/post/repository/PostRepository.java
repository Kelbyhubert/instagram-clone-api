package com.hori.instagram_clone_api.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hori.instagram_clone_api.post.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT COUNT(u) FROM Post p JOIN p.likes u WHERE p.id = :postId")
    Long countLikesByPostId(@Param("postId") Long postId);

    @Query("""
        SELECT p FROM Post p 
        ORDER BY p.id ASC
        LIMIT :limit OFFSET :start
    """)
    List<Post> findPostsWithLimitAndOffset(@Param("start") int start, 
                                           @Param("limit") int limit);

}