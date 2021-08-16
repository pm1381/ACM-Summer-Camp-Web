package org.acm.demo.controller;

import org.acm.demo.domain.data.Cart;
import org.acm.demo.domain.data.Customer;
import org.acm.demo.domain.data.Product;
import org.acm.demo.domain.repository.customer.CustomerRepository;
import org.acm.demo.domain.repository.customer.CustomerRepositoryImpl;
import org.acm.demo.domain.repository.product.ProductRepository;
import org.acm.demo.domain.repository.product.ProductRepositoryImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Bahar Zolfaghari
 **/
@RestController
@RequestMapping("/customer-cart")
public class CustomerCartController {
    private final CustomerRepository customerRepository = CustomerRepositoryImpl.getCustomerRepository();
    private final ProductRepository productRepository = ProductRepositoryImpl.getProductRepository();

    @GetMapping("{customerId}")
    public Cart getCartCustomer(@PathVariable Integer customerId) {
        Customer customer = customerRepository.getCostumerById(customerId);
        return customer.getCart();
    }

    @GetMapping("/pay/{customerId}")
    public String payCart(@PathVariable Integer customerId) {
        Customer customer = customerRepository.getCostumerById(customerId);
        customer.getCart().pay();
        return "Payment was successful";
    }

    @GetMapping("/{customerId}/cart/remove/product/{productId}")
    public String removeProductFromCart(@PathVariable Integer customerId, @PathVariable Integer productId) {
        Customer customer = customerRepository.getCostumerById(customerId);
        Product product = productRepository.getProductById(productId);
        if (customer.getCart().getProducts().containsKey(product)) {
            customer.getCart().getProducts().remove(product);
            return "Product successfully removed from cart.";
        }
        else {
            return "This product is not in your cart!";
        }
    }
}
