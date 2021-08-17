package org.acm.demo.controller;

import org.acm.demo.domain.data.Comment;
import org.acm.demo.domain.data.Product;
import org.acm.demo.domain.repository.comment.CommentRepository;
import org.acm.demo.domain.repository.comment.CommentRepositoryImpl;
import org.acm.demo.domain.repository.customer.CustomerRepository;
import org.acm.demo.domain.repository.customer.CustomerRepositoryImpl;
import org.acm.demo.domain.repository.product.ProductRepository;
import org.acm.demo.domain.repository.product.ProductRepositoryImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Miss Taheri
 **/
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository= ProductRepositoryImpl.getProductRepository();
    private final CommentRepository commentRepository= CommentRepositoryImpl.getInstance();
    private final CustomerRepository customerRepository = CustomerRepositoryImpl.getCustomerRepository();

    @GetMapping
    public List<Product> showAllProducts() {
        return productRepository.getProducts();
    }

    @GetMapping("/id/{productId}")
    public Product getProductById(@PathVariable("productId") int id){
        return productRepository.getProductById(id);
    }

    @GetMapping("/company/{company}")
    public List<Product> getProductByCompany(@PathVariable("company") String company){
        return productRepository.getProductsByCompany(company);
    }

    @GetMapping("/category/{categoryName}")
    public List<Product> getProductByCategory(@PathVariable("categoryName") String category){
        return productRepository.getProductsByCategory(category);
    }

    @PostMapping
    public void addToProducts(@RequestBody Product product){
        productRepository.saveProduct(product);
    }

    @PatchMapping("{productId}")
    public void updateProduct(@PathVariable("productId") int id,@RequestBody Product product){
        productRepository.updateProduct(id,product);
    }

    @DeleteMapping("{productId}")
    public void deleteProduct(@PathVariable("productId") int id){
        productRepository.deleteProduct(productRepository.getProductById(id));
    }

    @PostMapping("comment/{productId}/{costumerId}")
    public void AddComment(@PathVariable("costumerId") int costumerId, @PathVariable("productId") int productId, @RequestBody String commentText){
        commentRepository.saveComment(productRepository.getProductById(productId),customerRepository.getCostumerById(costumerId),commentText);
    }

    @GetMapping("comment/{productId}")
    public List<Comment> getProductComments(@PathVariable("productId") int id){
        return productRepository.getProductById(id).getComments();
    }

    @DeleteMapping("comment/{productId}/{commentId}")
    public void DeleteProductComment(@PathVariable("commentId") int commentId, @PathVariable("productId") int productId){
        productRepository.getProductById(productId).removeComment(commentId);
    }

    @PatchMapping("comment/{productId}/{commentId}")
    public void EditProductComment(@PathVariable("commentId") int commentId, @PathVariable("productId") int productId, @RequestBody String commentText){
        productRepository.getProductById(productId).updateAComment(commentId,commentText);
    }

    @PostMapping("{productId}/costumer/{costumerId}")
    public void addProductToCart(@PathVariable("costumerId") int costumerId, @PathVariable("productId") int productId, @RequestBody int quantity){
        Product product=productRepository.getProductById(productId);
        customerRepository.getCostumerById(costumerId).getCart().addToCart(quantity,product);
    }
}
