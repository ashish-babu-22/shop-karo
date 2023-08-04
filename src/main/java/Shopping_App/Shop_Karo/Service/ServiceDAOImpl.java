package Shopping_App.Shop_Karo.Service;

import Shopping_App.Shop_Karo.DataAccessObjects.*;
import Shopping_App.Shop_Karo.Entities.CartDetails;
import Shopping_App.Shop_Karo.Entities.ProductDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDAOImpl implements ServiceDAO{

    private ProductsDAO productsDAO;
    private CustomerDAO customerDAO;
    private OrderDetailsDAO orderDetailsDAO;
    private CartDAO cartDAO;
    private ReviewDAO reviewDAO;


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
    public List<CartDetails> showCartItems() {
        return cartDAO.findAll();
    }

    @Override
    public void deleteCartItemByProductId(int id) {

    }

}
