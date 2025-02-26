CREATE TABLE `tb_post_like` (
    `post_id` BIGINT NOT NULL,
    `user_id` BIGINT NOT NULL,
    CONSTRAINT `PK_POST_LIKE` PRIMARY KEY (`post_id`, `user_id`),
    CONSTRAINT `FK_POST_LIKE` FOREIGN KEY (`post_id`) REFERENCES `tb_post`(id),
    CONSTRAINT `FK_USER_LIKE` FOREIGN KEY (`user_id`) REFERENCES `tb_user`(id)
);


INSERT INTO tb_post_like (post_id, user_id) VALUES(1, 1);
INSERT INTO tb_post_like (post_id, user_id) VALUES(3, 1);
INSERT INTO tb_post_like (post_id, user_id) VALUES(4, 1);
INSERT INTO tb_post_like (post_id, user_id) VALUES(1, 2);
INSERT INTO tb_post_like (post_id, user_id) VALUES(2, 2);