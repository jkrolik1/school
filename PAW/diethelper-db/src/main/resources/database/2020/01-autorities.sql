--liquibase formatted sql

--changeset root:1
CREATE TABLE `authorities` (
  `username` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `authority` varchar(50) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--changeset root:2
INSERT INTO `authorities` (`username`, `authority`) VALUES
('test', 'ROLE_USER'),
('test1', 'ROLE_USER'),
('user', 'ROLE_USER');

--changeset root:3
ALTER TABLE `authorities`
  ADD UNIQUE KEY `ix_auth_username` (`username`,`authority`);