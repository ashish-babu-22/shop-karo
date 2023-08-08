package ShoppingApp.ShopKaro.RestController;


import ShoppingApp.ShopKaro.Entities.CustomerDetails;
import ShoppingApp.ShopKaro.Entities.ProductDetails;
import ShoppingApp.ShopKaro.Service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopkaro")
public class ShopKaroAdmin {

    private ServiceDAO serviceDAO;

    @Autowired
    public ShopKaroAdmin(ServiceDAO serviceDAO){
        this.serviceDAO=serviceDAO;
    }

    @GetMapping("/view_customers")
    public List<CustomerDetails> listCustomers(){
        return serviceDAO.listCustomers();
    }

    @DeleteMapping("/delete_customer/{cus_id}")
    public String deleteCustomer(@PathVariable int id){
        return serviceDAO.deleteCustomer(id);
    }

    @PostMapping("/add_product")
    public ProductDetails addProduct(@RequestBody ProductDetails productDetails){
        return serviceDAO.addProduct(productDetails);
    }

    @PutMapping("/update_product")
    public ProductDetails updateProduct(@RequestBody ProductDetails productDetails){
        return serviceDAO.updateProduct(productDetails);
    }

}
