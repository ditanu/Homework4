package com.cloudschool.myFirstAPI.service;

import com.cloudschool.myFirstAPI.model.Product;
import com.cloudschool.myFirstAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<Product> aux = new ArrayList<>();
        productRepository.findAll().iterator().forEachRemaining(aux::add);
        return aux;
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }

    public Product save(Product p) {
        return productRepository.save(p);
    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
