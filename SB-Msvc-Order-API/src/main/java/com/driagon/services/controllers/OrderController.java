package com.driagon.services.controllers;

import com.driagon.services.dto.OrderResponse;
import com.driagon.services.services.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final IOrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestHeader("X-User-ID") String userId) {
        return orderService.createOrder(userId).map(response -> ResponseEntity.status(201).body(response)).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}