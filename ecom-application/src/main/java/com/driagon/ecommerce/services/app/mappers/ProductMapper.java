package com.driagon.ecommerce.services.app.mappers;

import com.driagon.ecommerce.services.app.dto.ProductRequest;
import com.driagon.ecommerce.services.app.dto.ProductResponse;
import com.driagon.ecommerce.services.app.models.Product;

public class ProductMapper {

    /**
     * Converts a ProductRequest object to a Product object.
     *
     * @param productRequest the ProductRequest object to convert
     * @return the converted Product object
     */
    public static void mapProductRequestToProduct(Product product, ProductRequest productRequest) {
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setCategory(productRequest.getCategory());
        product.setImageUrl(productRequest.getImageUrl());
        product.setStockQuantity(productRequest.getStockQuantity());
    }

    /**
     * Converts a Product object to a ProductResponse object.
     *
     * @param product the Product object to convert
     * @return the converted ProductResponse object
     */
    public static ProductResponse mapProductToProductResponse(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory())
                .imageUrl(product.getImageUrl())
                .stockQuantity(product.getStockQuantity())
                .active(product.getActive())
                .build();
    }
}