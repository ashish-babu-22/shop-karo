package ShoppingApp.ShopKaro.RestController;

import ShoppingApp.ShopKaro.Entities.*;
import ShoppingApp.ShopKaro.ExceptionHandler.UserNotFoundException;
import ShoppingApp.ShopKaro.Service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/shopkaro/")

public class ShopKaroRest {

    private ServiceDAO serviceDAO;

    @Autowired
    public ShopKaroRest(ServiceDAO serviceDAO){
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
        if(id == -1) throw new UserNotFoundException("Please Check the user details is valid (or) sign up");
        return new RedirectView(id+"/view_products");

    }
    @PostMapping("/modify_details")
    public RedirectView modifyCustomer(@RequestBody CustomerDetails customerDetails){

        int id = serviceDAO.findUser(customerDetails);
        if(id == -1) throw new UserNotFoundException("Please Check the user details is valid (or) sign up");
        return new RedirectView(id+"/enter_new_details");
    }

    @PutMapping("{id}/enter_new_details")
    public RedirectView changeDetails(@PathVariable int id, @RequestBody CustomerDetails customerDetails){
        customerDetails.setId(id);
        serviceDAO.updateDetails(customerDetails);
        return new RedirectView(id+"/view_products");
    }


    @GetMapping("{cart_id}/view_products")
    public List<ProductDetails> displayProducts(@PathVariable int cart_id){
        if(!serviceDAO.isValidCartId(cart_id)){
            throw new UserNotFoundException("Please Check the user - " + cart_id + " is valid (or) sign up");
        }

        return serviceDAO.showProducts();
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
    public ReviewsDetails addReview(@PathVariable("cart_id")int cart_id,@PathVariable("prod_id")int prod_id, @RequestBody ReviewsDetails reviewsDetails){
        return serviceDAO.addReview(cart_id,prod_id,reviewsDetails);
    }
    @GetMapping("{cart_id}/add_to_cart/(prod_id}")
    public CartItemDetails addToCart(@PathVariable("prod_id") int prod_id, @PathVariable("cart_id") int cart_id){

        return serviceDAO.addToCart(cart_id,prod_id);
    }

    @DeleteMapping("{cart_id}/delete_from_cart/{prod_id)")
    public String deleteCartProduct(@PathVariable("cart_id") int cart_id,@PathVariable("prod_id") int prod_id){
        serviceDAO.deleteCartItemByProductId(cart_id,prod_id);
        return "Removed Id - "+prod_id;
    }

    @GetMapping("/{id}/show_cart_items")
    public List<CartItemDetails> showCartProducts(@PathVariable int id){
        return serviceDAO.showCartItems(id);
    }

    @GetMapping("/{cart_id}/place_order")
    public OrderDetails showDetails(@PathVariable int cart_id){
       return serviceDAO.checkOut(cart_id);
    }

}
