package com.diethelper.db.diethelperdb.model;

import javax.persistence.*;

@Entity
@Table(name = "Nutrients")
public class Nutrients {
    @Id
    @GeneratedValue
    @Column(name = "nutrientsId")
    private Integer nutrientsId;
    @Column(name = "name")
    private String name;

    public Nutrients() {
    }

    public Nutrients(Integer nutrientsId, String name) {
        this.nutrientsId = nutrientsId;
        this.name = name;
    }

    public Nutrients(String name) {
        this.name = name;
    }

    public Integer getNutrientsId() {
        return nutrientsId;
    }

    public void setNutrientsId(Integer nutrientsId) {
        this.nutrientsId = nutrientsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
