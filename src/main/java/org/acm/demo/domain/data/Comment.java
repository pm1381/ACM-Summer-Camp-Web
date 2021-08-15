package org.acm.demo.domain.data;

import org.acm.demo.domain.repository.comment.CommentRepositoryImpl;

/**
 * @author : Bahar Zolfaghari
 **/
public class Comment {
    private Integer id;
    private Customer customer;
    private String description;
    private Integer like =0;
    private Integer dislike = 0;

    public Comment(Integer id,Customer customer, String description) {
        this.customer = customer;
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike() {
        like++;
    }

    public Integer getDislike() {
        return dislike;
    }

    public void setDislike() {
        dislike++;
    }
}
