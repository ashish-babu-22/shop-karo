package ShoppingApp.ShopKaro.Entities;


import javax.persistence.*;
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

    @Override
    public String toString() {
        return "CartDetails{" +
                "id=" + id +
                ", totalPrice='" + totalPrice + '\'' +
                '}';
    }
}
