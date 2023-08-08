package ShoppingApp.ShopKaro.Service;

import ShoppingApp.ShopKaro.Entities.*;

import java.util.List;

public interface ServiceDAO {

    public CustomerDetails addCustomer(CustomerDetails customerDetails);

    public int findUser(CustomerDetails customerDetails);
    //Products Entity methods

    public void saveProduct(ProductDetails productDetails);

    public List<ProductDetails> showProducts();

    public void deleteProductById(int id);

    // Cart Entity methods

    public List<CartItemDetails> showCartItems(int id);
    public ProductDetails selectProductById(int id);
    public void deleteCartItemByProductId(int cart_id,int prod_id);

    public CartItemDetails addToCart(int cart_id, int prod_id);

    public OrderDetails checkOut(int cart_id);
}
