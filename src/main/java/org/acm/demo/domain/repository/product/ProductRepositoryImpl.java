package org.acm.demo.domain.repository.product;

import org.acm.demo.domain.data.Product;
import org.acm.demo.domain.repository.ProductSearchField;
import org.acm.demo.domain.repository.ProductSortOption;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : Bahar Zolfaghari
 **/
public class ProductRepositoryImpl implements ProductRepository {
    private final List<Product> products = new ArrayList<>();
    private static ProductRepository productRepository;

    private ProductRepositoryImpl() {

    }

    public static ProductRepository getProductRepository() {
        if (Objects.isNull(productRepository)) {
            productRepository = new ProductRepositoryImpl();
        }
        return productRepository;
    }

    @Override
    public void saveProduct(Product product) {
        products.add(product);
    }

    @Override
    public void deleteProduct(Product product) {
        products.remove(product);
    }

    @Override
    public void updateProduct(Product product) {
        products.removeIf(p -> p.getId().equals(product.getId()));
        products.add(product);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return products.stream().filter(product -> product.getCategory().equals(category)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsByCompany(String company) {
        return products.stream().filter(product -> product.getCompany().equals(company)).collect(Collectors.toList());
    }

    @Override
    public List<Product> searchProducts(ProductSearchField productSearchField) {
        return products.stream().filter(product -> product.getName().equals(productSearchField.getName()) ||
                product.getCategory().equals(productSearchField.getCategory()) ||
                product.getPrice() >= productSearchField.getMinPrice() ||
                product.getPrice() <= productSearchField.getMaxPrice() ||
                product.getCompany().equals(productSearchField.getCompany()) ||
                product.getRating().equals(productSearchField.getRating())
        ).collect(Collectors.toList());
    }

    @Override
    public List<Product> sortProducts(ProductSortOption productSortOption) {
        switch (productSortOption) {
            case NAME:
                return products.stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
            case PRICE:
                return products.stream().sorted(Comparator.comparing(Product::getPrice)).collect(Collectors.toList());
            case RATING:
                return products.stream().sorted(Comparator.comparing(Product::getRating)).collect(Collectors.toList());
            default:
                return products;
        }
    }

    @Override
    public Integer getLastProductId() {
        if (products.isEmpty()) {
            return 0;
        }
        int lastCustomerIndex = products.size() - 1;
        return products.get(lastCustomerIndex).getId();
    }
}
