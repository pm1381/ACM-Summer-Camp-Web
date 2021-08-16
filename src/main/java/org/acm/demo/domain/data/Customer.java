package org.acm.demo.domain.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Bahar Zolfaghari & Parham
 **/
public class Customer extends User {
    @JsonIgnore
    private Credit credit;
    @JsonIgnore
    private Cart cart;
    @JsonIgnore
    private List<PurchaseHistory> purchaseHistories = new ArrayList<>();

    public Customer(String name, String family, String phone, String email, String password) {
        super(name, family, phone, email, password);
        setRole(Role.CUSTOMER);
    }

    public void setInitials(int id){
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

    public List<PurchaseHistory> getPurchaseHistories() {
        return purchaseHistories;
    }

    public void setPurchaseHistories(List<PurchaseHistory> purchaseHistories) {
        this.purchaseHistories = purchaseHistories;
    }

    //TODO : THESE TWO METHODS BELOW MAY HAVE ANOTHER PLACE
    /*public void deleteAnItemFromHistory(Product product) {
        getPurchaseHistories().getAllPurchasedProducts().remove(product);
    }

    public void addToCostumerHistory(Product product,int quantity) {
        if(getPurchaseHistories().getAllPurchasedProducts().containsKey(product)){
            quantity +=  getPurchaseHistories().getAllPurchasedProducts().get(product);
        }
        getPurchaseHistories().getAllPurchasedProducts().put(product,quantity);
    }*/
}
