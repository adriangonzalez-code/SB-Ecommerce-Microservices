package com.driagon.ecommerce.services.app.repositories;

import com.driagon.ecommerce.services.app.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}