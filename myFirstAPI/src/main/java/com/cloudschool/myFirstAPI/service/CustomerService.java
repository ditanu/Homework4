package com.cloudschool.myFirstAPI.service;

import com.cloudschool.myFirstAPI.model.Customer;
import com.cloudschool.myFirstAPI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        List<Customer> aux = new ArrayList<>();
        customerRepository.findAll().iterator().forEachRemaining(aux::add);
        return aux;
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).get();
    }

    public Customer save(Customer c) {
        return customerRepository.save(c);
    }

    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }
}
