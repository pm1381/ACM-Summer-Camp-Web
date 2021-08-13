package ir.ac.kntu.models.userRelated;

import ir.ac.kntu.models.goodsRelated.Product;
import ir.ac.kntu.repositories.PurchaseHistoryRepository;

import java.util.HashMap;
import java.util.Map;

public class PurchasedHistory {
    private int id;
    private int totalSpent = 0;
    private Map<Product,Integer> allPurchasedProducts;

    public PurchasedHistory(int id) {
        this.id = id;
        allPurchasedProducts = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(int addition) {
        this.totalSpent = totalSpent + addition;
    }

    public Map<Product, Integer> getAllPurchasedProducts() {
        return allPurchasedProducts;
    }
}

/*
    public PurchasedHistory getPurchasedHistory(){
        return PurchaseHistoryRepository.getInstance().showPurchaseHistory();
    }
 */

