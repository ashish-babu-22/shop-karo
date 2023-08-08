package ShoppingApp.ShopKaro.DataAccessObjects;

import ShoppingApp.ShopKaro.Entities.*;

import java.util.List;

public interface EntityManagerDAO {

//    public List<CartItemDetails> itemsInCartById(int cartId);
    public CartItemDetails AddCartItem(int prod_id, int cart_id);

    public int findId(CustomerDetails customerDetails);

    public int totalPrice(List<CartItemDetails> cartItemDetails);
    public void deleteCartItemByProductId(int cart_id,int prod_id);
    public OrderDetails checkOut(int cart_id);


}
