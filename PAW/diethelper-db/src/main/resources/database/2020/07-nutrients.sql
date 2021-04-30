--liquibase formatted sql

--changeset root:1
CREATE TABLE `nutrients` (
  `nutritionalValueId` int(10) NOT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `nutrientsId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--changeset root:2
INSERT INTO `nutrients` (`nutritionalValueId`, `name`, `nutrientsId`) VALUES
(1, 'Błonnik', 0);