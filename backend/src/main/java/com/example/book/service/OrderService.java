/*package com.example.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.book.entity.Order;
import com.example.book.exception.ResourceNotFoundException;
import com.example.book.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    // Get all orders
    public List<Order> getAllOrders() {
        return repo.findAll();
    }

    // Get order by id
    public Order getOrderById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
    }

    // Place a new order
    public Order placeOrder(Order order) {
        return repo.save(order);
    }

    // Update an existing order
    public Order updateOrder(Long id, Order orderDetails) {
        Order existingOrder = repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));

        existingOrder.setStatus(orderDetails.getStatus());
        existingOrder.setCustomer(orderDetails.getCustomer());
        existingOrder.setBook(orderDetails.getBook());
        existingOrder.setQuantity(orderDetails.getQuantity());

        return repo.save(existingOrder);
    }

    // Delete an order
    public void deleteOrder(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Order not found with id " + id);
        }
        repo.deleteById(id);
    }
}*/


package com.example.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.book.entity.Order;
import com.example.book.entity.Customer;
import com.example.book.entity.Book;
import com.example.book.exception.ResourceNotFoundException;
import com.example.book.repository.OrderRepository;
import com.example.book.repository.CustomerRepository;
import com.example.book.repository.BookRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private BookRepository bookRepo;

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    // Get order by id
    public Order getOrderById(Long id) {
        return orderRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
    }

    // Place a new order
    public Order placeOrder(Order order) {
        // Validate customer
        Customer customer = customerRepo.findById(order.getCustomer().getId())
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + order.getCustomer().getId()));

        // Validate book
        Book book = bookRepo.findById(order.getBook().getId())
            .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + order.getBook().getId()));

        // Set validated entities
        order.setCustomer(customer);
        order.setBook(book);

        return orderRepo.save(order);
    }

    // Update an existing order
    public Order updateOrder(Long id, Order orderDetails) {
        Order existingOrder = orderRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));

        Customer customer = customerRepo.findById(orderDetails.getCustomer().getId())
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + orderDetails.getCustomer().getId()));

        Book book = bookRepo.findById(orderDetails.getBook().getId())
            .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + orderDetails.getBook().getId()));

        existingOrder.setStatus(orderDetails.getStatus());
        existingOrder.setQuantity(orderDetails.getQuantity());
        existingOrder.setCustomer(customer);
        existingOrder.setBook(book);

        return orderRepo.save(existingOrder);
    }

    // Delete an order
    public void deleteOrder(Long id) {
        if (!orderRepo.existsById(id)) {
            throw new ResourceNotFoundException("Order not found with id " + id);
        }
        orderRepo.deleteById(id);
    }
}