package Shopping_App.Shop_Karo.RestController;


import Shopping_App.Shop_Karo.DataAccessObjects.ProductsDAO;
import Shopping_App.Shop_Karo.Entities.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopkaro/product")

public class Product {
    private ProductsDAO productsDAO;

    @Autowired
    public Product(ProductsDAO productsDAO){
        this.productsDAO = productsDAO;
    }

    @GetMapping("/view_products")
    public List<ProductDetails> displayProducts(){
        return null;
    }

    @GetMapping("/delete_product/{id}")
    public void deleteProducts(@PathVariable int id){
    }

}
