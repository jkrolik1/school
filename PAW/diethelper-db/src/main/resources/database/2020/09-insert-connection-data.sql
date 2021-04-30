--liquibase formatted sql

--changeset root:1
INSERT INTO `healthconditions` (`healthconditionsId`, `MealmealId`, `NutritionalValuenutritionalValueId`) VALUES
(1, 3, 1),
(2, 4, 1);

--changeset root:2
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

--changeset root:3
INSERT INTO `seasoning` (`seasoningId`, `MealmealId`, `SpicesspiceId`) VALUES
(1, 2, 2),
(2, 2, 1),
(3, 2, 3),
(4, 2, 4),
(5, 3, 2),
(6, 4, 2),
(7, 4, 6),
(8, 4, 7);