package org.acm.demo.controller;

import org.acm.demo.domain.data.*;
import org.acm.demo.domain.repository.cart.CartRepository;
import org.acm.demo.domain.repository.cart.CartRepositoryImpl;
import org.acm.demo.domain.repository.credit.CreditRepository;
import org.acm.demo.domain.repository.credit.CreditRepositoryImpl;
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
    private final CreditRepository creditRepository = CreditRepositoryImpl.getCreditRepository();
    private final CartRepository cartRepository = CartRepositoryImpl.getCartRepository();
    private final PurchaseHistoryRepository purchaseHistoryRepository= PurchaseHistoryRepositoryImpl.getPurchaseHistoryRepository();

    @PostMapping("/register")
    public String registerCustomer(@RequestBody User user) {
        //ToDo: check duplicate customer using email
        Credit credit = new Credit();
        credit.setId(creditRepository.getLastCreditId() + 1);
        creditRepository.saveCredit(credit);
        Cart cart = new Cart();
        cart.setId(cartRepository.getLastCartId() + 1);
        cartRepository.saveCart(cart);
        PurchaseHistory purchaseHistory = new PurchaseHistory();
        purchaseHistory.setId(purchaseHistoryRepository.getLastPurchaseHistoriesId() + 1);
        purchaseHistoryRepository.savePurchaseHistory(purchaseHistory);
        Customer customer = new Customer();
        customer.setCredit(credit)
                .setCart(cart)
                .setPurchaseHistory(purchaseHistory)
                .setId(customerRepository.getLastCustomerId() + 1)
                .setName(user.getName())
                .setFamily(user.getFamily())
                .setPhone(user.getPhone())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setRole(Role.CUSTOMER);
        customerRepository.saveCustomer(customer);
        return "Your registration was successful.";
    }

    @PostMapping("/login")
    public String loginCustomer(@RequestBody String body) {
        //login body -> email: [email], password: [password]
        String[] tokens = body.split(", ");
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
