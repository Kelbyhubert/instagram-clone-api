CREATE TABLE `tb_user`(
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(255) UNIQUE NOT NULL,
    `email` VARCHAR(255) UNIQUE NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `phone_number` VARCHAR(20) NOT NULL,
    `profile_picture` TEXT,
    `create_date` DATETIME DEFAULT CURRENT_TIMESTAMP,
    `update_date` DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
);


INSERT INTO tb_user (id, username, email, password, phone_number, profile_picture, create_date, update_date) VALUES(1, 'kelby', 'hubert.kelby@gmail.com', '$2a$10$X4ReBnNL82IrR3xHl38Aeu/EaCNGwOBHEy5npiCjMFLnpSSXZS0nu', '0812731288123', 'https://i.pinimg.com/474x/54/f4/b5/54f4b55a59ff9ddf2a2655c7f35e4356.jpg', '2025-02-23 21:13:53', '2025-02-26 19:25:00');
INSERT INTO tb_user (id, username, email, password, phone_number, profile_picture, create_date, update_date) VALUES(2, 'ray', 'ray@gmail.com', '$2a$10$UryqlNCHmvAYxDIot/r0SeYvJaOEyDOM0aon/L4UcstPd39xVAsba', '0812731288122', 'https://i2-prod.dailyrecord.co.uk/incoming/article14559744.ece/ALTERNATES/s1200c/0_Steve-Head-Marathon.jpg', '2025-02-25 12:43:01', '2025-02-26 19:25:18');
INSERT INTO tb_user (id, username, email, password, phone_number, profile_picture, create_date, update_date) VALUES(4, 'Hello', 'Hello@gmail.com', '$2a$10$e74l33iCcMOWmKEHDtq44..P6fVIa5TUN720ZMte2eYIvW37b/dSi', '0819281921817', NULL, '2025-02-26 22:35:38', NULL);
INSERT INTO tb_user (id, username, email, password, phone_number, profile_picture, create_date, update_date) VALUES(5, 'Cleved', 'cleved@gmail.com', '$2a$10$NZfWo4aehiVSoufEfh.VVemr6FC0cUiVjGbg/9qQF36mpGwtY/Ghe', '09812817218127', NULL, '2025-02-26 23:42:20', NULL);