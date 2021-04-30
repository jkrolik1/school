--liquibase formatted sql

--changeset root:1
CREATE TABLE `spice` (
  `spiceId` int(10) NOT NULL,
  `name` varchar(266) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--changeset root:3
INSERT INTO `spice` (`spiceId`, `name`) VALUES
(1, 'Ketchup'),
(2, 'Sól'),
(3, 'Ostra papryka'),
(4, 'Oregano'),
(5, 'Pieprz'),
(6, 'Koperek'),
(7, 'Natka pietruszki');
