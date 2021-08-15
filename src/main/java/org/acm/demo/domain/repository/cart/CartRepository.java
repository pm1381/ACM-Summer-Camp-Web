package org.acm.demo.domain.repository.cart;

import org.acm.demo.domain.data.Cart;
import org.acm.demo.domain.data.Customer;

import java.util.Optional;

/**
 * @author : Bahar Zolfaghari
 **/
public interface CartRepository {
    void saveCart(Cart cart);
    void deleteCart(Cart cart);
    void updateCart(Cart cart);
    Optional<Cart> getCartByCustomer(Customer customer);
    Integer getLastCartId();
}
