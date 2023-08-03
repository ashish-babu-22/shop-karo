package Shopping_App.Shop_Karo.Entities;

import javax.persistence.*;

@Entity
@Table(name = "customer_details")
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    int id;

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

    public  CustomerDetails(){}

    public CustomerDetails(String name, String location, String contact) {
        this.name = name;
        this.location = location;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", contact='" + contact + '\'' +
                '}';
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
}
