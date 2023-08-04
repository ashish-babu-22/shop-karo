package Shopping_App.Shop_Karo.Service;

import Shopping_App.Shop_Karo.Entities.CartDetails;
import Shopping_App.Shop_Karo.Entities.ProductDetails;

import java.util.List;

public interface ServiceDAO {

    //Products Entity methods

    public void saveProduct(ProductDetails productDetails);

    public List<ProductDetails> showProducts();

    public void deleteProductById(int id);

    public ProductDetails selectProductById(int id);

    // Cart Entity methods

    public List<CartDetails> showCartItems();

    public void deleteCartItemByProductId(int id);
}
