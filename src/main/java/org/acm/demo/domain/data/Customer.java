package org.acm.demo.domain.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

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

    public Customer(String name, String family, String phone, String email, String password) {
        super(name, family, phone, email, password);
        setRole(Role.CUSTOMER);
    }

    public void setInitials(int id){
        purchaseHistory = new PurchaseHistory(id);
        credit = new Credit(id);
        cart = new Cart(id,this);
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

    public void deleteAnItemFromHistory(Product product) {
        getPurchaseHistory().getAllPurchasedProducts().remove(product);
    }

    public void addToCostumerHistory(Product product,int quantity) {
        if(getPurchaseHistory().getAllPurchasedProducts().containsKey(product)){
            quantity +=  getPurchaseHistory().getAllPurchasedProducts().get(product);
        }
        getPurchaseHistory().getAllPurchasedProducts().put(product,quantity);
    }
}
