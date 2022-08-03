package com.cloudschool.myFirstAPI.repository;

import com.cloudschool.myFirstAPI.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    public List<Customer> findAll();
}
