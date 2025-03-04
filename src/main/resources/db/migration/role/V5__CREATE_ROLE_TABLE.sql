CREATE TABLE `tb_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
)


INSERT INTO tb_role (id, name) VALUES(1, 'USER');
INSERT INTO tb_role (id, name) VALUES(2, 'ADMIN');