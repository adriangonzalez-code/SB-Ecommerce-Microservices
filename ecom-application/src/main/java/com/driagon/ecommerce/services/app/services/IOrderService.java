package com.driagon.ecommerce.services.app.services;

import com.driagon.ecommerce.services.app.dto.OrderResponse;

import java.util.Optional;

public interface IOrderService {

    Optional<OrderResponse> createOrder(String userId);
}
