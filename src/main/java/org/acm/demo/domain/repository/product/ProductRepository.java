package org.acm.demo.domain.repository.product;

import org.acm.demo.domain.data.Product;
import org.acm.demo.domain.repository.ProductFilterOption;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
public interface ProductRepository {
    void saveProduct(Product product);
    void deleteProduct(Product product);
    void updateProduct(int id,Product product);
    List<Product> getProducts();
    Product getProductById(int id);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByCompany(String company);
    List<Product> filterProducts(String name, String category, Long minPrice,
                                 Long maxPrice, String company, Integer rating);
    List<Product> sortProducts(ProductFilterOption productFilterOption);
}
