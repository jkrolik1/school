package com.diethelper.db.diethelperdb.model;

import javax.persistence.*;

@Entity
@Table(name = "Seasoning")
public class Seasoning {
    @Id
    @GeneratedValue
    @Column(name = "seasoningId")
    private Integer seasoningId;
    @Column(name = "MealmealId")
    private Integer MealmealId;
    @Column(name = "SpicesspiceId")
    private Integer SpicesspiceId;

    //@ManyToOne()
    //@JoinColumn(name="mealId")
    //private Meal meal;

    public Seasoning() {
    }

    public Seasoning(Integer seasoningId, Integer mealmealId, Integer spicesspiceId) {
        this.seasoningId = seasoningId;
        MealmealId = mealmealId;
        SpicesspiceId = spicesspiceId;
    }

    public Integer getSeasoningId() {
        return seasoningId;
    }

    public void setSeasoningId(Integer seasoningId) {
        this.seasoningId = seasoningId;
    }

    public Integer getMealmealId() {
        return MealmealId;
    }

    public void setMealmealId(Integer mealmealId) {
        MealmealId = mealmealId;
    }

    public Integer getSpicesspiceId() {
        return SpicesspiceId;
    }

    public void setSpicesspiceId(Integer spicesspiceId) {
        SpicesspiceId = spicesspiceId;
    }
}
