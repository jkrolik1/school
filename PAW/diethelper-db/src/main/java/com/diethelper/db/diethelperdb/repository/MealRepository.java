package com.diethelper.db.diethelperdb.repository;

import com.diethelper.db.diethelperdb.model.Meal;
import com.diethelper.db.diethelperdb.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Integer> {
    List<Meal> findByCategoryIn(Collection<String> categories);
    List<Meal> findByFlavorIn(Collection<String> flavors);
    List<Meal> findByDifficultyOfCookingIn(Collection<String> flavors);

    @Query(value =
            "SELECT meal.mealId, meal.name, meal.category, meal.flavor, meal.difficultyOfCooking, meal.calories, meal.carbohydrates, meal.proteins, meal.fats, meal.isHealthy, meal.preparation " +
            "FROM meal, preparation " +
            "WHERE meal.mealId = MealmealId AND ProductproductId = :productId",
            nativeQuery = true)
    List<Meal> findByProduct(@Param("productId") int id);

    @Query(value =
            "SELECT meal.mealId, meal.name, meal.category, meal.flavor, meal.difficultyOfCooking, meal.calories, meal.carbohydrates, meal.proteins, meal.fats, meal.isHealthy, meal.preparation " +
            "FROM meal, seasoning, spice " +
            "WHERE meal.mealId = seasoning.MealmealId " +
            "AND seasoning.SpicesspiceId = spice.spiceId " +
            "AND spice.name = :spiceName", nativeQuery = true)
    List<Meal> findBySpice(@Param("spiceName") String spiceName);

    @Query(value =
            "SELECT meal.mealId, meal.name, meal.category, meal.flavor, meal.difficultyOfCooking, meal.calories, meal.carbohydrates, meal.proteins, meal.fats, meal.isHealthy, meal.preparation " +
            "FROM meal, nutrients, healthconditions " +
            "WHERE meal.mealId = healthconditions.MealmealId AND " +
            "healthconditions.NutritionalValuenutritionalValueId = nutrients.nutritionalValueId " +
            "AND nutrients.name = :nutrientsName", nativeQuery = true)
    List<Meal> findByNutrients(@Param("nutrientsName") String nutrientsName);


}
