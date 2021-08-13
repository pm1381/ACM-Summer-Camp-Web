package ir.ac.kntu.sorts;

import ir.ac.kntu.models.goodsRelated.Product;

import java.util.Comparator;

public class RatingDescendingSort implements Comparator<Product> {
    @Override
    public int compare(Product a, Product b) {
        double compare = b.getRating() - a.getRating();
        if( compare == 0){
            return b.getId() - a.getId();
        }
        return (int) compare;
    }
}
