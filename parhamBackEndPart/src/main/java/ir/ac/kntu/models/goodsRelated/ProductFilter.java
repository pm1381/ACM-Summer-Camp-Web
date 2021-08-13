package ir.ac.kntu.models.goodsRelated;

import ir.ac.kntu.repositories.ProductRepository;
import ir.ac.kntu.sorts.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class ProductFilter {
    private final LinkedHashSet<Product> finalSearchedProducts;
    private int priceBottomLine = 0;
    private int priceUpperBound;
    private double ratingBottomLine = 0;
    private double ratingUpperBound;

    public ProductFilter() {
        finalSearchedProducts = new LinkedHashSet<>();
        setRatingAndPriceUpperBound();
    }

    private void setRatingAndPriceUpperBound() {
        ArrayList<Product> allProducts = new ArrayList<>(ProductRepository.getInstance().getProducts());
        allProducts.sort(new RatingDescendingSort());
        //Collections.sort(allProducts, new RatingDescendingSort());
        this.ratingUpperBound = allProducts.get(0).getRating();
        allProducts.sort(new PriceDescendingSort());
        //Collections.sort(allProducts, new PriceDescendingSort());
        this.priceUpperBound = allProducts.get(0).getPrice();
    }

    public int getPriceBottomLine() {
        return priceBottomLine;
    }

    public int getPriceUpperBound() {
        return priceUpperBound;
    }

    public double getRatingBottomLine() {
        return ratingBottomLine;
    }

    public double getRatingUpperBound() {
        return ratingUpperBound;
    }

    public ArrayList<Product> searchOnName(String name){
        ArrayList<Product> searchedProducts = new ArrayList<>();
        name = name.toLowerCase();
        name = name.trim();
        for(Product product : ProductRepository.getInstance().getProducts()){
            if(product.getName().contains(name)){
                searchedProducts.add(product);
            }
        }
        return searchedProducts;
    }

    public ArrayList<Product> searchOnCategory(Category category){
        for(Product product : ProductRepository.getInstance().getProducts()){
            if(category.equals(product.getCategory())){
                finalSearchedProducts.add(product);
            }
        }
        setRatingRange(getRatingBottomLine(),getRatingUpperBound());
        setPriceRange(getPriceBottomLine(),getPriceUpperBound());
        return new ArrayList<>(finalSearchedProducts);
    }

    public void deleteFromSearchedCategories(Category category){
        finalSearchedProducts.removeIf(product -> product.getCategory().equals(category));
    }

    public ArrayList<Product> searchedOnCompany(String company){
        for(Product product : ProductRepository.getInstance().getProducts()){
            if(company.equals(product.getCompany())){
                finalSearchedProducts.add(product);
            }
        }
        setRatingRange(getRatingBottomLine(),getRatingUpperBound());
        setPriceRange(getPriceBottomLine(),getPriceUpperBound());
        return new ArrayList<>(finalSearchedProducts);
    }

    public void deleteFromSearchedCompanies(String company){
        finalSearchedProducts.removeIf(product -> product.getCompany().equals(company));
    }

    public ArrayList<Product> setPriceRange(int lowerPrice,int upperPrice){
        this.priceBottomLine=lowerPrice;
        this.priceUpperBound=upperPrice;
        if(finalSearchedProducts.isEmpty()){
            for(Product product : ProductRepository.getInstance().getProducts()){
                if(product.getPrice() >= priceBottomLine && product.getPrice() <= priceUpperBound){
                    finalSearchedProducts.add(product);
                }
            }
        }else{
            finalSearchedProducts.removeIf(product ->
                    product.getPrice() < priceBottomLine || product.getPrice() > priceUpperBound);
        }
        return new ArrayList<>(finalSearchedProducts);
    }

    public ArrayList<Product> setRatingRange(double lowerRating,double upperRating){
        this.ratingBottomLine=lowerRating;
        this.ratingUpperBound=upperRating;
        if(finalSearchedProducts.isEmpty()){
            for(Product product : ProductRepository.getInstance().getProducts()){
                if(product.getRating() >= ratingBottomLine && product.getRating() <= ratingUpperBound){
                    finalSearchedProducts.add(product);
                }
            }
        }else{
            finalSearchedProducts.removeIf(product ->
                    product.getRating() < ratingBottomLine || product.getRating() > ratingUpperBound);
        }
        return new ArrayList<>(finalSearchedProducts);
    }
}

