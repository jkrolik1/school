package com.diethelper.db.diethelperdb.model;

import javax.persistence.*;

@Entity
@Table(name = "Preparation")
public class Preparation {
    @Id
    @GeneratedValue
    @Column(name = "preparationId")
    private Integer preparationId;
    @Column(name = "MealmealId")
    private Integer MealmealId;
    @Column(name = "ProductproductId")
    private Integer ProductproductId ;
    @Column(name = "productAmount")
    private Integer productAmount;

    @ManyToOne()
    @JoinColumn(name="mealId")
    private Meal meal;

    //@ManyToOne()
    //@JoinColumn(name="productId")
    //private Product product;

    public Preparation() {
    }

    public Preparation(Integer preparationId, Integer mealmealId, Integer productproductId, Integer productAmount) {
        this.preparationId = preparationId;
        MealmealId = mealmealId;
        ProductproductId = productproductId;
        this.productAmount = productAmount;
    }

    public Integer getPreparationId() {
        return preparationId;
    }

    public void setPreparationId(Integer preparationId) {
        this.preparationId = preparationId;
    }

    public Integer getMealmealId() {
        return MealmealId;
    }

    public void setMealmealId(Integer mealmealId) {
        MealmealId = mealmealId;
    }

    public Integer getProductproductId() {
        return ProductproductId;
    }

    public void setProductproductId(Integer productproductId) {
        ProductproductId = productproductId;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }
}