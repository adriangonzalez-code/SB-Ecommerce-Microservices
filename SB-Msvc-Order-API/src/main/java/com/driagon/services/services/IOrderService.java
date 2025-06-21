package com.driagon.services.services;

import com.driagon.services.dto.OrderResponse;

import java.util.Optional;

public interface IOrderService {

    Optional<OrderResponse> createOrder(String userId);
}
