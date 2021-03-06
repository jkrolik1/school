-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 17 Cze 2021, 18:01
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
-- Struktura tabeli dla tabeli `databasechangelog`
--

CREATE TABLE `databasechangelog` (
  `ID` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `AUTHOR` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `FILENAME` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) COLLATE utf8_polish_ci NOT NULL,
  `MD5SUM` varchar(35) COLLATE utf8_polish_ci DEFAULT NULL,
  `DESCRIPTION` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `COMMENTS` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `TAG` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `LIQUIBASE` varchar(20) COLLATE utf8_polish_ci DEFAULT NULL,
  `CONTEXTS` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `LABELS` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) COLLATE utf8_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `databasechangelog`
--

INSERT INTO `databasechangelog` (`ID`, `AUTHOR`, `FILENAME`, `DATEEXECUTED`, `ORDEREXECUTED`, `EXECTYPE`, `MD5SUM`, `DESCRIPTION`, `COMMENTS`, `TAG`, `LIQUIBASE`, `CONTEXTS`, `LABELS`, `DEPLOYMENT_ID`) VALUES
('1', 'root', 'database/2020/01-autorities.sql', '2021-05-04 17:40:57', 1, 'EXECUTED', '8:ea4e48f1f7ed44e01c0c7f3bb53d2400', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('2', 'root', 'database/2020/01-autorities.sql', '2021-05-04 17:40:57', 2, 'EXECUTED', '8:797257a960bf809832393318946c76f9', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('3', 'root', 'database/2020/01-autorities.sql', '2021-05-04 17:40:58', 3, 'EXECUTED', '8:3560e3f36df655a51dd98edc308b55fa', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('1', 'root', 'database/2020/02-hibernate-sequence.sql', '2021-05-04 17:40:58', 4, 'EXECUTED', '8:637d58ba4c44b0037ce155436475c81b', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('2', 'root', 'database/2020/02-hibernate-sequence.sql', '2021-05-04 17:40:58', 5, 'EXECUTED', '8:e7a5a53c30fbab35cc3270680930d29f', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('1', 'root', 'database/2020/03-users.sql', '2021-05-04 17:40:58', 6, 'EXECUTED', '8:2220263ab30bfd7d7a58bf06c28a8a7c', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('2', 'root', 'database/2020/03-users.sql', '2021-05-04 17:40:58', 7, 'EXECUTED', '8:5ce258d4b116643bc88b2c8f9c81cce1', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('1', 'root', 'database/2020/04-meal.sql', '2021-05-04 17:40:58', 8, 'EXECUTED', '8:c3086962896ed5df27827a06773d4e74', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('2', 'root', 'database/2020/04-meal.sql', '2021-05-04 17:40:58', 9, 'EXECUTED', '8:9f63e9c6414dcfcadefe190910b8c6e0', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('1', 'root', 'database/2020/05-product.sql', '2021-05-04 17:40:58', 10, 'EXECUTED', '8:c5fed94c9eef9d4505482a63065aa0f4', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('2', 'root', 'database/2020/05-product.sql', '2021-05-04 17:40:58', 11, 'EXECUTED', '8:29152c802f5d847f5291a7e872d0fa20', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('1', 'root', 'database/2020/06-spice.sql', '2021-05-04 17:40:58', 12, 'EXECUTED', '8:54b9923a7cf4a0c7a6150ce9527a7a69', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('3', 'root', 'database/2020/06-spice.sql', '2021-05-04 17:40:58', 13, 'EXECUTED', '8:27a2054783afb7ff926088faf9df0c81', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('1', 'root', 'database/2020/07-nutrients.sql', '2021-05-04 17:40:58', 14, 'EXECUTED', '8:37069aa03a4f1106f4b12f6fcbe13498', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('2', 'root', 'database/2020/07-nutrients.sql', '2021-05-04 17:40:58', 15, 'EXECUTED', '8:ff64eba59ad9796e9e2c833fffa8f616', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('1', 'root', 'database/2020/08-create-connection-tables.sql', '2021-05-04 17:40:58', 16, 'EXECUTED', '8:23d5fe04898925233c00913bd96359de', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('2', 'root', 'database/2020/08-create-connection-tables.sql', '2021-05-04 17:40:58', 17, 'EXECUTED', '8:6a4f0537c4d59076d8f50478281c9195', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('3', 'root', 'database/2020/08-create-connection-tables.sql', '2021-05-04 17:40:58', 18, 'EXECUTED', '8:3a2b187d4bd17525ae0fc2286cfb83ec', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('1', 'root', 'database/2020/09-insert-connection-data.sql', '2021-05-04 17:40:58', 19, 'EXECUTED', '8:f1c5459a667ad756e1b1d4dcd7ea87de', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('2', 'root', 'database/2020/09-insert-connection-data.sql', '2021-05-04 17:40:58', 20, 'EXECUTED', '8:a0f730c690ce0671bf4f44a684cbadf3', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('3', 'root', 'database/2020/09-insert-connection-data.sql', '2021-05-04 17:40:58', 21, 'EXECUTED', '8:a2dd0b1ea1abc6851ef9b4a143905798', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('1', 'root', 'database/2020/10-primarykeys.sql', '2021-05-04 17:40:59', 22, 'EXECUTED', '8:5b4f5622e861bf33b4c45d4c6e2f82d9', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('1', 'root', 'database/2020/11-autoincrement.sql', '2021-05-04 17:40:59', 23, 'EXECUTED', '8:5c3a6e849d32d4543d75bee9d6d1eef0', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('1', 'root', 'database/2020/12-constraints.sql', '2021-05-04 17:40:59', 24, 'EXECUTED', '8:901cb68f59f99cce638a29c875c04f58', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866'),
('1', 'root', 'database/2020/13-files.sql', '2021-05-04 17:40:59', 25, 'EXECUTED', '8:99771622bd96bf885909e15c4f916195', 'sql', '', NULL, '3.10.3', NULL, NULL, '0142857866');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `databasechangeloglock`
--

CREATE TABLE `databasechangeloglock` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `databasechangeloglock`
--

INSERT INTO `databasechangeloglock` (`ID`, `LOCKED`, `LOCKGRANTED`, `LOCKEDBY`) VALUES
(1, b'0', NULL, NULL);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `files`
--

CREATE TABLE `files` (
  `id` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `fileName` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `fileType` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `data` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `files`
--

INSERT INTO `files` (`id`, `fileName`, `fileType`, `data`) VALUES
('4608eafa-2f37-4557-bbfb-de9f1658d816', 'remove-button.png', 'image/png', 0x89504e470d0a1a0a0000000d49484452000000100000001008060000001ff3ff610000000473424954080808087c0864880000000970485973000007eb000007eb01eb84ffc90000001974455874536f667477617265007777772e696e6b73636170652e6f72679bee3c1a000000a849444154388dad93510dc3300c449fc7a11442600c026328c26045530255610cc006a00cd25ff7c7a9b228ab34b9964e722cdfc997c4a2aad421220178007703c0cb30a9eae78ba0aa98880009d800fd81cd7ae4e055e4e584d86229224520fd412e48c57ee88cfd067275ce566bed0480b1431e8068c46cf9d0117902cc4d3103d1c68b4d9e9bde1960edf83b444ec80aac372e08b78511e725fa9ed1fd912ef9ca9e6512ef3aef63f5eaad261231ec0000000049454e44ae426082),
('998e4e7b-2298-4208-9013-55237f0e8466', 'remove-button.png', 'image/png', 0x89504e470d0a1a0a0000000d49484452000000100000001008060000001ff3ff610000000473424954080808087c0864880000000970485973000007eb000007eb01eb84ffc90000001974455874536f667477617265007777772e696e6b73636170652e6f72679bee3c1a000000a849444154388dad93510dc3300c449fc7a11442600c026328c26045530255610cc006a00cd25ff7c7a9b228ab34b9964e722cdfc997c4a2aad421220178007703c0cb30a9eae78ba0aa98880009d800fd81cd7ae4e055e4e584d86229224520fd412e48c57ee88cfd067275ce566bed0480b1431e8068c46cf9d0117902cc4d3103d1c68b4d9e9bde1960edf83b444ec80aac372e08b78511e725fa9ed1fd912ef9ca9e6512ef3aef63f5eaad261231ec0000000049454e44ae426082);

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
(56);

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
(5, 'Zupa meksykańska z nutką chilli', 'Obiad', 'Ostry', 'Średni', 34, 5, 2, 1, 1, 'W garnku, na oliwie zeszklij cebulę, dodaj pokrojone w kostkę papryki. Smaż 3 minuty. Dodaj mięso mielone i bulion warzywny. Gotuj 10 minut. Dodaj fasolę i kukurydzę. Dodaj pomidory w puszcze i przecier pomidorowy. Całość wymieszaj, dopraw do smaku i gotuj, aż papryka będzie miękka i zupa się zagęści.'),
(6, 'Omlet wegetariański', 'Śniadanie', 'Słodki', 'Łatwy', NULL, NULL, NULL, NULL, 1, 'Cebulę i czosnek obierz i posiekaj. Pomidorki przekrój na pół, paprykę pokrój w paski. Cebulę i czosnek zeszklij na oliwie. Dodaj pomidorki, paprykę, dopraw przyprawą Knorr, pieprzem, bazylią, oregano i podsmaż. Na koniec wlej ubite jajka. Kiedy omlet się zetnie ostrożnie przewróć na drugą stronę i podsmaż.\r\n\r\n'),
(7, 'Budyń waniliowy ze skrobią oporną', 'Śniadanie', 'Słodki', 'Łatwy', NULL, NULL, NULL, NULL, 1, '1/2 szklanki mleka roślinnego wlej do garnka, dodaj olej kokosowy i cukier waniliowy. Podgrzewaj na wolnym ogniu. Pozostałe mleko wymieszaj dokładnie z mąką ziemniaczaną. Kiedy mleko kokosowe się zagotuje wlej do niego mleko z mąką ziemniaczaną i mieszaj całość dokładnie około 1 minuty. Mleko szybko zgęstnieje w budyń. Zdejmij z ognia. Podawaj z plastrami zielonego banana ( koniecznie zielonego ponieważ zawiera on bardzo dużo skrobi opornej) i ulubionymi owocami.'),
(8, 'Czekoladowe naleśniki z truskawkami', 'Obiad', 'Słodki', 'Łatwy', NULL, NULL, NULL, NULL, 0, 'Do wysokiej miski dodajemy mąkę, mleko, wodę gazowaną, jajko, kakao i szczyptę soli. Miksujemy przez około minutę do momentu połączenia się składników. Miksujemy dokładnie, aby nie było grudek. Smażymy z obu stron na dużej, rozgrzanej patelni. Ja mam patelnię z powierzchnią nieprzywierającą do naleśników, jednak jeśli takiej nie macie to trzeba najpierw wlać odrobinę oleju i rozprowadzić go po powierzchni patelni. Do miski dodajemy mascarpone lub twaróg półtłusty (w przypadku twarogu trzeba go nieco rozdrobnić widelcem lub blenderem). Następnie dodajemy cukier puder (3 łyżeczki), serek homogenizowany waniliowy lub straciatella (300g). Całość mieszamy delikatnie za pomocą łyżki. Naleśniki smarujemy nadzieniem i posypujemy drobno posiekanymi truskawkami. Zwijamy w rulonik lub trójkąty. W małym garnku roztapiamy czekoladę mleczną wraz ze śmietanką kremówką. Mieszamy jedynie do momentu powstania jednolitej polewy czekoladowej. Wierzch dekorujemy polewą czekoladową lub oprószamy cukrem pudr'),
(9, 'Szaszłyki z piekarnika z kurczakiem i boczkiem', 'Obiad', 'Słony', 'Łatwy', NULL, NULL, NULL, NULL, NULL, 'Zaczynamy do zamarynowania mięsa. Piersi z kurczaka kroimy w większą kostkę. W miseczce mieszamy przyprawę do kurczaka, szczyptę papryki słodkiej i ostrej oraz oliwę z oliwek, przeciśnięty przez praskę ząbek czosnku oraz oliwę z oliwek. Do miseczki dodajemy kurczaka i całość mieszamy łyżką lub dłonią. Na długi patyczki do szaszłyków wbijamy pokrojoną w kawałki paprykę (np. zieloną), zwinięty plasterek boczku, plasterek cukinii, cebulę i kurczaka.Czynność powtarzamy np. dwukrotnie. Układamy na tacce do grillowania lub papierze do pieczenia. Wkładamy do piekarnika nagrzanego do temp. 200 stopni. Pieczemy przez ok. 10 minut (góra-dół, bez termoobiegu), a następnie przez 5-10 minut (termoobieg lub funkcja grill). Kontroluj długość pieczenia, aby szaszłyki się nie spaliły. Smacznego! Szaszłyki z piekarnika można zaserwować wraz z moją sprawdzoną sałatkę grillową. Będzie tu pasować idealnie! Jeżeli dodatkowo planujesz przygotować również karkówkę z grilla to polecam wypróbować tą smaczną i s'),
(10, 'Sałatka z makaronem, awokado i piersią z kurczaka', 'Kolacja', 'Słony', 'Łatwy', 620, 52, 32, 34, 1, 'Pierś z kurczaka przygotowujemy zgodnie z przepisem na opakowaniu Pomysłu na… Papirus Winiary. Mix sałat płuczemy, odsączamy na sicie. Pomidorki myjemy, przecinamy na ćwiartki. Awokado obieramy ze skóry, kroimy w drobną kostkę. Olej dokładnie mieszamy z wodą, miodem, musztardą i octem winnym. Doprawiamy do smaku solą i pieprzem. Awokado, pomidorki i makaron dodajemy do sałaty. Polewamy sosem i dokładnie mieszamy. Przybieramy pokrojoną w paski piersią kurczaka. Posypujemy odrobiną świeżo mielonego pieprzu.'),
(11, 'Omlet ze szpinakiem, kurkami i startym żółtym serem', 'Kolacja', 'Łagodny', 'Łatwy', 390, 14, 25, 25, 1, 'Grzyby oczyść pędzelkiem, pokrój. Jajka wbij do miseczki, dodaj mąkę, ser, pieprz. Całość dobrze wymieszaj. Rozgrzej oliwę na patelni, dodaj posiekaną cebulę z MAGGI. Kiedy cebula się zeszkli dodaj kurki. Całość podsmażaj do momentu, aż grzyby i cebula delikatnie się przyrumienią. Następnie dodaj szpinak, podsmaż chwilę, aż zmięknie. Wlej na patelnię jajka, przykryj pokrywką. Omlet będzie gotowy jak góra się zetnie po około 4-5 minutach na bardzo małym ogniu.\r\n\r\n\r\n');

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
(34, 4, 25, 1),
(49, 6, 20, 8),
(50, 6, 26, 1),
(51, 6, 14, 2),
(52, 6, 8, 2),
(53, 6, 9, 1),
(54, 6, 27, 1),
(55, 6, 7, 2),
(56, 7, 28, 2),
(57, 7, 29, 1),
(58, 7, 30, 2),
(59, 8, 1, 10),
(60, 8, 31, 1),
(61, 8, 32, 3),
(62, 8, 28, 1),
(63, 8, 20, 2),
(64, 9, 36, 4),
(65, 9, 7, 2),
(66, 9, 18, 1),
(67, 9, 35, 3),
(68, 9, 33, 2),
(69, 9, 34, 2),
(70, 9, 17, 2);

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
(25, 'Sok z cytryny łyżeczka', NULL, NULL, NULL),
(26, 'Przyprawa knorr szczypta', NULL, NULL, NULL),
(27, 'Bazylia 0.5 łyżeczki', NULL, NULL, NULL),
(28, 'Mleko roślinne szklanka', NULL, NULL, NULL),
(29, 'Mąka ziemniaczana', NULL, NULL, NULL),
(30, 'Cukier waniliowy', NULL, NULL, NULL),
(31, 'Woda gazowana szklanka', 0, 0, 0),
(32, 'Ciemne kakao łyżeczka', NULL, NULL, NULL),
(33, 'Papryka zielona', NULL, NULL, NULL),
(34, 'Czerwona cebula', NULL, NULL, NULL),
(35, 'Boczek 50g', NULL, NULL, NULL),
(36, 'Pierś z kurczaka 100g', NULL, NULL, NULL);

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
(8, 4, 7),
(50, 6, 4),
(51, 6, 5),
(52, 8, 2),
(53, 9, 9),
(54, 9, 10),
(55, 9, 11);

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
(7, 'Natka pietruszki'),
(9, 'Przyprawa do kurczaka'),
(10, 'Papryka ostra'),
(11, 'Papryka słodka');

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
-- Indeksy dla tabeli `databasechangeloglock`
--
ALTER TABLE `databasechangeloglock`
  ADD PRIMARY KEY (`ID`);

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
-- AUTO_INCREMENT dla tabeli `meal`
--
ALTER TABLE `meal`
  MODIFY `mealId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT dla tabeli `nutrients`
--
ALTER TABLE `nutrients`
  MODIFY `nutritionalValueId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `preparation`
--
ALTER TABLE `preparation`
  MODIFY `preparationId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- AUTO_INCREMENT dla tabeli `product`
--
ALTER TABLE `product`
  MODIFY `productId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT dla tabeli `seasoning`
--
ALTER TABLE `seasoning`
  MODIFY `seasoningId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT dla tabeli `spice`
--
ALTER TABLE `spice`
  MODIFY `spiceId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

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
