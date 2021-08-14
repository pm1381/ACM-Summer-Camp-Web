package org.acm.demo.domain.data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Bahar Zolfaghari
 **/
public class Cart {
    private Integer id;
    private Customer customer;
    private Map<Product, Integer> products = new HashMap<>();
    private CartStatus status;

    public Cart(Integer id,Customer customer) {
        this.id = id;
        this.customer=customer;
    }

    public Integer getId() {
        return id;
    }

    public Cart setId(Integer id) {
        this.id = id;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Cart setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public Cart setProducts(Map<Product, Integer> products) {
        this.products = products;
        return this;
    }

    public CartStatus getStatus() {
        return status;
    }

    public Cart setStatus(CartStatus status) {
        this.status = status;
        return this;
    }

    public Product referToProductPage(int productId){
        Product referProduct = null;
        for (Map.Entry<Product,Integer> entry : getProducts().entrySet()){
            if(entry.getKey().getId() == productId){
                referProduct = entry.getKey();
            }
        }
        return referProduct;
    }
}
