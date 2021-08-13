package ir.ac.kntu.sorts;

import ir.ac.kntu.models.goodsRelated.Product;

import java.util.Comparator;

public class PriceDescendingSort implements Comparator<Product> {
    @Override
    public int compare(Product b, Product a) {
        double compare = a.getPrice() - b.getPrice();
        if( compare == 0){
            return a.getId() - b.getId();
        }
        return (int) compare;
    }
}
