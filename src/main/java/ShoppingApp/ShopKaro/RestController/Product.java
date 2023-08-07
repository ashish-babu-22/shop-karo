package ShoppingApp.ShopKaro.RestController;


import ShoppingApp.ShopKaro.Entities.CartItemDetails;
import ShoppingApp.ShopKaro.Entities.CustomerDetails;
import ShoppingApp.ShopKaro.Entities.ProductDetails;
import ShoppingApp.ShopKaro.Service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
    public String enterDetails(){
        return "Welcome to shopKaro\n \\login - to login to existing account \n \\signup - to signup a new account ";
    }

    @PostMapping("/signup")
    public RedirectView addCustomer(@RequestBody CustomerDetails customerDetails){
        CustomerDetails temp = serviceDAO.addCustomer(customerDetails);
        int id = temp.getId();
        return new RedirectView(id+"/view_products");
    }


    @PostMapping("/login")
    public RedirectView logCustomer(@RequestBody CustomerDetails customerDetails){

        int id = serviceDAO.findUser(customerDetails);
        return new RedirectView("{id}/view_products");

    }


    @GetMapping("{id}/view_products")
    public List<ProductDetails> displayProducts(){
        return serviceDAO.showProducts();
    }


    @GetMapping("{cart_id}/view_products/(prod_id}")
    public CartItemDetails addProduct(@PathVariable("prod_id") int prod_id, @PathVariable("cart_id") int cart_id){

        return serviceDAO.addToCart(cart_id,prod_id);
    }

    @GetMapping("/{id}/show_cart_items")
    public List<ProductDetails> showCartProducts(@PathVariable int id){
        return serviceDAO.showCartItems(id);
    }

}
