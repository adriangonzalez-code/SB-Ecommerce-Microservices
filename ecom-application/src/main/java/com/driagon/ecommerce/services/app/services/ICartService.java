package com.driagon.ecommerce.services.app.services;

import com.driagon.ecommerce.services.app.dto.CartItemRequest;
import com.driagon.ecommerce.services.app.models.CartItem;

import java.util.List;

public interface ICartService {

    /**
     * Adds an item to the user's cart.
     *
     * @param userId          The ID of the user.
     * @param cartItemRequest The request object containing item details.
     * @return true if the item was added successfully, false otherwise.
     */
    boolean addToCart(String userId, CartItemRequest cartItemRequest);

    boolean deleteItemFromCart(String userId, Long productId);

    List<CartItem> getCartItems(String userId);
}
