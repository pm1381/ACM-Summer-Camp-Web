package org.acm.demo.domain.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author : Bahar Zolfaghari
 **/
public class Customer extends User {
    @JsonIgnore
    private Credit credit;
    @JsonIgnore
    private Cart cart;
    @JsonIgnore
    private PurchaseHistory purchaseHistory;

    public Customer(Integer id, String name, String family, String phone, String email, String password) {
        super(id, name, family, phone, email, password);
        setRole(Role.CUSTOMER);
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public PurchaseHistory getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(PurchaseHistory purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }
}
