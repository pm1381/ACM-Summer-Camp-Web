package org.acm.demo.domain.repository.comment;

import org.acm.demo.domain.data.Comment;
import org.acm.demo.domain.data.Customer;
import org.acm.demo.domain.data.Product;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
public interface CommentRepository {
    void saveComment(Product product, Customer costumer, String description);
    void deleteComment(Product product,int commentId);
    void updateComment(Comment comment,String description);
    Comment getCommentById(Product product, int id);
    List<Comment> getCommentsByCustomer(Customer customer);
    Integer getLastCommentId();
}
