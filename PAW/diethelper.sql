-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 04 Kwi 2021, 19:04
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
-- Struktura tabeli dla tabeli `healthconditions`
--

CREATE TABLE `healthconditions` (
  `healthconditionsId` int(11) NOT NULL,
  `MealmealId` int(10) NOT NULL,
  `NutritionalValuenutritionalValueId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

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
(1);

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
(1, 'Wegańska chałka', 'Śniadanie', 'Słodki', 'Średni', 154, NULL, NULL, NULL, 1, NULL),
(5, 'Zupa meksykańska z nutką chilli', 'Obiad', 'Ostry', 'Średni', 34, 5, 2, 1, 1, 'W garnku, na oliwie zeszklij cebulę, dodaj pokrojone w kostkę papryki. Smaż 3 minuty. Dodaj mięso mielone i bulion warzywny. Gotuj 10 minut. Dodaj fasolę i kukurydzę. Dodaj pomidory w puszcze i przecier pomidorowy. Całość wymieszaj, dopraw do smaku i gotuj, aż papryka będzie miękka i zupa się zagęści.');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `nutritionalvalue`
--

CREATE TABLE `nutritionalvalue` (
  `nutritionalValueId` int(10) NOT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

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
(17, 5, 15, 1);

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
(15, 'Kukurydza 100g', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `seasoning`
--

CREATE TABLE `seasoning` (
  `seasoningId` int(11) NOT NULL,
  `MealmealId` int(10) NOT NULL,
  `SpicesspiceId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `spice`
--

CREATE TABLE `spice` (
  `spiceId` int(10) NOT NULL,
  `name` varchar(266) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Indeksy dla zrzutów tabel
--

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
-- Indeksy dla tabeli `nutritionalvalue`
--
ALTER TABLE `nutritionalvalue`
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
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `healthconditions`
--
ALTER TABLE `healthconditions`
  MODIFY `healthconditionsId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `meal`
--
ALTER TABLE `meal`
  MODIFY `mealId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT dla tabeli `nutritionalvalue`
--
ALTER TABLE `nutritionalvalue`
  MODIFY `nutritionalValueId` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `preparation`
--
ALTER TABLE `preparation`
  MODIFY `preparationId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT dla tabeli `product`
--
ALTER TABLE `product`
  MODIFY `productId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT dla tabeli `seasoning`
--
ALTER TABLE `seasoning`
  MODIFY `seasoningId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `spice`
--
ALTER TABLE `spice`
  MODIFY `spiceId` int(10) NOT NULL AUTO_INCREMENT;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `healthconditions`
--
ALTER TABLE `healthconditions`
  ADD CONSTRAINT `healthconditions_ibfk_1` FOREIGN KEY (`MealmealId`) REFERENCES `meal` (`mealId`),
  ADD CONSTRAINT `healthconditions_ibfk_2` FOREIGN KEY (`NutritionalValuenutritionalValueId`) REFERENCES `nutritionalvalue` (`nutritionalValueId`);

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
