package ir.ac.kntu.repositories;

import ir.ac.kntu.models.goodsRelated.Product;
import ir.ac.kntu.models.userRelated.Cart;
import ir.ac.kntu.models.userRelated.CartStatus;
import ir.ac.kntu.models.userRelated.Costumer;

public class CartRepository {
    private static CartRepository instance = null;

    private CartRepository(){
    }

    public static CartRepository getInstance(){
        if(instance == null){
            instance = new CartRepository();
        }
        return instance;
    }

    public void addToCart(int quantity, Product product, Cart cart) {
        // IDEA : USING PRODUCT OR USING PRODUCT_ID ???
        if(cart.getCostumerBasket().containsKey(product)){
            if(quantity +cart.getCostumerBasket().get(product) <= product.getQuantity() ){
                cart.getCostumerBasket().put(product,cart.getCostumerBasket().get(product)+quantity);
            }
        }
        cart.getCostumerBasket().put(product,quantity);
        if(cart.getCostumerBasket().size() != 0){
            cart.setCartStatus(CartStatus.AWAITING_PAYMENT);
        }
    }

    public void clearCart(Cart cart) {
        cart.getCostumerBasket().clear();
        cart.setCartStatus(CartStatus.EMPTY);
    }

    public void removeFromCart(Product product, Costumer costumer){
        // IDEA : USING PRODUCT OR USING PRODUCT_ID ???
        costumer.getCart().getCostumerBasket().remove(product);
    }

}
