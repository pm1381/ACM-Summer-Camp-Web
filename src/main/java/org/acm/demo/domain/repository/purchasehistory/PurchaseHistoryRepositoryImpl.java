package org.acm.demo.domain.repository.purchasehistory;

import org.acm.demo.domain.data.Customer;
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
    public void updatePurchaseHistory(PurchaseHistory purchaseHistory) {
        purchaseHistories.removeIf(p -> p.getId().equals(purchaseHistory.getId()));
        purchaseHistories.add(purchaseHistory);
    }

    @Override
    public List<PurchaseHistory> getPurchaseHistoriesByCustomer(Customer customer) {
        return purchaseHistories.stream().filter(purchaseHistory -> purchaseHistory.getCart().getCustomer().equals(customer))
                .collect(Collectors.toList());
    }

    @Override
    public Integer getLastPurchaseHistoriesId() {
        if (purchaseHistories.isEmpty()) {
            return 0;
        }
        int lastCustomerIndex = purchaseHistories.size() - 1;
        return purchaseHistories.get(lastCustomerIndex).getId();
    }
}
