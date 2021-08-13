package ir.ac.kntu.controllers;

import ir.ac.kntu.models.goodsRelated.Comment;
import ir.ac.kntu.models.goodsRelated.Product;
import ir.ac.kntu.models.userRelated.Costumer;
import ir.ac.kntu.repositories.CostumerRepository;
import ir.ac.kntu.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @GetMapping
    public ArrayList<Product> showAllProducts(){
        return ProductRepository.getInstance().getProducts();
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable("id") int id){
        return ProductRepository.getInstance().getProductById(id);
    }

    @GetMapping("{company}")
    public Product getProductByCompany(@PathVariable("company") String company){
        return ProductRepository.getInstance().getProductByCompany(company);
    }

    @GetMapping("{categoryName}")
    public Product getProductByCategory(@PathVariable("categoryName") String categoryName){
        return ProductRepository.getInstance().getProductByCategory(categoryName);
    }

    @PostMapping
    public void addToProducts(@RequestBody Product product){
        ProductRepository.getInstance().addToProducts(product);
    }

    @PatchMapping("{id}")
    public void updateAProduct(@PathVariable("id") int id,@RequestBody Product product){
        ProductRepository.getInstance().updateProduct(id, product);
    }

    @DeleteMapping("{id}")
    public void deleteAProduct(@PathVariable("id") int id){
        Product searchedProduct = ProductRepository.getInstance().getProductById(id);
        ProductRepository.getInstance().deleteFromProducts(searchedProduct);
    }

    @PostMapping("comment/{costumerId}/{productId}")
    public void addToProductComments(@PathVariable("costumerId") int costumerId,
                                     @PathVariable("productId") int productId,
                                     @RequestBody String description){
        Product searchedProduct = ProductRepository.getInstance().getProductById(productId);
        Costumer searchedCostumer = CostumerRepository.getInstance().getCostumerById(costumerId);
        searchedProduct.addAComment(searchedCostumer,description);
    }

    @GetMapping("comment/{productId}")
    public ArrayList<Comment> showAProductComments(@PathVariable("productId") int productId){
        Product searchedProduct = ProductRepository.getInstance().getProductById(productId);
        return searchedProduct.getComments();
    }

    @DeleteMapping("comment/{productId}/{commentId}")
    public void deleteAComment(@PathVariable("productId") int productId,
                               @PathVariable("commentId") int commentId){
        Product searchedProduct = ProductRepository.getInstance().getProductById(productId);
        searchedProduct.removeAComment(commentId);
    }

    @PatchMapping("comment/{productId}/{commentId}")
    public void updateAComment(@RequestBody String newDescription,
                               @PathVariable("commentId") int commentId,
                               @PathVariable("productId") int productId){
        Product searchedProduct = ProductRepository.getInstance().getProductById(productId);
        searchedProduct.updateAComment(commentId,newDescription);
    }

    @GetMapping("comment/positiveScore/{productId}")
    public int showPositiveScoreToComment(@PathVariable("productId") int productId,
                                          @PathVariable("commentId") int commentId){
        Product searchedProduct = ProductRepository.getInstance().getProductById(productId);
        Comment searchedComment = searchedProduct.findComment(commentId);
        searchedProduct.positiveScoreToAComment(searchedComment);
        return searchedComment.getScore().getPositiveScore();
    }

    @GetMapping("comment/negativeScore/{productId}")
    public int showNegativeScoreToComment(@PathVariable("productId") int productId,
                                          @PathVariable("commentId") int commentId){
        Product searchedProduct = ProductRepository.getInstance().getProductById(productId);
        Comment searchedComment = searchedProduct.findComment(commentId);
        searchedProduct.negativeScoreToComment(searchedComment);
        return searchedComment.getScore().getNegativeScore() * (-1);
    }


}
