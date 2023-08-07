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
        int cusId = entityManagerDAO.findId(customerDetails);
        return cusId;

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
    public List<ProductDetails> showCartItems(int id) {
        return entityManagerDAO.itemsInCartById(id);
    }

    @Override
    public void deleteCartItemByProductId(int id) {

    }

    @Override
    public List<ProductDetails> itemsInCartById(int cartId) {
       return entityManagerDAO.itemsInCartById(cartId);
    }

    @Override
    public CartItemDetails addToCart(int cart_id, int prod_id) {
        return entityManagerDAO.AddCartItem(prod_id, cart_id);
    }

}
