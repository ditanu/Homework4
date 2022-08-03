package com.cloudschool.myFirstAPI.repository;

import com.cloudschool.myFirstAPI.model.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders, Integer> {
    public List<Orders> findAll();
}
