package com.diethelper.db.diethelperdb.repository;

import com.diethelper.db.diethelperdb.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductRepository  extends JpaRepository<Product, Integer> {
   @Query(value ="SELECT product.productId, product.name, product.carbohydrates,product.proteins,product.fats FROM product, preparation"
           + " where productId = ProductproductId AND MealmealId = :mealId", nativeQuery = true)
    public List<Product> findByMeal(@Param("mealId") int id);
}
