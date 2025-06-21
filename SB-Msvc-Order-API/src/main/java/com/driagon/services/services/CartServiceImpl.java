package com.driagon.services.services;

import com.driagon.services.dto.CartItemRequest;
import com.driagon.services.entities.CartItem;
import com.driagon.services.repositories.ICartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CartServiceImpl implements ICartService {

    private final ICartItemRepository repository;

    /**
     * Adds an item to the user's cart.
     *
     * @param userId          The ID of the user.
     * @param cartItemRequest The request object containing item details.
     * @return true if the item was added successfully, false otherwise.
     */
    @Override
    public boolean addToCart(String userId, CartItemRequest cartItemRequest) {
        if (userId == null || cartItemRequest == null || cartItemRequest.getQuantity() <= 0) {
            return false;
        }

        // Look for product
        /*Product product = this.productRepository.findByIdAndActiveTrue(cartItemRequest.getProductId())
                .orElse(null);
        if (product == null || product.getStockQuantity() < cartItemRequest.getQuantity()) {
            return false;
        }*/

        try {
            // Check if the user already has the product in their cart
            CartItem existingCartItem = this.repository.findByUserIdAndProductId(Long.valueOf(userId), Long.valueOf(cartItemRequest.getProductId()));

            if (existingCartItem != null) {
                // Validate total quantity doesn't exceed stock
                existingCartItem.setQuantity(existingCartItem.getQuantity() + cartItemRequest.getQuantity());
                existingCartItem.setPrice(new BigDecimal(1000.00));
                repository.save(existingCartItem);
            } else {
                // Create a new cart item
                CartItem cartItem = CartItem.builder()
                        .userId(Long.valueOf(userId))
                        .productId(Long.valueOf(cartItemRequest.getProductId()))
                        .quantity(cartItemRequest.getQuantity())
                        .price(new BigDecimal("1000.00"))
                        .build();
                this.repository.save(cartItem);
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteItemFromCart(String userId, String productId) {
        CartItem cartItem = this.repository.findByUserIdAndProductId(Long.valueOf(userId), Long.valueOf(productId));

        if (cartItem != null) {
            this.repository.delete(cartItem);
            return true;
        }

        return false;
    }

    @Override
    public List<CartItem> getCart(String userId) {
        return this.repository.findByUserId(Long.valueOf(userId));
    }

    private BigDecimal calculateItemPrice(BigDecimal unitPrice, int quantity) {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public void clearCart(String userId) {
        this.repository.deleteByUserId(Long.valueOf(userId));
    }
}