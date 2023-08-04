package Shopping_App.Shop_Karo.Service;

import Shopping_App.Shop_Karo.Entities.ProductDetails;

import java.util.List;

public interface ServiceDAO {
    public void saveProduct(ProductDetails productDetails);

    public List<ProductDetails> showProducts();

    public void deleteProductById(int id);

    public ProductDetails selectProductById(int id);
}
