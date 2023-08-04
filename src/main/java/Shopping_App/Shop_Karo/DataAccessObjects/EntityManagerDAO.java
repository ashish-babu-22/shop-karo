package Shopping_App.Shop_Karo.DataAccessObjects;

import Shopping_App.Shop_Karo.Entities.ProductDetails;

import java.util.List;

public interface EntityManagerDAO {

    public List<ProductDetails> itemsInCartById(int cartId);

}
