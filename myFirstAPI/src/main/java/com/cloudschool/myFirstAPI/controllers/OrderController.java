package com.cloudschool.myFirstAPI.controllers;

import com.cloudschool.myFirstAPI.model.Orders;
import com.cloudschool.myFirstAPI.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable("id") Integer id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Orders saveOrder(@RequestBody Orders order) {
        return orderService.save(order);
    }

    @PutMapping("/{id}")
    public Orders editOrder(@PathVariable("id") Integer id, @RequestBody Orders newOrder) {
        return orderService.findById(id)
                .map(order -> {
                    order.setStatus(newOrder.getStatus());
                    order.setComments(newOrder.getComments());
                    return orderService.save(order);
                })
                .orElseGet(() -> {
                    newOrder.setId(id);
                    return orderService.save(newOrder);
                });
    }

    @DeleteMapping("/{id}")
    void deleteOrder(@PathVariable Integer id) {
        orderService.deleteById(id);
    }
    //put-ul si delete-ul au fost inspirate de aici "https://spring.io/guides/tutorials/rest/"
}
