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
    int id;

    @Column(name = "total_price")
    int totalPrice;
    @OneToOne(mappedBy = "cartDetailsInCus",cascade = CascadeType.ALL)
    private CustomerDetails customerDetailsInCar;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductDetails> cartItemDetails;




    @OneToOne(mappedBy = "cartDetails_inOrd",cascade = CascadeType.ALL)
    OrderDetails orderDetails;


    public CartDetails(){

    }

    public CartDetails(int id,int totalPrice, CustomerDetails customerDetailsInCar) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.customerDetailsInCar = customerDetailsInCar;
    }

    public CartDetails(int id) {
        this.id = id;
    }





    public CartDetails(int id, int totalPrice) {
        this.id = id;
        this.totalPrice = totalPrice;
    }

    public CustomerDetails getCustomerDetailsInCar() {
        return customerDetailsInCar;
    }

    public void setCustomerDetailsInCar(CustomerDetails customerDetailsInCar) {
        this.customerDetailsInCar = customerDetailsInCar;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void add(ProductDetails newItem){
        if(cartItemDetails == null){
            cartItemDetails = new ArrayList<>();
        }
        cartItemDetails.add(newItem);
    }


}
