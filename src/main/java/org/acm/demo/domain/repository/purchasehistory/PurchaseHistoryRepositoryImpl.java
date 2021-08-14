package org.acm.demo.domain.repository.purchasehistory;

import org.acm.demo.domain.data.Customer;
import org.acm.demo.domain.data.Product;
import org.acm.demo.domain.data.PurchaseHistory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : Bahar Zolfaghari
 **/
public class PurchaseHistoryRepositoryImpl implements PurchaseHistoryRepository {
    private List<PurchaseHistory> purchaseHistories = new ArrayList<>();
    private PurchaseHistoryRepository purchaseHistoryRepository;

    private PurchaseHistoryRepositoryImpl() {

    }

    public List<PurchaseHistory> getPurchaseHistories() {
        if (Objects.isNull(purchaseHistoryRepository)) {
            purchaseHistoryRepository = new PurchaseHistoryRepositoryImpl();
        }
        return purchaseHistories;
    }

    @Override
    public void savePurchaseHistory(PurchaseHistory purchaseHistory) {
        purchaseHistories.add(purchaseHistory);
    }

    @Override
    public void deletePurchaseHistory(PurchaseHistory purchaseHistory) {
        purchaseHistories.remove(purchaseHistory);
    }

    @Override
    public void deleteAnItemFromHistory(Customer customer, Product product) {
        customer.getPurchaseHistory().getAllPurchasedProducts().remove(product);
    }

    @Override
    public List<PurchaseHistory> getPurchaseHistoriesByCustomer(Customer customer) {
        return purchaseHistories.stream().filter(purchaseHistory -> purchaseHistory.getId().equals(customer.getId()))
                .collect(Collectors.toList());
    }
}
