package com.cloudschool.myFirstAPI.repository;

import com.cloudschool.myFirstAPI.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    public void delete(Product product);

    public List<Product> findAll();
}
