package ShoppingApp.ShopKaro.Entities;

import javax.persistence.*;

@Entity
@Table(name = "customer_details")
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    int CustomerID;

    // name, mail, location, contact, password
    @Column(name = "name")
    String Name;

    @Column(name = "mail")
    String Mail;


    @Column(name = "location")
    String Location;

    @Column(name = "contact")
    String Contact ;

    @Column(name = "password")
    String Password;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private CartDetails CartItemDetails;


    public CustomerDetails(String name, String mail, String location, String contact, String password) {
        this.Name = name;
        this.Mail = mail;
        this.Location = location;
        this.Contact = contact;
        this.Password = password;
    }

    public CartDetails getCartItemDetails() {
        return CartItemDetails;
    }

    public void setCartItemDetails(CartDetails cartItemDetails) {
        this.CartItemDetails = cartItemDetails;
    }

    public  CustomerDetails(){}


    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        this.CustomerID = customerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        this.Mail = mail;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        this.Location = location;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        this.Contact = contact;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }


    @Override
    public String toString() {
        return "CustomerDetails{" +
                "id=" + CustomerID +
                ", name='" + Name + '\'' +
                ", mail='" + Mail + '\'' +
                ", location='" + Location + '\'' +
                ", contact='" + Contact + '\'' +
                '}';
    }
}
