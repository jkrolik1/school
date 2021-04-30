--liquibase formatted sql

--changeset root:1
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

--changeset root:2
INSERT INTO `meal` (`mealId`, `name`, `category`, `flavor`, `difficultyOfCooking`, `calories`, `carbohydrates`, `proteins`, `fats`, `isHealthy`, `preparation`) VALUES
(1, 'Wegańska chałka', 'Śniadanie', 'Słodki', 'Średni', 154, 0, 0, 0, 1, NULL),
(2, 'ZAPIEKANKA WARZYWNA Z BATATEM I CUKINIĄ', 'Kolacja', 'Łagodny', 'Średni', 0, 0, 0, 0, 1, 'Piekarnik nagrzać do 190 stopni C. Batata obrać i pokroić w kostkę. Cukinię umyć i pokroić w nieco większą kostką. Cebulę obrać z zewnętrzych suchych łupin i pokroić na paseczki. Ząbki czosnku pozostawić w łupinkach. Warzywa doprawić pieprzem, oregano i pieprzem cayenne, następnie wymieszać z oliwą (nie solić na tym etapie, bo warzywa puszczą soki). Warzywa ułożyć na blaszce do pieczenia (ok. 20 x 30 cm) lub naczyniu żaroodpornym i piec przez 30 minut bez przykrycia. Następnie dodać pokrojonego w kostkę pomidora oraz kuleczki mozzarelli i piec jeszcze przez ok. 10 - 15 minut. Przed podaniem można warzywa posolić.'),
(3, 'Muffinki jajeczne ze szpinakiem', 'Kolacja', 'Słodki', 'Łatwy', 113, 2, 10, 7, 1, 'Cebulę pokrój w kosteczkę i podsmaż na patelni z łyżeczką oliwy ciągle mieszając, aby się nie przypaliła, dodaj przeciśnięty przez praskę czosnek i podsmaż jeszcze chwilę. Wrzuć posiekany szpinak i duś, aż szpinak zwiędnie. Dopraw mocno solą, pieprzem i odrobiną gałki muszkatołowej. Ostudź szpinak. Nastaw piekarnik na 180 stopni. Jajka roztrzep widelcem i wymieszaj ze szpinakiem, dodaj rozdrobnioną mozzarellę. Przelej łyżką masę serowo szpinakową do foremek na muffinki - ja użyłam foremek silikonowych. Piecz mini frittaty przez 20 minut.'),
(4, 'Kanapka z awokado i łososiem', 'Śniadanie', NULL, 'Łatwy', 174, 20, 6, 9, 1, 'Awokado zgnieć widelcem, dodaj kilka kropel soku z cytryny, szczyptę soli i pieprzu. Tak przygotowaną pastę rozprowadź na chlebie. Dodaj plasterek łososia. Opcjonalnie, kanapkę możesz oprószyć koperkiem lub pietruszką.'),
(5, 'Zupa meksykańska z nutką chilli', 'Obiad', 'Ostry', 'Średni', 34, 5, 2, 1, 1, 'W garnku, na oliwie zeszklij cebulę, dodaj pokrojone w kostkę papryki. Smaż 3 minuty. Dodaj mięso mielone i bulion warzywny. Gotuj 10 minut. Dodaj fasolę i kukurydzę. Dodaj pomidory w puszcze i przecier pomidorowy. Całość wymieszaj, dopraw do smaku i gotuj, aż papryka będzie miękka i zupa się zagęści.');