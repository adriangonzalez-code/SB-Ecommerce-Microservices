package com.driagon.ecommerce.services.app.repositories;

import com.driagon.ecommerce.services.app.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    /**
     * Finds products by a keyword in their name.
     *
     * @param keyword the keyword to search for
     * @return a list of products matching the keyword
     */
    @Query("SELECT p FROM products p WHERE p.active = true AND p.stockQuantity > 0 AND LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> searchProduct(@Param("keyword") String keyword);
}