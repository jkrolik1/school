package com.diethelper.db.diethelperdb.resource;
import com.diethelper.db.diethelperdb.model.Meal;
import com.diethelper.db.diethelperdb.model.Product;
import com.diethelper.db.diethelperdb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")

public class ProductResource {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/all")
    private List<Product> getAll() {
        return productRepository.findAll();
    }

}
