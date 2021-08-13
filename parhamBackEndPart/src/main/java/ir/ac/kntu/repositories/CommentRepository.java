package ir.ac.kntu.repositories;

import ir.ac.kntu.models.goodsRelated.Comment;
import ir.ac.kntu.models.goodsRelated.Product;
import ir.ac.kntu.models.userRelated.Costumer;

import java.util.ArrayList;

public class CommentRepository {
    private static CommentRepository instance = null;
    private ArrayList<Comment> globalComments = new ArrayList<>();
    private static int lastId = 111;

    private CommentRepository() {
    }

    public static CommentRepository getInstance(){
        if(instance == null){
            instance = new CommentRepository();
        }
        return instance;
    }

    public ArrayList<Comment> getGlobalComments() {
        return globalComments;
    }

    public void addToGlobalComments(Comment comment){
        globalComments.add(comment);
    }

    public void removeCommentFromGlobal(int commentId){
        getGlobalComments().removeIf(comment -> commentId == comment.getId());
    }

    public ArrayList<Comment> showACostumerComments(Costumer costumer){
        ArrayList<Comment> costumerComments = new ArrayList<>();
        for(Comment comment : globalComments){
            if(comment.getCostumer().equals(costumer)){
                costumerComments.add(comment);
            }
        }
        return costumerComments;
    }

    public Comment findComment(Product product, int id){
        for (Comment comment : product.getComments()){
            if(id == comment.getId()){
                return comment;
            }
        }
        return null;
    }

    public void addComment(Product product,Costumer costumer,String description){
        Comment comment = new Comment(lastId++,costumer,description);
        product.getComments().add(comment);
        addToGlobalComments(comment);
    }

    public void removeComment(Product product,int commentId){
        product.getComments().removeIf(comment -> commentId == comment.getId());
        removeCommentFromGlobal(commentId);
    }

    public void updateComment(String description, Comment oldComment) {
        oldComment.setDescription(description);
    }
}
