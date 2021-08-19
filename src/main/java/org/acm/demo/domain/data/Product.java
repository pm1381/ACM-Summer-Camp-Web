package org.acm.demo.domain.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.acm.demo.domain.repository.comment.CommentRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Bahar Zolfaghari & Parham
 **/
public class Product {
    @JsonIgnore
    private Integer id;
    private String name;
    private Long price;
    private Integer year;
    private String company;
    private Integer quantity;
    private String category;
    private Integer rating = 5; // all products have rating 5 at FIRST
    private List<Comment> comments = new ArrayList<>();

    public Product(String name, Long price, Integer year, String company, Integer quantity, String category) {
        this.name = name;
        this.price = price;
        this.year = year;
        this.company = company;
        this.quantity = quantity;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    //TODO: ALL OF THESE METHODS BELOW MUST BE IN SERVICE LAYER
    public void addAComment(Customer costumer,String description){
        CommentRepositoryImpl.getInstance().saveComment(this,costumer,description);
    }

    public void removeComment(int commentId){
        CommentRepositoryImpl.getInstance().deleteComment(this,commentId);
    }

    public void updateAComment(int id,String description){
        Comment oldComment = CommentRepositoryImpl.getInstance().getCommentById(this,id);
        CommentRepositoryImpl.getInstance().updateComment(oldComment,description);
    }

    public void negativeScoreToComment(Comment comment){
        if(! comments.contains(comment)){
            return;
        }
        comment.setDislike();
    }

    public void positiveScoreToComment(Comment comment){
        if(! comments.contains(comment)){
            return;
        }
        comment.setLike();
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}
