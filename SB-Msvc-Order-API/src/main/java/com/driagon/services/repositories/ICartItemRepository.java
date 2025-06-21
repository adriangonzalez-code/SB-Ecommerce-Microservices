package com.driagon.services.repositories;

import com.driagon.services.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface ICartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem findByUserIdAndProductId(Long userId, Long productId);

    void deleteByUserIdAndProductId(Long userId, Long productId);

    List<CartItem> findByUserId(Long userId);

    @Modifying
    void deleteByUserId(Long userId);

    String productId(Long productId);
}