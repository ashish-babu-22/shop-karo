package Shopping_App.Shop_Karo.Entities;


import javax.persistence.*;

@Entity
@Table(name = "cart_details")
public class CartDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    int id;

    @Column(name = "total_price")
    String totalPrice;

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
}
