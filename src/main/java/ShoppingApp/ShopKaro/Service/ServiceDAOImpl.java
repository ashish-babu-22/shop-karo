package ShoppingApp.ShopKaro.Service;

import ShoppingApp.ShopKaro.DataAccessObjects.*;
import ShoppingApp.ShopKaro.Entities.*;
import ShoppingApp.ShopKaro.ExceptionHandler.BadRequestException;
import ShoppingApp.ShopKaro.ExceptionHandler.ProductNotFoundException;
import ShoppingApp.ShopKaro.ExceptionHandler.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceDAOImpl implements ServiceDAO{


    private ProductsDAO productsDAO;

    @Autowired
    public void setProductsDAO(ProductsDAO productsDAO){
        this.productsDAO = productsDAO;
    }
    private CustomerDAO customerDAO;
    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO){
        this.customerDAO=customerDAO;
    }
    private OrderDetailsDAO orderDetailsDAO;
    @Autowired
    public void setOrderDetailsDAO(OrderDetailsDAO orderDetailsDAO){
        this.orderDetailsDAO=orderDetailsDAO;
    }

    private CartDAO cartDAO;

    @Autowired
    public void setCartDAO(CartDAO cartDAO){
        this.cartDAO = cartDAO;
    }
    private ReviewDAO reviewDAO;
    public void setReviewDAO(ReviewDAO reviewDAO){
        this.reviewDAO = reviewDAO;
    }





    @Override
    public CustomerDetails addCustomer(CustomerDetails customerDetails) {

        if(customerDetails.getName() == null || customerDetails.getMail() == null || customerDetails.getPassword() == null || customerDetails.getContact() == null || customerDetails.getLocation() == null){
            throw new BadRequestException("Please fill out every Field ");
        }

        customerDAO.addToUserDB(customerDetails.getName(),"{noop}"+customerDetails.getPassword());
        customerDAO.addToRolesDB(customerDetails.getName());
        CartDetails cart = new CartDetails();
        cart.setCartId(customerDetails.getCustomerID());
        customerDetails.setCartItemDetails(cart);
        cartDAO.save(cart);
        return customerDAO.save(customerDetails);
    }

    @Override
    public int findUserId(CustomerDetails customerDetails) {
        String mail = customerDetails.getMail();
        String contact = customerDetails.getContact();
        String pass = customerDetails.getPassword();
        return customerDAO.getCustomerIdByMailAndPass(mail,pass,contact);

    }

    @Override
    public String findUserName(int id) {
        return customerDAO.findById(id).get().getName();
    }


    @Override
    public List<ProductDetails> showProducts(int id) {

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
    public List<ProductDetails> showCartItems(int id) {
        Optional<CartDetails> byId = cartDAO.findById(id);
        CartDetails temp;
        if(byId.isEmpty()){
            throw new UserNotFoundException("User Not Found with ID ="+ id);
        }
        temp=byId.get();
        return temp.getCartItemDetails();
    }

    @Override
    public void deleteCartItemByProductId(int cart_id,int prod_id) {
       productsDAO.deleteProductInCartById(cart_id,prod_id);
    }


    @Override
    public ProductDetails addToCart(int cart_id, int prod_id) {
        Optional<ProductDetails> tempProd = productsDAO.findById(prod_id);
        ProductDetails prod ;
        if(tempProd.isPresent())
       prod = tempProd.get();
        else
            throw new ProductNotFoundException("Product with id "+prod_id+" is not found");
        Optional<CartDetails> tempCart;

        tempCart = cartDAO.findById(cart_id);
        CartDetails cart;
        if(tempCart.isEmpty()){

            throw new UserNotFoundException("User Not Found with ID ="+ cart_id);
        }
        else{
            cart = tempCart.get();
        }

        cart.add(prod);
        cartDAO.save(cart);
        return prod;
    }

    @Override
    public OrderDetails checkOut(int cart_id) {
        Optional<CartDetails> byId = cartDAO.findById(cart_id);
        CartDetails cart;
        if(byId.isPresent()) {
            cart = byId.get();
        }
        else{
            throw new UserNotFoundException("User Not Found with ID ="+ cart_id);
        }

        List<ProductDetails> cartItemDetails = cart.getCartItemDetails();
        Optional<CustomerDetails> byId1 = customerDAO.findById(cart_id);
        CustomerDetails cus;
        if(byId1.isPresent()){
            cus = byId1.get();
        }
        else{
            throw new UserNotFoundException("User Not Found with ID ="+ cart_id);
        }
        String name = cus.getName();
        String location = cus.getLocation();
        String dateOfOrder = String.valueOf(LocalDate.now());
        String dateOfDelivery = String.valueOf(LocalDate.now().plusDays(10));
        int amountPayable = productsDAO.totalPrice(cart_id);
        cart.setTotalPrice(amountPayable);

        OrderDetails order = new OrderDetails(name,location,dateOfOrder,dateOfDelivery,amountPayable);

        order.setCartDetails_inOrd(cart);
        orderDetailsDAO.save(order);
        cartDAO.save(cart);
        return order;}

    @Override
    public List<ReviewsDetails> displayReviews(int prod_id) {
        ProductDetails product = selectProductById(prod_id);
        return product.getReviewsDetails();
    }

    @Override
    public List<ReviewsDetails> addReview(int cartId, int prodId, ReviewsDetails review) {
        if(review.getComments()==null){
            throw new UserNotFoundException("Please fill out every form");
        }
        Optional<CustomerDetails> byId = customerDAO.findById(cartId);
        CustomerDetails cus;
        if(byId.isPresent()){
            cus = byId.get();
        }
        else{
            throw new UserNotFoundException("User Not Found with ID ="+ cartId);
        }
        String name = cus.getName();
        review.setName(name);
        Optional<ProductDetails> byId1 = productsDAO.findById(prodId);
        ProductDetails prod;
        if(byId1.isPresent()){
            prod = byId1.get();
        }
        else {
            throw new ProductNotFoundException("Product Not Found with ID = "+prodId);
        }
        prod.add(review);
        productsDAO.save(prod);
        return prod.getReviewsDetails();
    }

    @Override
    public List<CustomerDetails> listCustomers() {
        return customerDAO.findAll();
    }

    @Override
    public String deleteCustomer(int id) {
        Optional<CustomerDetails> byId = customerDAO.findById(id);

        if(byId.isEmpty())throw new UserNotFoundException("User ID Unknown");
        customerDAO.deleteById(id);
        return "User " + id + " deleted Successfully";
    }

    @Override
    public ProductDetails addProduct(ProductDetails productDetails) {
        if(productDetails.getName() == null || productDetails.getQuantity() == null || productDetails.getPrice() == 0){
            throw new UserNotFoundException("Please Fill out every field");
        }
        return productsDAO.save(productDetails);
    }

    @Override
    public ProductDetails updateProduct(ProductDetails productDetails) {
        return productsDAO.save(productDetails);
    }

    @Override
    public void updateDetails(CustomerDetails customerDetails) {
        customerDAO.save(customerDetails);
    }

    @Override
    public ProductDetails vewProductById(int prodId) {
        Optional<ProductDetails> byId = productsDAO.findById(prodId);
        if(byId.isEmpty()){
            throw new ProductNotFoundException("Product Not Found with ID = "+prodId);
        }
        return byId.get();
    }
}
