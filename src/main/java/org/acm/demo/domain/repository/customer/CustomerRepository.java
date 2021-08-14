package org.acm.demo.domain.repository.customer;

import org.acm.demo.domain.data.Customer;

import java.util.List;
import java.util.Optional;

/**
 * @author : Bahar Zolfaghari
 **/
public interface CustomerRepository {
    void saveCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Optional<Customer> getCustomerByEmail(String email);
    Customer getCostumerById(int id);
    Optional<Customer> getCustomerByEmailAndPassword(String email, String password);
    List<Customer> getAllCustomers();
}
