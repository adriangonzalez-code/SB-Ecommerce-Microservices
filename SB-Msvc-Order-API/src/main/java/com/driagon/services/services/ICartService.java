package com.driagon.services.services;

import com.driagon.services.dto.CartItemRequest;
import com.driagon.services.entities.CartItem;

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

    boolean deleteItemFromCart(String userId, String productId);

    List<CartItem> getCart(String userId);

    void clearCart(String userId);
}
