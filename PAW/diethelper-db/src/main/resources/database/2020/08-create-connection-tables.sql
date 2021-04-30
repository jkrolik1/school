--liquibase formatted sql

--changeset root:1
CREATE TABLE `healthconditions` (
  `healthconditionsId` int(11) NOT NULL,
  `MealmealId` int(10) NOT NULL,
  `NutritionalValuenutritionalValueId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--changeset root:2
CREATE TABLE `preparation` (
  `preparationId` int(11) NOT NULL,
  `MealmealId` int(10) NOT NULL,
  `ProductproductId` int(10) NOT NULL,
  `productAmount` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--changeset root:3
CREATE TABLE `seasoning` (
  `seasoningId` int(11) NOT NULL,
  `MealmealId` int(10) NOT NULL,
  `SpicesspiceId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;