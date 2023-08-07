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
    String totalPrice;

    @OneToMany(mappedBy = "cartDetails")
    List<CartItemDetails> cartItemDetails;

    @ManyToMany()
    private List<ProductDetails> productDetails;

    public CartDetails(){

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

    public List<ProductDetails> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetails> productDetails) {
        this.productDetails = productDetails;
    }

    @Override
    public String toString() {
        return "CartDetails{" +
                "id=" + id +
                ", totalPrice='" + totalPrice + '\'' +
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
