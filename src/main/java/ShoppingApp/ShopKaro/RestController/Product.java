package ShoppingApp.ShopKaro.RestController;


import ShoppingApp.ShopKaro.Entities.CustomerDetails;
import ShoppingApp.ShopKaro.Entities.ProductDetails;
import ShoppingApp.ShopKaro.Service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopkaro/")

public class Product {

    private ServiceDAO serviceDAO;

    @Autowired
    public Product(ServiceDAO serviceDAO){
        this.serviceDAO=serviceDAO;
    }

    @PostMapping("/")
    public CustomerDetails enterDetails(@RequestBody CustomerDetails customerDetails){
        return serviceDAO.addCustomer(customerDetails);
    }

    @GetMapping("/view_products")
    public List<ProductDetails> displayProducts(){
        return serviceDAO.showProducts();
    }

    @GetMapping("/delete_product/{id}")
    public void deleteProducts(@PathVariable int id){
        serviceDAO.deleteProductById(id);
    }
    @GetMapping("/{id}/show_cart_items")
    public List<ProductDetails> showCartProducts(@PathVariable int id){
        return serviceDAO.showCartItems(id);
    }

}
