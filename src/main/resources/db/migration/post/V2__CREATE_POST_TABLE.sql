CREATE TABLE `tb_post` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `user_id` BIGINT NOT NULL,
    `caption` TEXT NOT NULL,
    `image_url` TEXT NOT NULL,
    `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `updated_at` DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT FK_USER_POST FOREIGN KEY (user_id) REFERENCES `tb_user`(id)
);


INSERT INTO tb_post (id, user_id, caption, image_url, created_at, updated_at) VALUES(1, 1, 'Nice', 'https://firebasestorage.googleapis.com/v0/b/instagram-clone-dc576.firebasestorage.app/o/instagram-clone%2FScreenshot%202024-12-17%20105240.png?alt=media', '2025-02-24 14:02:39', NULL);
INSERT INTO tb_post (id, user_id, caption, image_url, created_at, updated_at) VALUES(2, 1, 'Yeahhhh', 'https://firebasestorage.googleapis.com/v0/b/instagram-clone-dc576.firebasestorage.app/o/instagram-clone%2FScreenshot%202024-09-29%20192632.png?alt=media', '2025-02-24 14:19:03', NULL);
INSERT INTO tb_post (id, user_id, caption, image_url, created_at, updated_at) VALUES(3, 1, 'GASSS', 'https://firebasestorage.googleapis.com/v0/b/instagram-clone-dc576.firebasestorage.app/o/instagram-clone%2FScreenshot%202024-09-29%20192538.png?alt=media', '2025-02-24 14:19:42', NULL);
INSERT INTO tb_post (id, user_id, caption, image_url, created_at, updated_at) VALUES(4, 1, 'Looks Good', 'https://firebasestorage.googleapis.com/v0/b/instagram-clone-dc576.firebasestorage.app/o/instagram-clone%2FScreenshot%202024-09-08%20210503.png?alt=media', '2025-02-24 14:20:20', NULL);
INSERT INTO tb_post (id, user_id, caption, image_url, created_at, updated_at) VALUES(27, 1, 'Hello', 'https://firebasestorage.googleapis.com/v0/b/instagram-clone-dc576.firebasestorage.app/o/images%2F1740562930632.png?alt=media&token=4bfeee62-08e3-4a3f-9edc-c2e34f502284', '2025-02-26 16:42:18', NULL);
INSERT INTO tb_post (id, user_id, caption, image_url, created_at, updated_at) VALUES(28, 1, 'TEssss', 'https://firebasestorage.googleapis.com/v0/b/instagram-clone-dc576.firebasestorage.app/o/images%2F1740563156216.png?alt=media&token=e5edcffe-2175-4929-bdad-ed2bc0b24855', '2025-02-26 16:46:03', NULL);
INSERT INTO tb_post (id, user_id, caption, image_url, created_at, updated_at) VALUES(29, 1, 'Hello', 'https://firebasestorage.googleapis.com/v0/b/instagram-clone-dc576.firebasestorage.app/o/images%2F1740563263790.png?alt=media&token=582b26ec-04f0-4167-b1a2-e7401547691e', '2025-02-26 16:47:50', NULL);
INSERT INTO tb_post (id, user_id, caption, image_url, created_at, updated_at) VALUES(30, 1, 'Hello', 'https://firebasestorage.googleapis.com/v0/b/instagram-clone-dc576.firebasestorage.app/o/images%2F1740567718800.png?alt=media&token=f4941548-02a7-4ab7-9050-f432b5c758c2', '2025-02-26 18:02:03', NULL);
INSERT INTO tb_post (id, user_id, caption, image_url, created_at, updated_at) VALUES(31, 4, 'Wht is this', 'https://firebasestorage.googleapis.com/v0/b/instagram-clone-dc576.firebasestorage.app/o/images%2F1740584279012.png?alt=media&token=cb9f2fe5-2893-4776-b93d-bf979abd786e', '2025-02-26 22:38:06', NULL);
INSERT INTO tb_post (id, user_id, caption, image_url, created_at, updated_at) VALUES(32, 1, 'Hello', 'https://firebasestorage.googleapis.com/v0/b/instagram-clone-dc576.firebasestorage.app/o/images%2F1740587084093.png?alt=media&token=a52ab7f5-3cec-411b-ad9b-deb9f3f14662', '2025-02-26 23:24:51', NULL);
INSERT INTO tb_post (id, user_id, caption, image_url, created_at, updated_at) VALUES(33, 1, 'ini baru', 'https://firebasestorage.googleapis.com/v0/b/instagram-clone-dc576.firebasestorage.app/o/images%2F1740587405578.png?alt=media&token=7a231a6e-ebed-4f53-91ae-7357d4503bba', '2025-02-26 23:30:12', NULL);