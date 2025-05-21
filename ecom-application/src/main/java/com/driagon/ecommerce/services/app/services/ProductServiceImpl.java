package com.driagon.ecommerce.services.app.services;

import com.driagon.ecommerce.services.app.dto.ProductRequest;
import com.driagon.ecommerce.services.app.dto.ProductResponse;
import com.driagon.ecommerce.services.app.mappers.ProductMapper;
import com.driagon.ecommerce.services.app.models.Product;
import com.driagon.ecommerce.services.app.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository repository;

    /**
     * Fetches all products.
     *
     * @return a list of product responses
     */
    @Override
    public List<ProductResponse> fetchAllProducts() {
        return this.repository.findByActiveTrue().stream().map(ProductMapper::mapProductToProductResponse).collect(Collectors.toList());
    }

    /**
     * Fetches a product by its ID.
     *
     * @param id the ID of the product
     * @return the product response
     */
    @Override
    public ProductResponse getProductById(Long id) {
        return this.repository.findByIdAndActiveTrue(id)
                .map(ProductMapper::mapProductToProductResponse)
                .orElse(null);
    }

    /**
     * Searches for products by a keyword.
     *
     * @param keyword the keyword to search for
     * @return a list of product responses matching the keyword
     */
    @Override
    public List<ProductResponse> searchProduct(String keyword) {
        return this.repository.searchProduct(keyword)
                .stream()
                .map(ProductMapper::mapProductToProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        ProductMapper.mapProductRequestToProduct(product, productRequest);
        product = this.repository.save(product);
        return ProductMapper.mapProductToProductResponse(product);
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        return this.repository.findById(id)
                .map(product -> {
                    ProductMapper.mapProductRequestToProduct(product, productRequest);
                    product = this.repository.save(product);
                    return ProductMapper.mapProductToProductResponse(product);
                }).orElse(null);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     * @return
     */
    @Override
    public boolean deleteProduct(Long id) {
        return this.repository.findById(id)
                .map(product -> {
                    product.setActive(false);
                    this.repository.save(product);
                    return true;
                }).orElse(false);
    }
}