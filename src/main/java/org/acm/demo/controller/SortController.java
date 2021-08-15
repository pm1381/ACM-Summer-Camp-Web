package org.acm.demo.controller;

import org.acm.demo.domain.data.Product;
import org.acm.demo.domain.repository.ProductSortOption;
import org.acm.demo.domain.repository.product.ProductRepository;
import org.acm.demo.domain.repository.product.ProductRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
@RestController
@RequestMapping("/sort-products")
public class SortController {
    private final ProductRepository productRepository = ProductRepositoryImpl.getProductRepository();

    @GetMapping("/{param}")
    public List<Product> sortProducts(@PathVariable String param) {
        switch (param) {
            case "name":
                return productRepository.sortProducts(ProductSortOption.NAME);
            case "price":
                return productRepository.sortProducts(ProductSortOption.PRICE);
            case "rating":
                return productRepository.sortProducts(ProductSortOption.RATING);
            default:
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please choose one of [name, price, rating]!");
        }
    }
}
