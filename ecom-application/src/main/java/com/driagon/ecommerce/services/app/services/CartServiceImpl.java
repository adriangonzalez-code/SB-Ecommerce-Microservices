package com.driagon.ecommerce.services.app.services;

import com.driagon.ecommerce.services.app.dto.CartItemRequest;
import com.driagon.ecommerce.services.app.models.CartItem;
import com.driagon.ecommerce.services.app.models.Product;
import com.driagon.ecommerce.services.app.models.User;
import com.driagon.ecommerce.services.app.repositories.ICartItemRepository;
import com.driagon.ecommerce.services.app.repositories.IProductRepository;
import com.driagon.ecommerce.services.app.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {

    private final ICartItemRepository repository;

    private final IProductRepository productRepository;

    private final IUserRepository userRepository;

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
        Product product = this.productRepository.findByIdAndActiveTrue(cartItemRequest.getProductId())
                .orElse(null);
        if (product == null || product.getStockQuantity() < cartItemRequest.getQuantity()) {
            return false;
        }

        User user = this.userRepository.findById(Long.valueOf(userId))
                .orElse(null);
        if (user == null) {
            return false;
        }

        try {
            // Check if the user already has the product in their cart
            CartItem existingCartItem = this.repository.findByUserAndProduct(user, product);

            if (existingCartItem != null) {
                // Validate total quantity doesn't exceed stock
                int newQuantity = existingCartItem.getQuantity() + cartItemRequest.getQuantity();
                if (newQuantity > product.getStockQuantity()) {
                    return false;
                }

                // Update the quantity
                existingCartItem.setQuantity(newQuantity);
                existingCartItem.setPrice(calculateItemPrice(product.getPrice(), newQuantity));
                this.repository.save(existingCartItem);
            } else {
                // Create a new cart item
                CartItem cartItem = CartItem.builder()
                        .user(user)
                        .product(product)
                        .quantity(cartItemRequest.getQuantity())
                        .price(calculateItemPrice(product.getPrice(), cartItemRequest.getQuantity()))
                        .build();
                this.repository.save(cartItem);
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private BigDecimal calculateItemPrice(BigDecimal unitPrice, int quantity) {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
}