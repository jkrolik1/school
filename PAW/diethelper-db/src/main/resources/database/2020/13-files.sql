--liquibase formatted sql

--changeset root:1
CREATE TABLE `files` (
  `id` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `fileName` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `fileType` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `data` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;