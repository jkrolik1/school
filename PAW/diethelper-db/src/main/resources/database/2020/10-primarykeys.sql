--liquibase formatted sql

--changeset root:1
ALTER TABLE `healthconditions`
  ADD PRIMARY KEY (`healthconditionsId`),
  ADD KEY `MealmealId` (`MealmealId`),
  ADD KEY `NutritionalValuenutritionalValueId` (`NutritionalValuenutritionalValueId`);

ALTER TABLE `meal`
  ADD PRIMARY KEY (`mealId`);

ALTER TABLE `nutrients`
  ADD PRIMARY KEY (`nutritionalValueId`);

ALTER TABLE `preparation`
  ADD PRIMARY KEY (`preparationId`),
  ADD KEY `MealmealId` (`MealmealId`),
  ADD KEY `ProductproductId` (`ProductproductId`);

ALTER TABLE `product`
  ADD PRIMARY KEY (`productId`);

ALTER TABLE `seasoning`
  ADD PRIMARY KEY (`seasoningId`),
  ADD KEY `SpiceOgr` (`SpicesspiceId`),
  ADD KEY `MealmealId` (`MealmealId`);

ALTER TABLE `spice`
  ADD PRIMARY KEY (`spiceId`);

ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);