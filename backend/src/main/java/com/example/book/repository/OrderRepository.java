package com.example.book.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.book.entity.Order;
public interface OrderRepository extends JpaRepository<Order,Long>{

}
