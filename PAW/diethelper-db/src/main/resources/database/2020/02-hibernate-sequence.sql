--liquibase formatted sql

--changeset root:1
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--changeset root:2
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(51);