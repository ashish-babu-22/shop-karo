package ShoppingApp.ShopKaro.Service;

import ShoppingApp.ShopKaro.Entities.CartDetails;
import ShoppingApp.ShopKaro.Entities.CartItemDetails;
import ShoppingApp.ShopKaro.Entities.CustomerDetails;
import ShoppingApp.ShopKaro.Entities.ProductDetails;

import java.util.List;

public interface ServiceDAO {

    public CustomerDetails addCustomer(CustomerDetails customerDetails);

    public int findUser(CustomerDetails customerDetails);
    //Products Entity methods

    public void saveProduct(ProductDetails productDetails);

    public List<ProductDetails> showProducts();

    public void deleteProductById(int id);

    public ProductDetails selectProductById(int id);

    // Cart Entity methods

    public List<CartItemDetails> showCartItems(int id);

    public void deleteCartItemByProductId(int cart_id,int prod_id);

    public CartItemDetails addToCart(int cart_id, int prod_id);

    public List<CartDetails> checkOut(int cart_id);
}
