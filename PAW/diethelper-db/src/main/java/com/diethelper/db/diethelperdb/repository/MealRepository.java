package com.diethelper.db.diethelperdb.repository;

import com.diethelper.db.diethelperdb.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MealRepository extends JpaRepository<Meal, Integer> {
    //public Optional<Meal> findByCategory(String category);
    public List<Meal> findByCategoryIn(Collection<String> categories);
    public List<Meal> findByFlavorIn(Collection<String> flavors);
    public List<Meal> findByDifficultyOfCookingIn(Collection<String> flavors);
}
