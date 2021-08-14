package org.acm.demo.domain.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Bahar Zolfaghari
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
    private Integer rating = 5; // all have rating 5 at FIRST
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

    public Product setRating(Integer rating) {
        this.rating = rating;
        return this;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
