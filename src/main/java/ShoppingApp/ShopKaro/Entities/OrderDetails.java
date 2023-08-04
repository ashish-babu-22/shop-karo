package ShoppingApp.ShopKaro.Entities;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "order_id")
    int id;

    @Column(name = "payment_mode")
    String payment;

    @Column(name = "dod")
    String DateOfDelivery;

    public OrderDetails(){}

    public OrderDetails(String payment, String dateOfDelivery) {
        this.payment = payment;
        DateOfDelivery = dateOfDelivery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDateOfDelivery() {
        return DateOfDelivery;
    }

    public void setDateOfDelivery(String dateOfDelivery) {
        DateOfDelivery = dateOfDelivery;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", payment='" + payment + '\'' +
                ", DateOfDelivery='" + DateOfDelivery + '\'' +
                '}';
    }
}
