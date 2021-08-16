package org.acm.demo.controller;

import org.acm.demo.domain.data.Product;
import org.acm.demo.domain.repository.ProductSearchField;
import org.acm.demo.domain.repository.product.ProductRepository;
import org.acm.demo.domain.repository.product.ProductRepositoryImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
@RestController
@RequestMapping("/search-products")
public class SearchController {
    private final ProductRepository productRepository = ProductRepositoryImpl.getProductRepository();

    @PostMapping
    public List<Product> searchProducts(@RequestBody ProductSearchField productSearchField) {
        return productRepository.searchProducts(productSearchField);
    }
}
