package com.diethelper.db.diethelperdb.model;

import javax.persistence.*;

@Entity
@Table(name = "healthconditions")
public class HealthConditions {
    @Id
    @GeneratedValue
    @Column(name = "healthconditionsId ")
    private Integer healthconditionsId ;
    @Column(name = "MealmealId")
    private Integer MealmealId;
    @Column(name = "NutritionalValuenutritionalValueId")
    private Integer NutritionalValuenutritionalValueId;

    @ManyToOne()
    @JoinColumn(name="mealId")
    private Meal meal;

    public HealthConditions() {
    }

    public HealthConditions(Integer healthconditionsId, Integer mealmealId, Integer nutritionalValuenutritionalValueId) {
        this.healthconditionsId = healthconditionsId;
        MealmealId = mealmealId;
        NutritionalValuenutritionalValueId = nutritionalValuenutritionalValueId;
    }

    public Integer getHealthconditionsId() {
        return healthconditionsId;
    }

    public void setHealthconditionsId(Integer healthconditionsId) {
        this.healthconditionsId = healthconditionsId;
    }

    public Integer getMealmealId() {
        return MealmealId;
    }

    public void setMealmealId(Integer mealmealId) {
        MealmealId = mealmealId;
    }

    public Integer getNutritionalValuenutritionalValueId() {
        return NutritionalValuenutritionalValueId;
    }

    public void setNutritionalValuenutritionalValueId(Integer nutritionalValuenutritionalValueId) {
        NutritionalValuenutritionalValueId = nutritionalValuenutritionalValueId;
    }
}
