package ShoppingApp.ShopKaro.RestController;

import ShoppingApp.ShopKaro.Entities.CustomerDetails;
import ShoppingApp.ShopKaro.Entities.ProductDetails;
import ShoppingApp.ShopKaro.ExceptionHandler.ProductErrorResponse;
import ShoppingApp.ShopKaro.Service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/shopkaro")


public class ShopKaroAdminRest {


    private final String url = "http://localhost:8080/";

    private final ServiceDAO serviceDAO;

    @Autowired
    public ShopKaroAdminRest(ServiceDAO serviceDAO){
        this.serviceDAO=serviceDAO;
    }

    @GetMapping("/error")
    public ProductErrorResponse errorResponse() throws Exception {
        throw new Exception("Something went wrong");
    }

    @GetMapping("/view_customers")
    public List<CustomerDetails> listCustomers(){
        return serviceDAO.listCustomers();
    }

    @DeleteMapping("/delete_customer/{cus_id}")
    public String deleteCustomer(@PathVariable int cus_id){
        return serviceDAO.deleteCustomer(cus_id);
    }

    @PostMapping("/add_product")
    public ProductDetails addProduct(@RequestBody ProductDetails productDetails){
        return serviceDAO.addProduct(productDetails);
    }
    @PostMapping("/delete_product")
    public String deleteProduct(@PathVariable int id){
        serviceDAO.deleteProductById(id);
        return "Product deleted successfully with id - "+id;
    }

    @PutMapping("/update_product")
    public ProductDetails updateProduct(@RequestBody ProductDetails productDetails){
        return serviceDAO.updateProduct(productDetails);
    }

}
