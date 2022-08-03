package com.cloudschool.myFirstAPI.service;

import com.cloudschool.myFirstAPI.model.Orders;
import com.cloudschool.myFirstAPI.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Orders> getAllOrders() {
        List<Orders> aux = new ArrayList<>();
        orderRepository.findAll().iterator().forEachRemaining(aux::add);
        return aux;
    }

    public Orders getOrderById(Integer id) {
        return orderRepository.findById(id).get();
    }

    public Orders save(Orders o) {
        return orderRepository.save(o);
    }

    public Optional<Orders> findById(Integer id) {
        return orderRepository.findById(id);
    }

    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }
}
