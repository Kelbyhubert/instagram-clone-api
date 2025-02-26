package com.hori.instagram_clone_api.post.dto.response;

import com.hori.instagram_clone_api.post.model.Post;
import com.hori.instagram_clone_api.user.dto.response.UserDTO;

public record PostDto(
    Long id,
    UserDTO user,
    String imageUrl,
    String caption,
    Long totalComment,
    Long totalLike,
    boolean isLiked
) {
    public static PostDto from(Post post , Long totalComment, Long totalLikes, boolean isLiked) {
        UserDTO userDTO = new UserDTO(
                                post.getUser().getId(), 
                                post.getUser().getUsername(), 
                                post.getUser().getProfilePicture());
        return new PostDto(
                    post.getId(), 
                    userDTO, 
                    post.getImageUrl(),
                    post.getCaption(),
                    totalComment,
                    totalLikes,
                    isLiked
        );
    }
}
