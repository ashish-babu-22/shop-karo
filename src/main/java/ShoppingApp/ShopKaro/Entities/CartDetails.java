package ShoppingApp.ShopKaro.Entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart_details")
public class CartDetails {



    @Column(name = "cart_id")
    int id;

    @Column(name = "total_price")
    String totalPrice;

    @OneToMany(mappedBy = "cartDetails",cascade = CascadeType.ALL)
    List<CartItemDetails> cartItemDetails;

    @OneToOne(mappedBy = "cartDetails",cascade = CascadeType.ALL)
    private OrderDetails orderDetails;

    public CartDetails(){

    }

    public CartDetails(int id) {
        this.id = id;
    }

    public CartDetails(int id, List<CartItemDetails> cartItemDetails, OrderDetails orderDetails) {
        this.id = id;
        this.cartItemDetails = cartItemDetails;
        this.orderDetails = orderDetails;
    }

    public CartDetails(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }


    public List<CartItemDetails> getCartItemDetails() {
        return cartItemDetails;
    }

    public void setCartItemDetails(List<CartItemDetails> cartItemDetails) {
        this.cartItemDetails = cartItemDetails;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "CartDetails{" +
                "id=" + id +
                ", totalPrice='" + totalPrice + '\'' +
                ", cartItemDetails=" + cartItemDetails +
                ", orderDetails=" + orderDetails +
                '}';
    }

    public void add(CartItemDetails newItem){
        if(cartItemDetails == null){
            cartItemDetails = new ArrayList<>();
        }
        cartItemDetails.add(newItem);
    }

    public void delete(CartItemDetails oldItem){

    }
}
