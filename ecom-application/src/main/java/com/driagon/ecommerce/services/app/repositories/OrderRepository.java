package com.driagon.ecommerce.services.app.repositories;

import com.driagon.ecommerce.services.app.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}