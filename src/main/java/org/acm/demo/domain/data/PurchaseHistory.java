package org.acm.demo.domain.data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Bahar Zolfaghari & Parham
 **/
public class  PurchaseHistory {
    private Integer id;
    private final Map<Product, Integer> allPurchasedProducts = new HashMap<>();
    private Long totalPrice = 0L;

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

    public void setTotalPrice(Long addedPrice) {
        this.totalPrice = totalPrice+addedPrice;
    }

}
