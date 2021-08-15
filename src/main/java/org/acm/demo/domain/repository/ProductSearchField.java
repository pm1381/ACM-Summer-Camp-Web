package org.acm.demo.domain.repository;

/**
 * @author : Bahar Zolfaghari
 **/
public class ProductSearchField {
    private String name;
    private String category;
    private Long minPrice;
    private Long maxPrice;
    private String company;
    private Integer rating;

    public String getName() {
        return name;
    }

    public ProductSearchField setName(String name) {
        this.name = name;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductSearchField setCategory(String category) {
        this.category = category;
        return this;
    }

    public Long getMinPrice() {
        return minPrice;
    }

    public ProductSearchField setMinPrice(Long minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    public Long getMaxPrice() {
        return maxPrice;
    }

    public ProductSearchField setMaxPrice(Long maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public ProductSearchField setCompany(String company) {
        this.company = company;
        return this;
    }

    public Integer getRating() {
        return rating;
    }

    public ProductSearchField setRating(Integer rating) {
        this.rating = rating;
        return this;
    }
}
