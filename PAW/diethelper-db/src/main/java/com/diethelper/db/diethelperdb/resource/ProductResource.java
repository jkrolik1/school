package com.diethelper.db.diethelperdb.resource;
import com.diethelper.db.diethelperdb.model.Product;
import com.diethelper.db.diethelperdb.repository.ProductRepository;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product")

public class ProductResource {

    @Autowired
    ProductRepository productRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    Pair<String, Product> addNewProduct(@RequestBody Map<String, Object> body) {
        Product product = new Product();

        product.setName(body.get("name").toString());
        product.setCarbohydrates(Integer.parseInt(body.get("carbohydrates").toString()));
        product.setProteins(Integer.parseInt(body.get("proteins").toString()));
        product.setFats(Integer.parseInt(body.get("fats").toString()));

        return new Pair<String, Product>("Dodano produkt.", product);
    }

    @GetMapping(value = "/all")
    private List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping(value = "/{productId}")
    private ResponseEntity<Product> getProductById(@PathVariable("productId") int id) {
        Optional<Product> opt = productRepository.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{productId}")
    private Pair<String, Product> editProductById(@RequestBody Map<String, Object> body, @PathVariable("productId") int id) {
        Optional<Product> productToEdit = productRepository.findById(id);
        if (productToEdit.isPresent()) {
            productToEdit.get().setName(body.get("name").toString());
            productToEdit.get().setCarbohydrates((Integer) body.get("carbohydrates"));
            productToEdit.get().setProteins((Integer) body.get("proteins"));
            productToEdit.get().setFats((Integer) body.get("fats"));
            productRepository.save(productToEdit.get());
            return new Pair<String, Product>("Edycja pomyślna", productToEdit.get());
        } else {
            return new Pair<String, Product>("Nie ma id w bazie", null);
        }
    }

    @DeleteMapping(value = "/{productId}")
    private String deleteProductById(@PathVariable("productId") List<Integer> id) {
        for (int i = 0; i < id.size(); ++i) {
            productRepository.deleteById(id.get(i));
        }
        return "Usunięto";
    }

    @GetMapping(value = "/")
    private List<Product> getDefault() {
        return productRepository.findAll();
    }
}
