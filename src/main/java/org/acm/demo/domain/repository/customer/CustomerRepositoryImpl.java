package org.acm.demo.domain.repository.customer;

import org.acm.demo.domain.data.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author : Bahar Zolfaghari & Parham
 **/
public class CustomerRepositoryImpl implements CustomerRepository {
    private final List<Customer> customers = new ArrayList<>();
    private CustomerRepository customerRepository;
    private static int costumerId =1;

    private CustomerRepositoryImpl() {
    }

    public CustomerRepository getCustomerRepository() {
        if (Objects.isNull(customerRepository)) {
            customerRepository = new CustomerRepositoryImpl();
        }
        return customerRepository;
    }

    @Override
    public void saveCustomer(Customer customer) {
        customer.setId(costumerId++);
        customer.setInitials(customer.getId());
        customers.add(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customers.remove(customer);
    }

    @Override
    public void updateCustomer(Customer costumer,int id) {
        Customer oldCostumer = getCostumerById(id);
        if(oldCostumer == null){
            return;
        }
        oldCostumer.setEmail(costumer.getEmail());
        oldCostumer.setFamily(costumer.getFamily());
        oldCostumer.setName(costumer.getName());
        oldCostumer.setPassword(costumer.getPassword());
        oldCostumer.setPhone(costumer.getPhone());
    }

    @Override
    public Optional<Customer> getCustomerByEmail(String email) {
        return customers.stream().filter(customer -> customer.getEmail().equals(email)).findFirst();
    }

    @Override
    public Customer getCostumerById(int id){
        for(Customer costumer : customers){
            if(id == costumer.getId()){
                return costumer;
            }
        }
        return null;
    }

    @Override
    public Optional<Customer> getCustomerByEmailAndPassword(String email, String password) {
        return customers.stream().filter(customer -> customer.getEmail().equals(email) &&
                customer.getPassword().equals(email)).findFirst();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }
}


/*
    @Override
    public void updateCustomer(Customer customer) {
        customers.removeIf(c -> c.getId().equals(customer.getId()));
        customers.add(customer);
    }
 */
