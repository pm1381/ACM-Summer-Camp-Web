package ir.ac.kntu.models.goodsRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.ac.kntu.models.userRelated.Costumer;
import ir.ac.kntu.repositories.CommentRepository;

import java.util.ArrayList;
import java.util.Objects;

public class Product {
    @JsonIgnore
    private int id;
    private String name;
    private int price;
    private int year;
    private String company;
    private int quantity;
    private double rating;
    private final ArrayList<Comment> comments;
    private Category category;

    public Product(String name, int price, int year, String company, int quantity,
                   double rating, String categoryName) {
        this.name = name;
        this.price = price;
        this.year = year;
        this.company = company;
        this.quantity = quantity;
        this.rating = rating;
        comments = new ArrayList<>();
        category = new Category(categoryName);
    }

    public Product() {
        comments = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getRating() {
        return rating;
    }

    public Comment findAComment(int commentId){
        return CommentRepository.getInstance().findComment(this,commentId);
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void addAComment(Costumer costumer,String description){
        CommentRepository.getInstance().addComment(this,costumer,description);
    }

    public void removeAComment(int commentId){
        CommentRepository.getInstance().removeComment(this,commentId);
    }

    public void updateAComment(int id,String description){
        Comment oldComment = findAComment(id);
        CommentRepository.getInstance().updateComment(description,oldComment);
    }

    public void positiveScoreToAComment(Comment comment){
        if(! comments.contains(comment)){
            return;
        }
        comment.getScore().setPositiveScore();
    }

    public Comment findComment(int commentId){
        for(Comment comment : comments){
            if(comment.getId() == commentId){
                return comment;
            }
        }
        return null;
    }

    public void negativeScoreToComment(Comment comment){
        if(! comments.contains(comment)){
            return;
        }
        comment.getScore().setNegativeScore();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId() == product.getId() && getPrice() == product.getPrice() &&
                getYear() == product.getYear()
                && Double.compare(product.getRating(), getRating()) == 0 &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getCompany(), product.getCompany()) &&
                Objects.equals(getCategory(), product.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getYear(), getCompany(),
                getRating(), getCategory());
    }
}
