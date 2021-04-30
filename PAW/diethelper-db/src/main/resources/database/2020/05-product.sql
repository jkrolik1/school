--liquibase formatted sql

--changeset root:1
CREATE TABLE `product` (
  `productId` int(10) NOT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `carbohydrates` int(10) DEFAULT NULL,
  `proteins` int(10) DEFAULT NULL,
  `fats` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--changeset root:2
INSERT INTO `product` (`productId`, `name`, `carbohydrates`, `proteins`, `fats`) VALUES
(1, 'Mąka pszenna 1 łyżka', NULL, NULL, NULL),
(2, 'Napój migdałowy 1 łyżka', NULL, NULL, NULL),
(3, 'Cukier 100g', 100, 0, 0),
(4, 'Dżem morelowy 1 łyżka', NULL, NULL, NULL),
(5, 'Masło orzechowe 10 gram', NULL, NULL, NULL),
(6, 'Papryczka chili - kawałek', NULL, NULL, NULL),
(7, 'Oliwa z oliwek - łyżka', NULL, NULL, NULL),
(8, 'Papryka czerwona', NULL, NULL, NULL),
(9, 'Cebula', NULL, NULL, NULL),
(10, 'Bulion szklanka', NULL, NULL, NULL),
(11, 'Drobiowe mięso mielone 100g', NULL, NULL, NULL),
(12, 'Koncentrat pomidorowy 1 łyżka', NULL, NULL, NULL),
(13, 'Czerwona fasola 100g', NULL, NULL, NULL),
(14, 'Pomidory 100g', NULL, NULL, NULL),
(15, 'Kukurydza 100g', NULL, NULL, NULL),
(16, 'Bataty 100g', NULL, NULL, NULL),
(17, 'Cukinia 100g', NULL, NULL, NULL),
(18, 'Czosnek ząbek', NULL, NULL, NULL),
(19, 'Mozzarella 25g', NULL, NULL, NULL),
(20, 'Jajko kurze', 0, 6, 5),
(21, 'Szpinak', 1, 1, NULL),
(22, 'Awokado', NULL, NULL, NULL),
(23, 'Chleb żytni razowy kromka', NULL, NULL, NULL),
(24, 'Wędzony łosoś plaster', NULL, NULL, NULL),
(25, 'Sok z cytryny łyżeczka', NULL, NULL, NULL);