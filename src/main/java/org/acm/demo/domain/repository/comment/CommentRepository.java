package org.acm.demo.domain.repository.comment;

import org.acm.demo.domain.data.Comment;
import org.acm.demo.domain.data.Customer;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
public interface CommentRepository {
    void saveComment(Comment comment);
    void deleteComment(Comment comment);
    void updateComment(Comment comment);
    List<Comment> getCommentsByCustomer(Customer customer);
}
