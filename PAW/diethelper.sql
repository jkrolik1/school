-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 29 Kwi 2021, 20:36
-- Wersja serwera: 10.4.18-MariaDB
-- Wersja PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `diethelper`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `authority` varchar(50) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('test', 'ROLE_USER'),
('test1', 'ROLE_USER'),
('user', 'ROLE_USER');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `healthconditions`
--

CREATE TABLE `healthconditions` (
  `healthconditionsId` int(11) NOT NULL,
  `MealmealId` int(10) NOT NULL,
  `NutritionalValuenutritionalValueId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `healthconditions`
--

INSERT INTO `healthconditions` (`healthconditionsId`, `MealmealId`, `NutritionalValuenutritionalValueId`) VALUES
(1, 3, 1),
(2, 4, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(51);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `meal`
--

CREATE TABLE `meal` (
  `mealId` int(10) NOT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `category` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `flavor` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `difficultyOfCooking` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `calories` int(10) DEFAULT NULL,
  `carbohydrates` int(10) DEFAULT NULL,
  `proteins` int(10) DEFAULT NULL,
  `fats` int(10) DEFAULT NULL,
  `isHealthy` tinyint(1) DEFAULT NULL,
  `preparation` varchar(1000) COLLATE utf8_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `meal`
--

INSERT INTO `meal` (`mealId`, `name`, `category`, `flavor`, `difficultyOfCooking`, `calories`, `carbohydrates`, `proteins`, `fats`, `isHealthy`, `preparation`) VALUES
(1, 'Wegańska chałka', 'Śniadanie', 'Słodki', 'Średni', 154, 0, 0, 0, 1, NULL),
(2, 'ZAPIEKANKA WARZYWNA Z BATATEM I CUKINIĄ', 'Kolacja', 'Łagodny', 'Średni', 0, 0, 0, 0, 1, 'Piekarnik nagrzać do 190 stopni C. Batata obrać i pokroić w kostkę. Cukinię umyć i pokroić w nieco większą kostką. Cebulę obrać z zewnętrzych suchych łupin i pokroić na paseczki. Ząbki czosnku pozostawić w łupinkach. Warzywa doprawić pieprzem, oregano i pieprzem cayenne, następnie wymieszać z oliwą (nie solić na tym etapie, bo warzywa puszczą soki). Warzywa ułożyć na blaszce do pieczenia (ok. 20 x 30 cm) lub naczyniu żaroodpornym i piec przez 30 minut bez przykrycia. Następnie dodać pokrojonego w kostkę pomidora oraz kuleczki mozzarelli i piec jeszcze przez ok. 10 - 15 minut. Przed podaniem można warzywa posolić.'),
(3, 'Muffinki jajeczne ze szpinakiem', 'Kolacja', 'Słodki', 'Łatwy', 113, 2, 10, 7, 1, 'Cebulę pokrój w kosteczkę i podsmaż na patelni z łyżeczką oliwy ciągle mieszając, aby się nie przypaliła, dodaj przeciśnięty przez praskę czosnek i podsmaż jeszcze chwilę. Wrzuć posiekany szpinak i duś, aż szpinak zwiędnie. Dopraw mocno solą, pieprzem i odrobiną gałki muszkatołowej. Ostudź szpinak. Nastaw piekarnik na 180 stopni. Jajka roztrzep widelcem i wymieszaj ze szpinakiem, dodaj rozdrobnioną mozzarellę. Przelej łyżką masę serowo szpinakową do foremek na muffinki - ja użyłam foremek silikonowych. Piecz mini frittaty przez 20 minut.'),
(4, 'Kanapka z awokado i łososiem', 'Śniadanie', NULL, 'Łatwy', 174, 20, 6, 9, 1, 'Awokado zgnieć widelcem, dodaj kilka kropel soku z cytryny, szczyptę soli i pieprzu. Tak przygotowaną pastę rozprowadź na chlebie. Dodaj plasterek łososia. Opcjonalnie, kanapkę możesz oprószyć koperkiem lub pietruszką.'),
(5, 'Zupa meksykańska z nutką chilli', 'Obiad', 'Ostry', 'Średni', 34, 5, 2, 1, 1, 'W garnku, na oliwie zeszklij cebulę, dodaj pokrojone w kostkę papryki. Smaż 3 minuty. Dodaj mięso mielone i bulion warzywny. Gotuj 10 minut. Dodaj fasolę i kukurydzę. Dodaj pomidory w puszcze i przecier pomidorowy. Całość wymieszaj, dopraw do smaku i gotuj, aż papryka będzie miękka i zupa się zagęści.');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `nutrients`
--

CREATE TABLE `nutrients` (
  `nutritionalValueId` int(10) NOT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `nutrientsId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `nutrients`
--

INSERT INTO `nutrients` (`nutritionalValueId`, `name`, `nutrientsId`) VALUES
(1, 'Błonnik', 0);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `preparation`
--

CREATE TABLE `preparation` (
  `preparationId` int(11) NOT NULL,
  `MealmealId` int(10) NOT NULL,
  `ProductproductId` int(10) NOT NULL,
  `productAmount` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `preparation`
--

INSERT INTO `preparation` (`preparationId`, `MealmealId`, `ProductproductId`, `productAmount`) VALUES
(1, 1, 3, 1),
(2, 1, 4, 4),
(3, 1, 5, 6),
(4, 5, 6, 1),
(7, 5, 9, 2),
(10, 5, 7, 1),
(11, 5, 8, 2),
(12, 5, 14, 4),
(13, 5, 10, 4),
(14, 5, 11, 1),
(15, 5, 12, 1),
(16, 5, 13, 2),
(17, 5, 15, 1),
(18, 2, 9, 1),
(19, 2, 16, 3),
(20, 2, 17, 3),
(21, 2, 7, 2),
(22, 2, 19, 5),
(23, 2, 14, 1),
(24, 2, 18, 2),
(25, 3, 20, 1),
(26, 3, 21, 1),
(27, 3, 19, 2),
(28, 3, 9, 1),
(29, 3, 18, 1),
(30, 3, 7, 1),
(31, 4, 22, 1),
(32, 4, 23, 1),
(33, 4, 24, 1),
(34, 4, 25, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `product`
--

CREATE TABLE `product` (
  `productId` int(10) NOT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `carbohydrates` int(10) DEFAULT NULL,
  `proteins` int(10) DEFAULT NULL,
  `fats` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `product`
--

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

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `seasoning`
--

CREATE TABLE `seasoning` (
  `seasoningId` int(11) NOT NULL,
  `MealmealId` int(10) NOT NULL,
  `SpicesspiceId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `seasoning`
--

INSERT INTO `seasoning` (`seasoningId`, `MealmealId`, `SpicesspiceId`) VALUES
(1, 2, 2),
(2, 2, 1),
(3, 2, 3),
(4, 2, 4),
(5, 3, 2),
(6, 4, 2),
(7, 4, 6),
(8, 4, 7);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `spice`
--

CREATE TABLE `spice` (
  `spiceId` int(10) NOT NULL,
  `name` varchar(266) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `spice`
--

INSERT INTO `spice` (`spiceId`, `name`) VALUES
(1, 'Ketchup'),
(2, 'Sól'),
(3, 'Ostra papryka'),
(4, 'Oregano'),
(5, 'Pieprz'),
(6, 'Koperek'),
(7, 'Natka pietruszki');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `username` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_polish_ci NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('test', '{bcrypt}$2a$10$p2R6f4VEAtW2rTd4CEw8Ne/y97pcuwli.ab2FKcVU5Q97RwcTG8yK', 1),
('test1', '{bcrypt}$2a$10$Md.xiGptxjBmPcXQhmCfc.qek13U.8pyeHFDRYnfjn3l/snGsS9/S', 1),
('user', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a', 1);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `authorities`
--
ALTER TABLE `authorities`
  ADD UNIQUE KEY `ix_auth_username` (`username`,`authority`);

--
-- Indeksy dla tabeli `healthconditions`
--
ALTER TABLE `healthconditions`
  ADD PRIMARY KEY (`healthconditionsId`),
  ADD KEY `MealmealId` (`MealmealId`),
  ADD KEY `NutritionalValuenutritionalValueId` (`NutritionalValuenutritionalValueId`);

--
-- Indeksy dla tabeli `meal`
--
ALTER TABLE `meal`
  ADD PRIMARY KEY (`mealId`);

--
-- Indeksy dla tabeli `nutrients`
--
ALTER TABLE `nutrients`
  ADD PRIMARY KEY (`nutritionalValueId`);

--
-- Indeksy dla tabeli `preparation`
--
ALTER TABLE `preparation`
  ADD PRIMARY KEY (`preparationId`),
  ADD KEY `MealmealId` (`MealmealId`),
  ADD KEY `ProductproductId` (`ProductproductId`);

--
-- Indeksy dla tabeli `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productId`);

--
-- Indeksy dla tabeli `seasoning`
--
ALTER TABLE `seasoning`
  ADD PRIMARY KEY (`seasoningId`),
  ADD KEY `SpiceOgr` (`SpicesspiceId`),
  ADD KEY `MealmealId` (`MealmealId`);

--
-- Indeksy dla tabeli `spice`
--
ALTER TABLE `spice`
  ADD PRIMARY KEY (`spiceId`);

--
-- Indeksy dla tabeli `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `healthconditions`
--
ALTER TABLE `healthconditions`
  MODIFY `healthconditionsId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT dla tabeli `meal`
--
ALTER TABLE `meal`
  MODIFY `mealId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT dla tabeli `nutrients`
--
ALTER TABLE `nutrients`
  MODIFY `nutritionalValueId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `preparation`
--
ALTER TABLE `preparation`
  MODIFY `preparationId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT dla tabeli `product`
--
ALTER TABLE `product`
  MODIFY `productId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT dla tabeli `seasoning`
--
ALTER TABLE `seasoning`
  MODIFY `seasoningId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT dla tabeli `spice`
--
ALTER TABLE `spice`
  MODIFY `spiceId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Ograniczenia dla tabeli `healthconditions`
--
ALTER TABLE `healthconditions`
  ADD CONSTRAINT `healthconditions_ibfk_1` FOREIGN KEY (`MealmealId`) REFERENCES `meal` (`mealId`),
  ADD CONSTRAINT `healthconditions_ibfk_2` FOREIGN KEY (`NutritionalValuenutritionalValueId`) REFERENCES `nutrients` (`nutritionalValueId`);

--
-- Ograniczenia dla tabeli `preparation`
--
ALTER TABLE `preparation`
  ADD CONSTRAINT `preparation_ibfk_1` FOREIGN KEY (`MealmealId`) REFERENCES `meal` (`mealId`),
  ADD CONSTRAINT `preparation_ibfk_2` FOREIGN KEY (`ProductproductId`) REFERENCES `product` (`productId`);

--
-- Ograniczenia dla tabeli `seasoning`
--
ALTER TABLE `seasoning`
  ADD CONSTRAINT `SpiceOgr` FOREIGN KEY (`SpicesspiceId`) REFERENCES `spice` (`spiceId`),
  ADD CONSTRAINT `seasoning_ibfk_1` FOREIGN KEY (`MealmealId`) REFERENCES `meal` (`mealId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
