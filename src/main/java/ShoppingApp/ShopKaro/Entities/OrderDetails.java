package ShoppingApp.ShopKaro.Entities;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    int OrderID;

    @Column(name = "name")
    String Name;

    @Column(name = "location")
    String Location;


    @Column(name  = "doo")
    String DateOfOrder;

    @Column(name = "dod")
    String DateOfDelivery;

    @Column(name = "amount_payable")
    int AmountPayable;

    @OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    CartDetails CartDetails;

    public OrderDetails(){}

    public OrderDetails(String name, String location, String dateOfOrder, String dateOfDelivery,int amountPayable) {
        this.Name = name;
        this.Location = location;
        DateOfOrder = dateOfOrder;
        DateOfDelivery = dateOfDelivery;
        this.AmountPayable = amountPayable;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        this.OrderID = orderID;
    }
    public String getDateOfDelivery() {
        return DateOfDelivery;
    }

    public void setDateOfDelivery(String dateOfDelivery) {
        DateOfDelivery = dateOfDelivery;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        this.Location = location;
    }

    public String getDateOfOrder() {
        return DateOfOrder;
    }

    public void setDateOfOrder(String dateOfOrder) {
        DateOfOrder = dateOfOrder;
    }

    public int getAmountPayable() {
        return AmountPayable;
    }

    public void setAmountPayable(int amountPayable) {
        this.AmountPayable = amountPayable;
    }

    public CartDetails getCartDetails_inOrd() {
        return CartDetails;
    }

    public void setCartDetails_inOrd(CartDetails cartDetails_inOrd) {
        this.CartDetails = cartDetails_inOrd;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + OrderID +
                ", name='" + Name + '\'' +
                ", location='" + Location + '\'' +
                ", DateOfOrder='" + DateOfOrder + '\'' +
                ", DateOfDelivery='" + DateOfDelivery + '\'' +
                ", amountPayable='" + AmountPayable + '\'' +
                '}';
    }
}
