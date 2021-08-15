package org.acm.demo.domain.repository.comment;

import org.acm.demo.domain.data.Comment;
import org.acm.demo.domain.data.Customer;
import org.acm.demo.domain.data.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : Bahar Zolfaghari
 **/
public class CommentRepositoryImpl implements CommentRepository {
    private final List<Comment> comments = new ArrayList<>();
    private CommentRepository commentRepository;
    private static int lastId = 111;

    private CommentRepositoryImpl() {

    }

    public CommentRepository getCommentRepository() {
        if (Objects.isNull(commentRepository)) {
            commentRepository = new CommentRepositoryImpl();
        }
        return commentRepository;
    }

    @Override
    public void saveComment(Product product, Customer costumer, String description) {
        product.getComments().add(new Comment(lastId++,costumer,description));
    }

    @Override
    public void deleteComment(Product product,int commentId) {
        product.getComments().removeIf(comment -> commentId == comment.getId());
    }

    @Override
    public void updateComment(Comment comment) {
        comments.removeIf(c -> c.getId().equals(comment.getId()));
        comments.add(comment);
    }

    @Override
    public List<Comment> getCommentsByCustomer(Customer customer) {
        return comments.stream().filter(comment -> comment.getCustomer().equals(customer)).collect(Collectors.toList());
    }
}
