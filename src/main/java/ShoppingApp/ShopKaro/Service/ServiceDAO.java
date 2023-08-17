package ShoppingApp.ShopKaro.Service;

import ShoppingApp.ShopKaro.Entities.*;

import java.util.List;

public interface ServiceDAO {



    CustomerDetails addCustomer(CustomerDetails customerDetails);

     int findUserId(CustomerDetails customerDetails);
     String findUserName(int id);
    //Products Entity methods

     List<ProductDetails> showProducts(int id);

     void deleteProductById(int id);

    // Cart Entity methods

     List<ProductDetails> showCartItems(int id);
     ProductDetails selectProductById(int id);
     void deleteCartItemByProductId(int cart_id,int prod_id);

     ProductDetails addToCart(int cart_id, int prod_id);

     OrderDetails checkOut(int cart_id);

    List<ReviewsDetails> displayReviews(int prod_id);

    List<ReviewsDetails> addReview(int cartId, int prodId, ReviewsDetails reviewsDetails);

    List<CustomerDetails> listCustomers();

    String deleteCustomer(int id);

    ProductDetails addProduct(ProductDetails productDetails);

    ProductDetails updateProduct(ProductDetails productDetails);

    void updateDetails(CustomerDetails customerDetails);

    ProductDetails vewProductById(int prodId);

}
