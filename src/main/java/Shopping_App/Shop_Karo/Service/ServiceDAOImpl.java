package Shopping_App.Shop_Karo.Service;

import Shopping_App.Shop_Karo.DataAccessObjects.ProductsDAO;
import Shopping_App.Shop_Karo.Entities.ProductDetails;

import java.util.List;
import java.util.Optional;

public class ServiceDAOImpl implements ServiceDAO{

    private ProductsDAO productsDAO;

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

}
