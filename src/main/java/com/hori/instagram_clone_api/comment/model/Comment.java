package com.hori.instagram_clone_api.comment.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hori.instagram_clone_api.post.model.Post;
import com.hori.instagram_clone_api.user.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> comments;

    private String comment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

}
