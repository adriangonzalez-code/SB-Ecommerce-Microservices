package com.driagon.ecommerce.services.app.services;

import com.driagon.ecommerce.services.app.dto.ProductRequest;
import com.driagon.ecommerce.services.app.dto.ProductResponse;

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
     * Creates a new product.
     *
     * @param productRequest the product request containing product details
     * @return the created product response
     */
    ProductResponse createProduct(ProductRequest productRequest);

    ProductResponse updateProduct(Long id, ProductRequest productRequest);
}
