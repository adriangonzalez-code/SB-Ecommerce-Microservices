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
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
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

    @Override
    public boolean deleteItemFromCart(String userId, Long productId) {
        if (userId == null || productId == null) {
            return false;
        }

        Optional<Product> product = this.productRepository.findById(productId);

        Optional<User> user = this.userRepository.findById(Long.valueOf(userId));

        if (user.isEmpty() || product.isEmpty()) {
            return false;
        }

        this.repository.deleteByUserAndProduct(user.get(), product.get());

        return true;
    }

    @Override
    public List<CartItem> getCartItems(String userId) {
        return this.userRepository.findById(Long.valueOf(userId))
                .map(repository::findByUser)
                .orElseGet(List::of);
    }

    private BigDecimal calculateItemPrice(BigDecimal unitPrice, int quantity) {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
}