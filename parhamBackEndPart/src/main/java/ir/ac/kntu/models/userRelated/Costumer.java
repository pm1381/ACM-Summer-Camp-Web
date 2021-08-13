package ir.ac.kntu.models.userRelated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.ac.kntu.models.goodsRelated.Product;
import ir.ac.kntu.repositories.PurchaseHistoryRepository;
import java.util.Map;

public class Costumer extends User {
    @JsonIgnore
    private Cart cart;
    @JsonIgnore
    private Credit credit;
    @JsonIgnore
    private PurchasedHistory purchasedHistory;

    public Costumer(String name, String familyName, String phoneNumber,
                    String email, String password) {
        super(name, familyName, phoneNumber, email, password);
    }

    public void instantiateFields(){
        cart = new Cart(this,getId());
        purchasedHistory = new PurchasedHistory(getId());
        credit = new Credit(getId());
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public PurchasedHistory getPurchasedHistory() {
        return purchasedHistory;
    }

    public Product referToProductPage(int id){
        Product referProduct = null;
        for (Map.Entry<Product,Integer> entry : getCart().getCostumerBasket().entrySet()){
            if(entry.getKey().getId() == id){
                referProduct = entry.getKey();
            }
        }
        return referProduct;
    }
}
