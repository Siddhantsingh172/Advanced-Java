package in.cg.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import in.cg.model.CartItem;
import in.cg.model.Product;

@Service
public class CartService {

    private List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        cartItems.add(new CartItem(product, quantity));
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public double getTotalAmount() {
        return cartItems.stream()
                .mapToDouble(item ->
                        item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }
}