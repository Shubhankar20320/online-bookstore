package com.example.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.book.entity.Customer;
import com.example.book.exception.ResourceNotFoundException;
import com.example.book.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    // Get all customers
    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    // Get customer by id
    public Customer getCustomerById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
    }

    // Add a new customer
    public Customer addCustomer(Customer customer) {
        return repo.save(customer);
    }

    // Update an existing customer
    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer existingCustomer = repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));

        existingCustomer.setName(customerDetails.getName());
        existingCustomer.setEmail(customerDetails.getEmail());
        existingCustomer.setPhone(customerDetails.getPhone());

        return repo.save(existingCustomer);
    }

    // Delete a customer
    public void deleteCustomer(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Customer not found with id " + id);
        }
        repo.deleteById(id);
    }
}