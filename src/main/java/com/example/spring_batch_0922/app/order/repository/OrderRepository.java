package com.example.spring_batch_0922.app.order.repository;

import com.example.spring_batch_0922.app.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}