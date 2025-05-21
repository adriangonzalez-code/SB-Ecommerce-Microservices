package com.driagon.ecommerce.services.app.controllers;

import com.driagon.ecommerce.services.app.dto.CartItemRequest;
import com.driagon.ecommerce.services.app.services.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final ICartService service;

    @PostMapping
    public ResponseEntity<Void> addToCart(@RequestHeader(value = "X-USER-ID") String userId, @RequestBody CartItemRequest cartItemRequest) {
        if (userId == null || userId.isBlank() || cartItemRequest == null) {
            return ResponseEntity.badRequest().build();
        }

        try {
            boolean result = this.service.addToCart(userId, cartItemRequest);
            return result ? ResponseEntity.status(HttpStatus.CREATED).build()
                    : ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}