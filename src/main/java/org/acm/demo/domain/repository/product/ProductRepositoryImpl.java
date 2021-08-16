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
 * @author : Bahar Zolfaghari & Parham Minouian
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
        int newId = getLastProductId();
        product.setId(newId);
        products.add(product);
    }

    @Override
    public void deleteProduct(Product product) {
        products.remove(product);
    }

    @Override
    public void updateProduct(int id,Product newProduct) {
        Product oldProduct = getProductById(id);
        if(oldProduct == null){
            return;
        }
        oldProduct.setCategory(newProduct.getCategory());
        oldProduct.setCompany(newProduct.getCompany());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setName(newProduct.getName());
        oldProduct.setQuantity(newProduct.getQuantity());
        oldProduct.setRating(newProduct.getRating());
        oldProduct.setYear(newProduct.getYear());
    }

    @Override
    public List<Product> getProducts(){
        return products;
    }

    @Override
    public Product getProductById(int id) {
        for(Product product : products){
            if(id == product.getId()){
                return product;
            }
        }
        return null;
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
        return products.get(products.size() - 1).getId() + 1;
    }
}

