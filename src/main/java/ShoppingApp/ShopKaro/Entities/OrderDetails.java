package ShoppingApp.ShopKaro.Entities;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "location")
    String location;


    @Column(name  = "doo")
    String DateOfOrder;

    @Column(name = "dod")
    String DateOfDelivery;

    @Column(name = "amount_payable")
    String amountPayable;

    @OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private CartDetails cartDetails_inOrd;

    public OrderDetails(){}

    public OrderDetails(String name, String location, String dateOfOrder, String dateOfDelivery, String amountPayable) {
        this.name = name;
        this.location = location;
        DateOfOrder = dateOfOrder;
        DateOfDelivery = dateOfDelivery;
        this.amountPayable = amountPayable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDateOfDelivery() {
        return DateOfDelivery;
    }

    public void setDateOfDelivery(String dateOfDelivery) {
        DateOfDelivery = dateOfDelivery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateOfOrder() {
        return DateOfOrder;
    }

    public void setDateOfOrder(String dateOfOrder) {
        DateOfOrder = dateOfOrder;
    }

    public String getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(String amountPayable) {
        this.amountPayable = amountPayable;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", DateOfOrder='" + DateOfOrder + '\'' +
                ", DateOfDelivery='" + DateOfDelivery + '\'' +
                ", amountPayable='" + amountPayable + '\'' +
                '}';
    }
}
