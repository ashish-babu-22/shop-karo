package ShoppingApp.ShopKaro.Service;

import ShoppingApp.ShopKaro.DataAccessObjects.*;
import ShoppingApp.ShopKaro.Entities.*;
import ShoppingApp.ShopKaro.ExceptionHandler.ProductNotFoundException;
import ShoppingApp.ShopKaro.ExceptionHandler.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalTime;
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
    private CartItemsDAO cartItemsDAO;

    @Autowired
    public void setCartItemsDAO(CartItemsDAO cartItemsDAO){
        this.cartItemsDAO = cartItemsDAO;
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
    private EntityManagerDAO entityManagerDAO;
    public void setEntityManagerDAO(EntityManagerDAO entityManagerDAO){
        this.entityManagerDAO = entityManagerDAO;
    }

    @Override
    public boolean isValidProdId(int prod_id) {

        Optional<ProductDetails> byId = productsDAO.findById(prod_id);
        return byId.isPresent();
    }

    @Override
    public boolean isValidCartId(int cart_id) {
        Optional<CartDetails> byId =cartDAO.findById(cart_id);
        return byId.isPresent();
    }



    @Override
    public CustomerDetails addCustomer(CustomerDetails customerDetails) {
        return customerDAO.save(customerDetails);
    }

    @Override
    public int findUser(CustomerDetails customerDetails) {
        return entityManagerDAO.findId(customerDetails);

    }

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

    @Override
    public List<CartItemDetails> showCartItems(int id) {
        CartDetails temp = cartDAO.findById(id).get();
        return temp.getCartItemDetails();
    }

    @Override
    public void deleteCartItemByProductId(int cart_id,int prod_id) {
       entityManagerDAO.deleteCartItemByProductId(cart_id,prod_id);
    }


    @Override
    public CartItemDetails addToCart(int cart_id, int prod_id) {
        Optional<ProductDetails> tempProd = productsDAO.findById(prod_id);
        ProductDetails prod ;
        if(tempProd.isPresent())
       prod = tempProd.get();
        else
            throw new ProductNotFoundException("Product with id "+prod_id+" is not found");
        CartItemDetails cartItem = new CartItemDetails(prod.getName(),prod.getPrice());
        Optional<CartDetails> tempCart;

        tempCart = cartDAO.findById(cart_id);
        CartDetails cart;
        if(tempCart.isEmpty()){
                CartDetails newCart = new CartDetails(prod.getPrice());
                newCart.setId(cart_id);
                cartDAO.save(newCart);
                cart = newCart;
        }
        else{
            cart = tempCart.get();
        }

        cart.add(cartItem);
        cartDAO.save(cart);
        return cartItem;
    }

    @Override
    public OrderDetails checkOut(int cart_id) {
        CartDetails cart = cartDAO.findById(cart_id).get();
        List<CartItemDetails> cartItemDetails = cart.getCartItemDetails();
        CustomerDetails cus = customerDAO.findById(cart_id).get();
        String name = cus.getName();
        String location = cus.getLocation();
        String dateOfOrder = String.valueOf(LocalTime.now());
        String dateOfDelivery = String.valueOf(LocalTime.now().plusHours(240));
        String amountPayable = String.valueOf(entityManagerDAO.totalPrice(cartItemDetails));
        cart.setTotalPrice(amountPayable);
        cartDAO.save(cart);
        OrderDetails order = new OrderDetails(name,location,dateOfOrder,dateOfDelivery,amountPayable);
        orderDetailsDAO.save(order);
        return order;
    }

    @Override
    public List<ReviewsDetails> displayReviews(int prod_id) {
        ProductDetails product = selectProductById(prod_id);
        return product.getReviewsDetails();
    }

    @Override
    public ReviewsDetails addReview(int cartId, int prodId, ReviewsDetails review) {
        CustomerDetails cus = customerDAO.findById(cartId).get();
        String name = cus.getName();
        review.setName(name);
        ProductDetails prod = productsDAO.findById(prodId).get();
        prod.add(review);
        productsDAO.save(prod);
        return review;
    }

    @Override
    public List<CustomerDetails> listCustomers() {
        return customerDAO.findAll();
    }

    @Override
    public String deleteCustomer(int id) {
        if(isValidCartId(id))throw new UserNotFoundException("User ID Unknown");
        customerDAO.deleteById(id);
        return "User "+ id + " deleted Successfully";
    }

    @Override
    public ProductDetails addProduct(ProductDetails productDetails) {
        productDetails.setId(0);
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
        return productsDAO.findById(prodId).get();
    }



}
