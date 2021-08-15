package org.acm.demo.domain.data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Bahar Zolfaghari & Parham
 **/
public class Cart {
    private Integer id;
    private Customer customer;
    private Map<Product, Integer> products = new HashMap<>();
    private CartStatus status;

    public Cart(Integer id,Customer customer) {
        this.id = id;
        this.customer=customer;
        status = CartStatus.EMPTY;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public CartStatus getStatus() {
        return status;
    }

    public void setStatus(CartStatus status) {
        this.status = status;
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

    public void addToCart(int quantity,Product product){
        if(getProducts().containsKey(product)){
            if(quantity +getProducts().get(product) <= product.getQuantity() ){
                getProducts().put(product,getProducts().get(product)+quantity);
            }
        }
        getProducts().put(product,quantity);
        setStatus(CartStatus.AWAITING_PAYMENT);
    }

    public void clearCart(Cart cart) {
        getProducts().clear();
        cart.setStatus(CartStatus.EMPTY);
    }

    public void removeFromCart(Product product){
        getProducts().remove(product);
    }
}
