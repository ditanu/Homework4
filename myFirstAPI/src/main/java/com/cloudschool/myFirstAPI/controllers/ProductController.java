package com.cloudschool.myFirstAPI.controllers;

import com.cloudschool.myFirstAPI.model.Product;
import com.cloudschool.myFirstAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product editProduct(@PathVariable("id") Integer id, @RequestBody Product newProduct) {
        return productService.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setPrice(newProduct.getPrice());
                    return productService.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return productService.save(newProduct);
                });
    }

    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable Integer id) {
        productService.deleteById(id);
    }

    //put-ul si delete-ul au fost inspirate de aici "https://spring.io/guides/tutorials/rest/"
}
