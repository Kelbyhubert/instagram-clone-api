CREATE TABLE `tb_comment` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `user_id` BIGINT NOT NULL,
    `post_id` BIGINT,
    `parent_comment_id` BIGINT,
    `comment` TEXT NOT NULL,
    `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT FK_USER_COMMENT FOREIGN KEY (user_id) REFERENCES `tb_user`(id),
    CONSTRAINT FK_POST_COMMENT FOREIGN KEY (post_id) REFERENCES `tb_post`(id),
    CONSTRAINT FK_parent_comment FOREIGN KEY (parent_comment_id) REFERENCES `tb_comment`(id)
);

INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(3, 1, 1, NULL, 'Cool Post', '2025-02-24 14:10:58');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(4, 1, 1, NULL, 'hallo', '2025-02-25 19:40:19');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(5, 1, 1, NULL, 'yesss', '2025-02-25 19:40:36');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(6, 1, 1, NULL, 'mantap', '2025-02-25 20:10:51');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(7, 2, 1, NULL, 'mantap', '2025-02-25 20:12:41');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(8, 1, 1, NULL, 'mantap', '2025-02-25 20:16:07');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(9, 1, 1, NULL, 'gila', '2025-02-25 20:18:30');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(10, 1, 1, NULL, 'astaga', '2025-02-25 20:18:38');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(11, 1, 1, NULL, 'hallo', '2025-02-25 20:21:16');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(12, 1, 1, NULL, 'mantap', '2025-02-25 20:21:29');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(13, 1, 1, NULL, 'yoo', '2025-02-25 20:31:09');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(14, 1, 1, NULL, 'uii', '2025-02-25 20:31:22');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(15, 1, 1, NULL, 'ui', '2025-02-25 20:33:06');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(16, 1, 1, NULL, 'hallo', '2025-02-25 20:33:13');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(17, 1, 1, NULL, 'mantap', '2025-02-25 20:33:40');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(18, 1, 1, NULL, 'gass', '2025-02-25 20:34:21');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(19, 1, 1, NULL, 'gas', '2025-02-25 20:34:43');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(20, 1, 1, NULL, 'gass', '2025-02-25 20:35:29');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(21, 1, 1, NULL, 'gass', '2025-02-25 20:35:39');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(22, 2, 2, NULL, 'apa tuh', '2025-02-25 21:35:03');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(23, 1, 4, NULL, 'Enak semua', '2025-02-26 00:43:01');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(24, 1, 3, NULL, 'Hi', '2025-02-26 18:52:01');
INSERT INTO tb_comment (id, user_id, post_id, parent_comment_id, comment, created_at) VALUES(25, 1, 2, NULL, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque sed elit sed risus bibendum scelerisque vitae nec magna. Nam dignissim imperdiet imperdiet. Nulla bibendum convallis velit nec placerat. Vestibulum in eros convallis, semper orci eu, faucibus turpis. Aliquam erat volutpat. Vivamus scelerisque, ante in elementum mattis, tortor enim sagittis ante, at feugiat orci enim sit amet ipsum. Nulla a felis odio. Aenean sed faucibus lorem. Nunc id leo sagittis mi molestie efficitur at vel elit. Praesent ut dignissim libero, eu fringilla eros. Sed dignissim odio metus, nec venenatis massa volutpat eu. Interdum et malesuada fames ac ante ipsum primis in faucibus. Donec euismod auctor diam, in suscipit erat sollicitudin vel. Morbi vitae arcu lacinia, porttitor arcu in, pretium enim. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.', '2025-02-26 19:38:08');