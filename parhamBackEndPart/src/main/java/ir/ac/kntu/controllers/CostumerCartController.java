package ir.ac.kntu.controllers;

import ir.ac.kntu.models.goodsRelated.Product;
import ir.ac.kntu.models.userRelated.Costumer;
import ir.ac.kntu.repositories.CartRepository;
import ir.ac.kntu.repositories.CostumerRepository;
import ir.ac.kntu.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CostumerCartController {
    @GetMapping("{id}")
    public Map<Product,Integer> showCartSituation(@PathVariable("id") int id){
        Costumer searchedCostumer = CostumerRepository.getInstance().getCostumerById(id);
        return searchedCostumer.getCart().getCostumerBasket();
    }

    @GetMapping("pay/{id}")
    public int pay(@PathVariable("id") int id){
        Costumer searchedCostumer = CostumerRepository.getInstance().getCostumerById(id);
        searchedCostumer.getCart().pay();
        return searchedCostumer.getCredit().getBalance();
    }

    @GetMapping("remove/{costumerId}/product/{productId}")
    public void removeFromBasket(@PathVariable("costumerId") int costumerId,@PathVariable("productId") int productId){
        Costumer searchedCostumer = CostumerRepository.getInstance().getCostumerById(costumerId);
        Product searchedProduct = ProductRepository.getInstance().getProductById(productId);
        CartRepository.getInstance().removeFromCart(searchedProduct,searchedCostumer);
    }

    @GetMapping("refer/{id}/{productId}")
    public Product referToAProduct(@PathVariable("id") int id,@PathVariable("productId") int productId){
        Costumer searchedCostumer = CostumerRepository.getInstance().getCostumerById(id);
        return searchedCostumer.referToProductPage(productId);
    }
}
