package org.acm.demo.domain.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
public class Product {
    private Integer id;
    private String name;
    private Long price;
    private Integer year;
    private String company;
    private Integer quantity;
    private String category;
    private Integer rating;
    private List<Comment> comments = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public Product setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPrice() {
        return price;
    }

    public Product setPrice(Long price) {
        this.price = price;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public Product setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Product setCompany(String company) {
        this.company = company;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Product setCategory(String category) {
        this.category = category;
        return this;
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

    public Product setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }
}
