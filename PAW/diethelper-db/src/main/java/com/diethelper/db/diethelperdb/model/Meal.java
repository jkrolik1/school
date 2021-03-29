package com.diethelper.db.diethelperdb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Meal {

    @Id
    @GeneratedValue
    @Column(name = "mealId")
    private Integer mealId;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "flavor")
    private String flavor;
    @Column(name = "difficultyOfCooking")
    private String difficultyOfCooking;
    @Column(name = "calories")
    private Integer calories;
    @Column(name = "carbohydrates")
    private Integer carbohydrates;
    @Column(name = "proteins")
    private Integer proteins;
    @Column(name = "fats")
    private Integer fats;
    @Column(name = "isHealthy")
    private Integer isHealthy;
    @Column(name = "preparation")
    private String preparation;

    public Meal() {
    }

    public Meal(Integer mealId, String name) {
        this.mealId = mealId;
        this.name = name;
    }

    public Meal(Integer mealId, String name, String category, String flavor, String difficultyOfCooking, Integer calories, Integer carbohydrates, Integer proteins, Integer fats, Integer isHealthy, String preparation) {
        this.mealId = mealId;
        this.name = name;
        this.category = category;
        this.flavor = flavor;
        this.difficultyOfCooking = difficultyOfCooking;
        this.calories = calories;
        this.carbohydrates = carbohydrates;
        this.proteins = proteins;
        this.fats = fats;
        this.isHealthy = isHealthy;
        this.preparation = preparation;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getDifficultyOfCooking() {
        return difficultyOfCooking;
    }

    public void setDifficultyOfCooking(String difficultyOfCooking) {
        this.difficultyOfCooking = difficultyOfCooking;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Integer carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Integer getProteins() {
        return proteins;
    }

    public void setProteins(Integer proteins) {
        this.proteins = proteins;
    }

    public Integer getFats() {
        return fats;
    }

    public void setFats(Integer fats) {
        this.fats = fats;
    }

    public Integer getIsHealthy() {
        return isHealthy;
    }

    public void setIsHealthy(Integer isHealthy) {
        this.isHealthy = isHealthy;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }
}
