package com.driagon.ecommerce.services.app.controllers;

import com.driagon.ecommerce.services.app.dto.CartItemRequest;
import com.driagon.ecommerce.services.app.models.CartItem;
import com.driagon.ecommerce.services.app.services.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final ICartService service;

    /**
     * Retrieves the cart items for a user.
     *
     * @param userId The ID of the user.
     * @return A list of cart items.
     */
    @GetMapping
    public ResponseEntity<List<CartItem>> getCart(@RequestHeader(value = "X-USER-ID") String userId) {
        if (userId == null || userId.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        List<CartItem> cartItems = this.service.getCartItems(userId);
        if (cartItems == null || cartItems.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cartItems);
    }

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

    @DeleteMapping("/items/{productId}")
    public ResponseEntity<Void> removeFromCart(@RequestHeader(value = "X-USER-ID") String userId, @PathVariable Long productId) {
        if (userId == null || userId.isBlank() || productId == null) {
            return ResponseEntity.badRequest().build();
        }

        boolean deleted = this.service.deleteItemFromCart(userId, productId);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}