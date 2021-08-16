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
    private final List<PurchaseHistory> purchaseHistories = new ArrayList<>();
    private static PurchaseHistoryRepository purchaseHistoryRepository;

    private PurchaseHistoryRepositoryImpl() {
    }

    public static PurchaseHistoryRepository getPurchaseHistoryRepository() {
        if (Objects.isNull(purchaseHistoryRepository)) {
            purchaseHistoryRepository = new PurchaseHistoryRepositoryImpl();
        }
        return purchaseHistoryRepository;
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
    public List<PurchaseHistory> getPurchaseHistoriesByCustomer(Customer customer) {
        return purchaseHistories.stream().filter(purchaseHistory -> purchaseHistory.getId().equals(customer.getId()))
                .collect(Collectors.toList());
    }
}
