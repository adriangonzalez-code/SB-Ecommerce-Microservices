package com.driagon.ecommerce.services.app.repositories;

import com.driagon.ecommerce.services.app.models.CartItem;
import com.driagon.ecommerce.services.app.models.Product;
import com.driagon.ecommerce.services.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface ICartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem findByUserAndProduct(User user, Product product);

    void deleteByUserAndProduct(User user, Product product);

    List<CartItem> findByUser(User user);

    @Modifying
    void deleteByUser(User user);
}