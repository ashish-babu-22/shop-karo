package ShoppingApp.ShopKaro.Service;

import ShoppingApp.ShopKaro.Entities.*;

import java.util.List;

public interface ServiceDAO {

    public boolean isValidProdId(int id);
    public boolean isValidCartId(int id);

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

    List<ReviewsDetails> displayReviews(int prod_id);

    ReviewsDetails addReview(int cartId, int prodId, ReviewsDetails reviewsDetails);

    List<CustomerDetails> listCustomers();

    String deleteCustomer(int id);

    ProductDetails addProduct(ProductDetails productDetails);

    ProductDetails updateProduct(ProductDetails productDetails);

    void updateDetails(CustomerDetails customerDetails);

    ProductDetails vewProductById(int prodId);

}
