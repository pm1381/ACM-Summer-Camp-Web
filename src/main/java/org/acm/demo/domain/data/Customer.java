package org.acm.demo.domain.data;

/**
 * @author : Bahar Zolfaghari
 **/
public class Customer extends User {
    private Credit credit;
    private Cart cart;
    private PurchaseHistory purchaseHistory;

    public Credit getCredit() {
        return credit;
    }

    public Customer setCredit(Credit credit) {
        this.credit = credit;
        return this;
    }

    public Cart getCart() {
        return cart;
    }

    public Customer setCart(Cart cart) {
        this.cart = cart;
        return this;
    }

    public PurchaseHistory getPurchaseHistory() {
        return purchaseHistory;
    }

    public Customer setPurchaseHistory(PurchaseHistory purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
        return this;
    }
}
