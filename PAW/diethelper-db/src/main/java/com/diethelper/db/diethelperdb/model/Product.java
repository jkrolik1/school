package com.diethelper.db.diethelperdb.model;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "productId")
    private Integer productId;
    @Column(name = "name")
    private String name;
    @Column(name = "carbohydrates")
    private Integer carbohydrates;
    @Column(name = "proteins")
    private Integer proteins;
    @Column(name = "fats")
    private Integer fats;

    //@OneToMany()
    //@JoinColumn(name="ProductproductId")
    //private Preparation preparationObject;

    public Product() {
    }

    public Product(Integer productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public Product(Integer productId, String name, Integer carbohydrates, Integer proteins, Integer fats) {
        this.productId = productId;
        this.name = name;
        this.carbohydrates = carbohydrates;
        this.proteins = proteins;
        this.fats = fats;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
