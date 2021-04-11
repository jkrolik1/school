package com.diethelper.db.diethelperdb.model;

import javax.persistence.*;

@Entity
@Table(name = "Spice")

public class Spice {
    @Id
    @GeneratedValue
    @Column(name = "spiceId")
    private Integer spiceId;
    @Column(name = "name")
    private String name;

    public Spice() {
    }

    public Spice(Integer spiceId, String name) {
        this.spiceId = spiceId;
        this.name = name;
    }

    public Spice(String name) {
        this.name = name;
    }

    public Integer getSpiceId() {
        return spiceId;
    }

    public void setSpiceId(Integer spiceId) {
        this.spiceId = spiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
