package ShoppingApp.ShopKaro.Service;

import ShoppingApp.ShopKaro.Entities.CartDetails;
import ShoppingApp.ShopKaro.Entities.CustomerDetails;
import ShoppingApp.ShopKaro.Entities.ProductDetails;

import java.util.List;

public interface ServiceDAO {

    public CustomerDetails addCustomer(CustomerDetails customerDetails);
    //Products Entity methods

    public void saveProduct(ProductDetails productDetails);

    public List<ProductDetails> showProducts();

    public void deleteProductById(int id);

    public ProductDetails selectProductById(int id);

    // Cart Entity methods

    public List<ProductDetails> showCartItems(int id);

    public void deleteCartItemByProductId(int id);

    public List<ProductDetails> itemsInCartById(int cartId);
}
