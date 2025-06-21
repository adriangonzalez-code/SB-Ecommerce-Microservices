package com.driagon.services.services;

import com.driagon.services.dto.ProductRequest;
import com.driagon.services.dto.ProductResponse;

import java.util.List;

public interface IProductService {

    /**
     * Fetches all products.
     *
     * @return a list of product responses
     */
    List<ProductResponse> fetchAllProducts();

    /**
     * Fetches a product by its ID.
     *
     * @param id the ID of the product
     * @return the product response
     */
    ProductResponse getProductById(Long id);

    /**
     * Searches for products by a keyword.
     *
     * @param keyword the keyword to search for
     * @return a list of product responses matching the keyword
     */
    List<ProductResponse> searchProduct(String keyword);

    /**
     * Creates a new product.
     *
     * @param productRequest the product request containing product details
     * @return the created product response
     */
    ProductResponse createProduct(ProductRequest productRequest);

    ProductResponse updateProduct(Long id, ProductRequest productRequest);

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     * @return true if the product was deleted, false otherwise
     */
    boolean deleteProduct(Long id);
}
