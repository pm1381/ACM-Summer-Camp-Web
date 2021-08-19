package org.acm.demo.controller;

import org.acm.demo.domain.data.Comment;
import org.acm.demo.domain.data.Customer;
import org.acm.demo.domain.data.PurchaseHistory;
import org.acm.demo.domain.repository.cart.CartRepository;
import org.acm.demo.domain.repository.cart.CartRepositoryImpl;
import org.acm.demo.domain.repository.comment.CommentRepository;
import org.acm.demo.domain.repository.comment.CommentRepositoryImpl;
import org.acm.demo.domain.repository.customer.CustomerRepository;
import org.acm.demo.domain.repository.customer.CustomerRepositoryImpl;
import org.acm.demo.domain.repository.purchasehistory.PurchaseHistoryRepository;
import org.acm.demo.domain.repository.purchasehistory.PurchaseHistoryRepositoryImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author : Parham Minouian
 **/

@RestController
@RequestMapping("/dashBoard")
public class DashBoardController {
    private final CustomerRepository customerRepository = CustomerRepositoryImpl.getCustomerRepository();
    private final CommentRepository commentRepository = CommentRepositoryImpl.getInstance();
    private final PurchaseHistoryRepository purchaseHistoryRepository =
            PurchaseHistoryRepositoryImpl.getPurchaseHistoryRepository();

    @GetMapping("{costumerId}")
    public Customer showCostumer(@PathVariable("costumerId") int id){
        return customerRepository.getCostumerById(id);
    }

    @GetMapping("email/{email}")
    public Customer showCostumerByEmail(@PathVariable("email") String email){
        if(customerRepository.getCustomerByEmail(email).isPresent()){
            return customerRepository.getCustomerByEmail(email).get();
        }
        return null;
    }

    @PatchMapping("{costumerId}")
    public void updateDatum(@PathVariable("costumerId") int id,@RequestBody Customer searchedCostumer){
        customerRepository.updateCustomer(searchedCostumer,id);
    }

    @DeleteMapping("{costumerId}")
    public void deleteCostumer(@PathVariable("costumerId") int id){
        Customer searchedCostumer = customerRepository.getCostumerById(id);
        customerRepository.deleteCustomer(searchedCostumer);
    }

    @GetMapping("history/{id}")
    public List<PurchaseHistory> showHistory(@PathVariable("id") int id){
        Customer searchedCostumer = customerRepository.getCostumerById(id);
        return purchaseHistoryRepository.getPurchaseHistoriesByCustomer(searchedCostumer);
    }

    @DeleteMapping("history/{costumerId}/{historyNumber}")
    public void deleteHistory(@PathVariable("costumerId") int id,@PathVariable("historyNumber") int number){
        Customer searchedCostumer = customerRepository.getCostumerById(id);
        PurchaseHistory purchaseHistory = purchaseHistoryRepository.
                getPurchaseHistoriesByCustomer(searchedCostumer).get(number);
        purchaseHistoryRepository.deletePurchaseHistory(purchaseHistory,searchedCostumer);
    }

    @GetMapping("credit/{id}")
    public Long showCostumerBalance(@PathVariable("id") int id){
        Customer searchedCostumer = customerRepository.getCostumerById(id);
        return searchedCostumer.getCredit().getBalance();
    }

    @PostMapping("credit/addToCredit/{id}/amount")
    public void addToCredit(@PathVariable("id") int id,@RequestBody Long money){
        Customer searchedCostumer = customerRepository.getCostumerById(id);
        searchedCostumer.getCredit().setBalance(money);
        System.out.println(searchedCostumer.getCredit().getBalance());
    }

    @GetMapping("showComments/{id}")
    public List<Comment> showCostumerComments(@PathVariable("id") int id){
        Customer searchedCostumer = customerRepository.getCostumerById(id);
        return commentRepository.getCommentsByCustomer(searchedCostumer);
    }
}
