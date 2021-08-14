package org.acm.demo.domain.repository.purchasehistory;

import org.acm.demo.domain.data.Customer;
import org.acm.demo.domain.data.Product;
import org.acm.demo.domain.data.PurchaseHistory;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
public interface PurchaseHistoryRepository {
    void savePurchaseHistory(PurchaseHistory purchaseHistory);
    void deletePurchaseHistory(PurchaseHistory purchaseHistory);
    void deleteAnItemFromHistory(Customer customer, Product product);
    List<PurchaseHistory> getPurchaseHistoriesByCustomer(Customer customer);
}
