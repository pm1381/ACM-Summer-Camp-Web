package org.acm.demo.controller;

import org.acm.demo.domain.data.*;
import org.acm.demo.domain.repository.cart.CartRepository;
import org.acm.demo.domain.repository.cart.CartRepositoryImpl;
import org.acm.demo.domain.repository.customer.CustomerRepository;
import org.acm.demo.domain.repository.customer.CustomerRepositoryImpl;
import org.acm.demo.domain.repository.purchasehistory.PurchaseHistoryRepository;
import org.acm.demo.domain.repository.purchasehistory.PurchaseHistoryRepositoryImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author : Bahar Zolfaghari
 **/
@RestController
@RequestMapping("/home")
public class HomeController {
    private final CustomerRepository customerRepository = CustomerRepositoryImpl.getCustomerRepository();
    private final CartRepository cartRepository = CartRepositoryImpl.getCartRepository();
    private final PurchaseHistoryRepository purchaseHistoryRepository= PurchaseHistoryRepositoryImpl.getPurchaseHistoryRepository();

    @PostMapping("register")
    public String registerCustomer(@RequestBody Customer customer) {
        customerRepository.saveCustomer(customer);
        cartRepository.saveCart(customer.getCart());
        return "Your registration was successful.";
    }

    @PostMapping("login")
    public String loginCustomer(@RequestBody String body) {
        //login body -> email: [email], password: [password]
        String[] tokens = body.split(", ");
        //System.out.println(tokens[0]+ " " + tokens[1]);
        String email = tokens[0].split(": ")[1];
        String password = tokens[1].split(": ")[1];
        Optional<Customer> customerByEmailAndPassword = customerRepository.getCustomerByEmailAndPassword(email, password);
        if (customerByEmailAndPassword.isPresent()) {
            return ("You have logged in successfully.");
        }
        else {
            return "Email and password not matched! Try again!";
        }
    }
}
