--liquibase formatted sql

--changeset root:1
CREATE TABLE `users` (
  `username` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_polish_ci NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--changeset root:2
INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('test', '{bcrypt}$2a$10$p2R6f4VEAtW2rTd4CEw8Ne/y97pcuwli.ab2FKcVU5Q97RwcTG8yK', 1),
('test1', '{bcrypt}$2a$10$Md.xiGptxjBmPcXQhmCfc.qek13U.8pyeHFDRYnfjn3l/snGsS9/S', 1),
('user', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a', 1);