package ShoppingApp.ShopKaro.DataAccessObjects;

import ShoppingApp.ShopKaro.Entities.CartItemDetails;
import ShoppingApp.ShopKaro.Entities.CustomerDetails;
import ShoppingApp.ShopKaro.Entities.ProductDetails;

import java.util.List;

public interface EntityManagerDAO {

    public List<ProductDetails> itemsInCartById(int cartId);
    public CartItemDetails AddCartItem(int prod_id, int cart_id);

    public int findId(CustomerDetails customerDetails);

}
