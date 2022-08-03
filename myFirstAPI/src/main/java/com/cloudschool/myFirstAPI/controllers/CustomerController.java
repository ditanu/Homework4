package com.cloudschool.myFirstAPI.controllers;

import com.cloudschool.myFirstAPI.model.Customer;
import com.cloudschool.myFirstAPI.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") Integer id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public Customer editCustomer(@PathVariable("id") Integer id, @RequestBody Customer newCustomer) {
        return customerService.findById(id)
                .map(customer -> {
                    customer.setName(newCustomer.getName());
                    customer.setEmail(newCustomer.getEmail());
                    return customerService.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return customerService.save(newCustomer);
                });
    }

    @DeleteMapping("/{id}")
    void deleteCustomer(@PathVariable Integer id) {
        customerService.deleteById(id);
    }

    //put-ul si delete-ul au fost inspirate de aici "https://spring.io/guides/tutorials/rest/"
}
