package ir.ac.kntu.controllers;

import ir.ac.kntu.models.goodsRelated.Comment;
import ir.ac.kntu.models.goodsRelated.Product;
import ir.ac.kntu.models.userRelated.Costumer;
import ir.ac.kntu.repositories.CommentRepository;
import ir.ac.kntu.repositories.CostumerRepository;
import ir.ac.kntu.repositories.ProductRepository;
import ir.ac.kntu.repositories.PurchaseHistoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashBoardController {
    @GetMapping("{id}")
    public Costumer showCostumer(@PathVariable("id") int id){
        return CostumerRepository.getInstance().getCostumerById(id);
    }

    @GetMapping("{email}")
    public Costumer showCostumerByEmail(@PathVariable("email") String email){
        return CostumerRepository.getInstance().getCostumerByEmail(email);
    }

    @PatchMapping("{id}")
    public void updateDatum(@PathVariable("id") int id,@RequestBody Costumer newCostumer){
        CostumerRepository.getInstance().updateCostumer(id,newCostumer);
    }

    @DeleteMapping("{id}")
    public void deleteACostumer(@PathVariable("id") int id){
        CostumerRepository.getInstance().deleteCostumer(id);
    }

    @GetMapping("history/{id}")
    public Map<Product,Integer> showHistory(@PathVariable("id") int id){
        Costumer searchedCostumer = CostumerRepository.getInstance().getCostumerById(id);
        return PurchaseHistoryRepository.getInstance().showACostumerPurchaseHistory(searchedCostumer);
    }

    @DeleteMapping("history/{costumerId}/product/{productId}")
    public void deleteFromHistory(@PathVariable("costumerId") int id,@PathVariable("productId") int productId){
        Costumer searchedCostumer = CostumerRepository.getInstance().getCostumerById(id);
        Product searchedProduct = ProductRepository.getInstance().getProductById(productId);
        PurchaseHistoryRepository.getInstance().removeFromCostumerHistory(searchedCostumer,searchedProduct);
    }

    @GetMapping("credit/{id}")
    public int showCostumerBalance(@PathVariable("id") int id){
        Costumer searchedCostumer = CostumerRepository.getInstance().getCostumerById(id);
        return searchedCostumer.getCredit().getBalance();
    }

    @GetMapping("credit/addToCredit/{id}/amount/{money}")
    public void addTOCredit(@PathVariable("id") int id,@PathVariable("money") int money){
        Costumer searchedCostumer = CostumerRepository.getInstance().getCostumerById(id);
        searchedCostumer.getCredit().setBalance(money);
        System.out.println(searchedCostumer.getCredit().getBalance());
    }

    @GetMapping("showComments/{id}")
    public ArrayList<Comment> showCostumerComments(@PathVariable("id") int id){
        Costumer searchedCostumer = CostumerRepository.getInstance().getCostumerById(id);
        return CommentRepository.getInstance().showACostumerComments(searchedCostumer);
    }
}
