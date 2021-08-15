package org.acm.demo.domain.repository.cart;

import org.acm.demo.domain.data.Cart;
import org.acm.demo.domain.data.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author : Bahar Zolfaghari
 **/
public class CartRepositoryImpl implements CartRepository {
    private final List<Cart> carts = new ArrayList<>();
    private static CartRepository cartRepository;

    private CartRepositoryImpl() {

    }

    public static CartRepository getCartRepository() {
        if (Objects.isNull(cartRepository)) {
            cartRepository = new CartRepositoryImpl();
        }
        return cartRepository;
    }

    @Override
    public void saveCart(Cart cart) {
        carts.add(cart);
    }

    @Override
    public void deleteCart(Cart cart) {
        carts.remove(cart);
    }

    @Override
    public void updateCart(Cart cart) {
        carts.removeIf(c -> c.getId().equals(cart.getId()));
        carts.add(cart);
    }

    @Override
    public Optional<Cart> getCartByCustomer(Customer customer) {
        return carts.stream().filter(cart -> cart.getCustomer().equals(customer)).findFirst();
    }

    @Override
    public Integer getLastCartId() {
        if (carts.isEmpty()) {
            return 0;
        }
        int lastCustomerIndex = carts.size() - 1;
        return carts.get(lastCustomerIndex).getId();
    }
}
