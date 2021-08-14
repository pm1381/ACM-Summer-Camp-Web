package org.acm.demo.domain.data;

import java.util.Date;

/**
 * @author : Bahar Zolfaghari
 **/
public class  PurchaseHistory {
    private Integer id;
    private Cart cart;
    private Long totalPrice;

    public Integer getId() {
        return id;
    }

    public PurchaseHistory setId(Integer id) {
        this.id = id;
        return this;
    }

    public Cart getCart() {
        return cart;
    }

    public PurchaseHistory setCart(Cart cart) {
        this.cart = cart;
        return this;
    }
    
    public Long getTotalPrice() {
        return totalPrice;
    }

    public PurchaseHistory setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }
}
