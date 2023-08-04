package ShoppingApp.ShopKaro.DataAccessObjects;

import ShoppingApp.ShopKaro.Entities.ProductDetails;

import java.util.List;

public interface EntityManagerDAO {

    public List<ProductDetails> itemsInCartById(int cartId);

}
