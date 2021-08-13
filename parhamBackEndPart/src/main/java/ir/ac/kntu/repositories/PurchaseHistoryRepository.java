package ir.ac.kntu.repositories;

import ir.ac.kntu.models.goodsRelated.Product;
import ir.ac.kntu.models.userRelated.Costumer;
import ir.ac.kntu.models.userRelated.PurchasedHistory;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class PurchaseHistoryRepository {
    private static PurchaseHistoryRepository instance=null;
    private LinkedHashSet<PurchasedHistory> costumersPurchasedHistories = new LinkedHashSet<>();

    private PurchaseHistoryRepository() {
    }

    public LinkedHashSet<PurchasedHistory> getGlobalCostumersPurchasedHistories() {
        return costumersPurchasedHistories;
    }

    public void addToGlobalPurchasedHistory(PurchasedHistory purchasedHistory){
        getGlobalCostumersPurchasedHistories().add(purchasedHistory);
    }

    public static PurchaseHistoryRepository getInstance() {
        if(instance == null){
            instance = new PurchaseHistoryRepository();
        }
        return instance;
    }

    public void addToCostumerHistory(Costumer costumer, Product product,int quantity) {
        if(costumer.getPurchasedHistory().getAllPurchasedProducts().containsKey(product)){
            int newQuantity = quantity + costumer.getPurchasedHistory().getAllPurchasedProducts().get(product);
            costumer.getPurchasedHistory().getAllPurchasedProducts().put(product,newQuantity);
        }
        costumer.getPurchasedHistory().getAllPurchasedProducts().put(product,quantity);
        addToGlobalPurchasedHistory(costumer.getPurchasedHistory());
    }

    public void removeFromCostumerHistory(Costumer costumer,Product product){
        costumer.getPurchasedHistory().getAllPurchasedProducts().remove(product);
    }

    public Map<Product,Integer> showACostumerPurchaseHistory(Costumer costumer){
        return costumer.getPurchasedHistory().getAllPurchasedProducts();
    }
}
