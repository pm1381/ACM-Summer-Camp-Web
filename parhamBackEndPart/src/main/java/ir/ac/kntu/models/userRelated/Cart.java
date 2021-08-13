package ir.ac.kntu.models.userRelated;

import ir.ac.kntu.models.goodsRelated.Product;
import ir.ac.kntu.repositories.CartRepository;
import ir.ac.kntu.repositories.PurchaseHistoryRepository;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private CartStatus cartStatus;
    private int id;
    private Costumer costumer;
    private Map<Product,Integer> costumerBasket;

    public Cart(Costumer costumer,int id) {
        this.costumer = costumer;
        this.id = id;
        costumerBasket = new HashMap<>();
        cartStatus = CartStatus.EMPTY;
    }

    public CartStatus getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(CartStatus cartStatus) {
        this.cartStatus = cartStatus;
    }

    public int getId() {
        return id;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public Map<Product, Integer> getCostumerBasket() {
        return costumerBasket;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public void clearBasket(){
        CartRepository.getInstance().clearCart(this);
    }

    public void removeSthFromBasket(Product product,Costumer costumer){
        CartRepository.getInstance().removeFromCart(product,costumer);
    }

    public void pay(){
        int payable = 0;
        for(Map.Entry<Product,Integer> each : costumerBasket.entrySet()){
            payable = payable + ( each.getKey().getPrice() * each.getValue());
        }
        if(costumer.getCredit().getBalance() >= payable){
            cartStatus = CartStatus.PAID;
            costumer.getCredit().withDrawAccount(payable);
            addToPurchasedHistory();
            costumer.getPurchasedHistory().setTotalSpent(payable);
        }
        clearBasket();
    }

    public void addToBasket(int quantity,Product product){
        CartRepository.getInstance().addToCart(quantity,product,this);
    }

    private void addToPurchasedHistory(){
        for(Map.Entry<Product,Integer> each : costumerBasket.entrySet()){
            PurchaseHistoryRepository.getInstance().addToCostumerHistory(getCostumer(),each.getKey(),each.getValue());
        }
    }
}

