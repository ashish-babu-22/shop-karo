package ShoppingApp.ShopKaro.RestController;

import ShoppingApp.ShopKaro.Entities.*;
import ShoppingApp.ShopKaro.ExceptionHandler.ProductErrorResponse;
import ShoppingApp.ShopKaro.ExceptionHandler.UserNotFoundException;
import ShoppingApp.ShopKaro.Service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class ShopKaroRest {

    private final String url = "http://localhost:8080/";

    private final ServiceDAO serviceDAO;

    @Autowired
    public ShopKaroRest(ServiceDAO serviceDAO){
        this.serviceDAO=serviceDAO;
    }

    @GetMapping("/error")
    public ProductErrorResponse errorResponse() throws Exception {
        throw new Exception("Something went wrong");
    }
    @GetMapping("/")
    public String enterDetails(){
        return "Welcome to shopKaro\n " +
                url+"login - to login to existing account \n" +
                url+"signup - to signup a new account ";
    }


    /*

    API-List
    /signup *
    /login
    /modify_details
    {id}/enter_new_details
    {cart_id}/view_products*
    {cart_id}/view_products/{prod_id}*
    {cart_id}/view_products/{prod_id}/see_reviews
    {cart_id}/view_products/{prod_id}/add_review
    {cart_id}/add_to_cart/{prod_id}
    {cart_id}/delete_from_cart/{prod_id}
    {id}/show_cart_items
    {cart_id}/place_order
    /view_customers
    /delete_customer/{cus_id}
    /add_product
    /update_product

     */
    // name, mail, location, contact, password
    @PostMapping("/signup")
    public String addCustomer(@RequestBody CustomerDetails customerDetails){
        CustomerDetails temp = serviceDAO.addCustomer(customerDetails);

        int id = temp.getCustomerID();
        String name  = temp.getName();
        return "Welcome "+name+"\nGET-Method - "+url+id+"/view_products";
    }


    @PostMapping("/login")
    public String logCustomer(@RequestBody CustomerDetails customerDetails){

        int id = serviceDAO.findUserId(customerDetails);
        if(id == -1) throw new UserNotFoundException("Please Check the user details is valid (or) sign up");
        String name  = serviceDAO.findUserName(id);
        return "Welcome "+name+"\nGET-Method - "+url+id+"/view_products";

    }
    @PostMapping("/modify_details")
    public String modifyCustomer(@RequestBody CustomerDetails customerDetails){

        int id = serviceDAO.findUserId(customerDetails);
        if(id == -1) throw new UserNotFoundException("Error in RestController");
        return "PUT-Method - "+url+id+"/enter_new_details";
    }

    @PutMapping("{id}/enter_new_details")
    public String changeDetails(@PathVariable int id, @RequestBody CustomerDetails customerDetails){
        customerDetails.setCustomerID(id);
        serviceDAO.updateDetails(customerDetails);
        return "Modified Successfully\nGET-Method - "+url+id+"/view_products";
    }


    @GetMapping("{cart_id}/view_products")
    public List<ProductDetails> displayProducts(@PathVariable int cart_id){
        return serviceDAO.showProducts(cart_id);
    }


    @GetMapping("{cart_id}/view_products/{prod_id}")
    public ProductDetails viewProductById(@PathVariable("prod_id")int prod_id){
        return serviceDAO.vewProductById(prod_id);
    }
    @GetMapping("{cart_id}/view_products/{prod_id}/see_reviews")
    public List<ReviewsDetails> seeReviews(@PathVariable("prod_id")int prod_id){
        return serviceDAO.displayReviews(prod_id);
    }


    @PostMapping("{cart_id}/view_products/{prod_id}/add_review")
    public List<ReviewsDetails> addReview(@PathVariable("cart_id")int cart_id, @PathVariable("prod_id")int prod_id, @RequestBody ReviewsDetails reviewsDetails){
        return serviceDAO.addReview(cart_id,prod_id,reviewsDetails);
    }
    @GetMapping("{cart_id}/add_to_cart/{prod_id}")
    public ProductDetails addToCart(@PathVariable("prod_id") int prod_id, @PathVariable("cart_id") int cart_id){

        return serviceDAO.addToCart(cart_id,prod_id);
    }

    @DeleteMapping("{cart_id}/delete_from_cart/{prod_id}")
    public String deleteCartProduct(@PathVariable("cart_id") int cart_id,@PathVariable("prod_id") int prod_id){
        serviceDAO.deleteCartItemByProductId(cart_id,prod_id);
        return "Removed Id - "+prod_id;
    }

    @GetMapping("/{id}/show_cart_items")
    public List<ProductDetails> showCartProducts(@PathVariable int id){
        return serviceDAO.showCartItems(id);
    }

    @GetMapping("/{cart_id}/place_order")
    public OrderDetails showDetails(@PathVariable int cart_id){
       return serviceDAO.checkOut(cart_id);
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
