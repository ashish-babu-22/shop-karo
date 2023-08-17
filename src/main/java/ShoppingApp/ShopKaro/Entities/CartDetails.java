package ShoppingApp.ShopKaro.Entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart_details")
public class CartDetails {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    int cartId;

    @Column(name = "total_price")
    int totalPrice;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductDetails> cartItemDetails;




//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "cart_id")
//    OrderDetails orderDetails;


    public CartDetails(){

    }

    public CartDetails(int cartId, int totalPrice, CustomerDetails customerDetailsInCar) {
        this.cartId = cartId;
        this.totalPrice = totalPrice;
    }

    public CartDetails(int cartId) {
        this.cartId = cartId;
    }





    public CartDetails(int cartId, int totalPrice) {
        this.cartId = cartId;
        this.totalPrice = totalPrice;
    }


    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }


    public List<ProductDetails> getCartItemDetails() {
        return cartItemDetails;
    }

    public void setCartItemDetails(List<ProductDetails> cartItemDetails) {
        this.cartItemDetails = cartItemDetails;
    }

//    public OrderDetails getOrderDetails() {
//        return orderDetails;
//    }
//
//    public void setOrderDetails(OrderDetails orderDetails) {
//        this.orderDetails = orderDetails;
//    }

    @Override
    public String toString() {
        return "CartDetails{" +
                "id=" + cartId +
                ", totalPrice='" + totalPrice + '\'' +
                ", cartItemDetails=" + cartItemDetails +
//                ", orderDetails=" + orderDetails +
                '}';
    }

    public void add(ProductDetails newItem){
        if(cartItemDetails == null){
            cartItemDetails = new ArrayList<>();
        }
        cartItemDetails.add(newItem);
    }


}
