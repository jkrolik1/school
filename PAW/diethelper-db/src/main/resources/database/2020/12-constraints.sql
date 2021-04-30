--liquibase formatted sql

--changeset root:1
ALTER TABLE `authorities`
  ADD CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

ALTER TABLE `healthconditions`
  ADD CONSTRAINT `healthconditions_ibfk_1` FOREIGN KEY (`MealmealId`) REFERENCES `meal` (`mealId`),
  ADD CONSTRAINT `healthconditions_ibfk_2` FOREIGN KEY (`NutritionalValuenutritionalValueId`) REFERENCES `nutrients` (`nutritionalValueId`);

ALTER TABLE `preparation`
  ADD CONSTRAINT `preparation_ibfk_1` FOREIGN KEY (`MealmealId`) REFERENCES `meal` (`mealId`),
  ADD CONSTRAINT `preparation_ibfk_2` FOREIGN KEY (`ProductproductId`) REFERENCES `product` (`productId`);

ALTER TABLE `seasoning`
  ADD CONSTRAINT `SpiceOgr` FOREIGN KEY (`SpicesspiceId`) REFERENCES `spice` (`spiceId`),
  ADD CONSTRAINT `seasoning_ibfk_1` FOREIGN KEY (`MealmealId`) REFERENCES `meal` (`mealId`);
COMMIT;