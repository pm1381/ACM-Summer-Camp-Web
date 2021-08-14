package org.acm.demo.domain.data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Bahar Zolfaghari
 **/
public class  PurchaseHistory {
    private Integer id;
    private Map<Product,Integer> allPurchasedProducts = new HashMap<>();
    private Long totalPrice = 0L;

    public PurchaseHistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<Product, Integer> getAllPurchasedProducts() {
        return allPurchasedProducts;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
