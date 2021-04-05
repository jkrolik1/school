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
    private String carbohydrates;
    @Column(name = "proteins")
    private String proteins;
    @Column(name = "fats")
    private String fats;

    @OneToMany()
    @JoinColumn(name="ProductproductId")
    private Preparation preparationObject;

    public Product() {
    }

    public Product(Integer productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public Product(Integer productId, String name, String carbohydrates, String proteins, String fats) {
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

    public String getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(String carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public String getProteins() {
        return proteins;
    }

    public void setProteins(String proteins) {
        this.proteins = proteins;
    }

    public String getFats() {
        return fats;
    }

    public void setFats(String fats) {
        this.fats = fats;
    }
}
