package com.hori.instagram_clone_api.comment.dto.response;

import com.hori.instagram_clone_api.user.dto.response.UserDTO;
import com.hori.instagram_clone_api.user.model.User;

public record CommentDto(
    Long commentId,
    UserDTO user,
    String comment
) {
    public static CommentDto from(Long commentId, User user, String comment) {
        UserDTO userDTO = new UserDTO(user.getId(), user.getUsername(), user.getProfilePicture());
        return new CommentDto(commentId, userDTO, comment);
    }
}
