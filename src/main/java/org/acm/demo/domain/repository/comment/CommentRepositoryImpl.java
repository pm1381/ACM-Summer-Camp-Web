package org.acm.demo.domain.repository.comment;

import org.acm.demo.domain.data.Comment;
import org.acm.demo.domain.data.Customer;
import org.acm.demo.domain.data.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : Bahar Zolfaghari & Parham
 **/
public class CommentRepositoryImpl implements CommentRepository {
    private final List<Comment> comments = new ArrayList<>();
    private static CommentRepository instance = null;
    private static int lastId = 111;

    private CommentRepositoryImpl() {
    }

    public static CommentRepository getInstance() {
        if(instance == null){
            instance = new CommentRepositoryImpl();
        }
        return instance;
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
    public void updateComment(Comment comment,String description) {
        comment.setDescription(description);
    }

    @Override
    public Comment getCommentById(Product product, int id) {
        for (Comment comment : product.getComments()){
            if(id == comment.getId()){
                return comment;
            }
        }
        return null;
    }

    @Override
    public List<Comment> getCommentsByCustomer(Customer customer) {
        return comments.stream().filter(comment -> comment.getCustomer().equals(customer)).collect(Collectors.toList());
    }
}
