package com.driagon.ecommerce.services.app.repositories;

import com.driagon.ecommerce.services.app.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Long> {

    /**
     * Finds all products that are active.
     *
     * @return a list of active products
     */
    List<Product> findByActiveTrue();

    /**
     * Finds a product by its ID and checks if it is active.
     *
     * @param id the ID of the product
     * @return an optional containing the product if found and active, otherwise empty
     */
    Optional<Product> findByIdAndActiveTrue(Long id);
}