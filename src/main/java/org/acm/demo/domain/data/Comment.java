package org.acm.demo.domain.data;

/**
 * @author : Bahar Zolfaghari
 **/
public class Comment {
    private Integer id;
    private Customer customer;
    private String description;
    private Integer like;
    private Integer dislike;

    public Integer getId() {
        return id;
    }

    public Comment setId(Integer id) {
        this.id = id;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Comment setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Comment setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getLike() {
        return like;
    }

    public Comment setLike() {
        like++;
        return this;
    }

    public Integer getDislike() {
        return dislike;
    }

    public Comment setDislike() {
        dislike++;
        return this;
    }
}
