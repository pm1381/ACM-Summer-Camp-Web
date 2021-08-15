package org.acm.demo.domain.repository.purchasehistory;

import org.acm.demo.domain.data.Customer;
import org.acm.demo.domain.data.PurchaseHistory;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
public interface PurchaseHistoryRepository {
    void savePurchaseHistory(PurchaseHistory purchaseHistory);
    void deletePurchaseHistory(PurchaseHistory purchaseHistory);
    void updatePurchaseHistory(PurchaseHistory purchaseHistory);
    List<PurchaseHistory> getPurchaseHistoriesByCustomer(Customer customer);
    Integer getLastPurchaseHistoriesId();
}
