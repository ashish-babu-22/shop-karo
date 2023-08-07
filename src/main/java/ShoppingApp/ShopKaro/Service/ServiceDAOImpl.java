package ShoppingApp.ShopKaro.Service;

import ShoppingApp.ShopKaro.DataAccessObjects.*;
import ShoppingApp.ShopKaro.Entities.CartDetails;
import ShoppingApp.ShopKaro.Entities.CartItemDetails;
import ShoppingApp.ShopKaro.Entities.CustomerDetails;
import ShoppingApp.ShopKaro.Entities.ProductDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDAOImpl implements ServiceDAO{

    private ProductsDAO productsDAO;
    private CustomerDAO customerDAO;
    private OrderDetailsDAO orderDetailsDAO;
    private CartItemsDAO cartItemsDAO;
    private CartDAO cartDAO;
    private ReviewDAO reviewDAO;
    private EntityManagerDAO entityManagerDAO;


    @Override
    public CustomerDetails addCustomer(CustomerDetails customerDetails) {

        return customerDAO.save(customerDetails);
    }

    @Override
    public int findUser(CustomerDetails customerDetails) {
        return entityManagerDAO.findId(customerDetails);

    }

    @Override
    public void saveProduct(ProductDetails productDetails) {
        productsDAO.save(productDetails);
    }

    @Override
    public List<ProductDetails> showProducts() {
        return productsDAO.findAll();
    }

    @Override
    public void deleteProductById(int id) {
        productsDAO.deleteById(id);
    }

    @Override
    public ProductDetails selectProductById(int id) {
        Optional<ProductDetails> res = productsDAO.findById(id);

        ProductDetails temp = null;
        if(res.isPresent()){
            temp = res.get();
        }
        return temp;
    }

    @Override
    public List<CartItemDetails> showCartItems(int id) {
        CartDetails temp = cartDAO.findById(id).get();
        return temp.getCartItemDetails();
    }

    @Override
    public void deleteCartItemByProductId(int cart_id,int prod_id) {
       entityManagerDAO.deleteCartItemByProductId(cart_id,prod_id);
    }


    @Override
    public CartItemDetails addToCart(int cart_id, int prod_id) {
        return entityManagerDAO.AddCartItem(prod_id, cart_id);
    }

    @Override
    public CartDetails checkOut(int cart_id) {
        return cartDAO.findById(cart_id).get();
    }

}
