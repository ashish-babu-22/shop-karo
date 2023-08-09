package ShoppingApp.ShopKaro.Entities;

import javax.persistence.*;

@Entity
@Table(name = "customer_details")
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    int id;

    // name, mail, location, contact, password
    @Column(name = "name")
    String name;

    @Column(name = "mail")
    String mail;

    @Column(name = "location")
    String location;

    @Column(name = "contact")
    String contact ;

    @Column(name = "password")
    String password;

    @OneToOne(mappedBy = "customerDetails",cascade = CascadeType.ALL)
    private CartDetails cartDetails;


    public CustomerDetails(String name, String mail, String location, String contact, String password) {
        this.name = name;
        this.mail = mail;
        this.location = location;
        this.contact = contact;
        this.password = password;
    }

    public CartDetails getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(CartDetails cartDetails) {
        this.cartDetails = cartDetails;
    }

    public  CustomerDetails(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "CustomerDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", location='" + location + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
