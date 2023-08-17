package ShoppingApp.ShopKaro.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "product_details")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    int ProductID;

    @Column(name = "name")
    String Name;

    @Column(name ="quantity")
    String Quantity;

    @Column(name = "price")
    int Price;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "prod_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id")
    )
    List<CartDetails> cartDetails;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    List<ReviewsDetails> ReviewsDetails;

    public ProductDetails() {
    }

    public ProductDetails(String name, String quantity, int price) {
        this.Name = name;
        this.Quantity = quantity;
        this.Price = price;
    }

    public ProductDetails(String name, int price) {
        this.Name = name;
        this.Price = price;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        this.ProductID = productID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        this.Quantity = quantity;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        this.Price = price;
    }

    public List<ReviewsDetails> getReviewsDetails() {
        return ReviewsDetails;
    }

    public void setReviewsDetails(List<ReviewsDetails> reviewsDetails) {
        this.ReviewsDetails = reviewsDetails;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "id=" + ProductID +
                ", name='" + Name + '\'' +
                ", quantity='" + Quantity + '\'' +
                ", price='" + Price + '\'' +
                '}';
    }

    public void add(ReviewsDetails review){
        if(ReviewsDetails ==null){
            ReviewsDetails = new ArrayList<>();
        }
        ReviewsDetails.add(review);
    }
}
