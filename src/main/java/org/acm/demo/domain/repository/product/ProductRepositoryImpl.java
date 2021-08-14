package org.acm.demo.domain.repository.product;

import org.acm.demo.domain.data.Product;
import org.acm.demo.domain.repository.ProductFilterOption;

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
    private ProductRepository productRepository;
    private static int productLastID = 1;

    private ProductRepositoryImpl() {

    }

    public ProductRepository getProductRepository() {
        if (Objects.isNull(productRepository)) {
            productRepository = new ProductRepositoryImpl();
        }
        return productRepository;
    }

    @Override
    public void saveProduct(Product product) {
        product.setId(productLastID++);
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
    public List<Product> filterProducts(String name, String category, Long minPrice,
                                        Long maxPrice, String company, Integer rating) {
        return products.stream().filter(product -> product.getName().contains(name) ||
                product.getCategory().equals(category) ||
                product.getPrice() >= minPrice ||
                product.getPrice() <= maxPrice ||
                product.getCompany().equals(company) ||
                product.getRating().equals(rating)
        ).collect(Collectors.toList());
    }

    @Override
    public List<Product> sortProducts(ProductFilterOption productFilterOption) {
        switch (productFilterOption) {
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
}


/*
    @Override
    public void updateProduct(Product product) {
        products.removeIf(p -> p.getId().equals(product.getId()));
        products.add(product);
    }
 */
