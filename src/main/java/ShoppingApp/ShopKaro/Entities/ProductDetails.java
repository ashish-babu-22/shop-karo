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
    int id;

    @Column(name = "name")
    String name;

    @Column(name ="quantity")
    String quantity;

    @Column(name = "price")
    String price;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    List<ReviewsDetails> reviewsDetails;


    public ProductDetails(String name, String quantity, String price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<ReviewsDetails> getReviewsDetails() {
        return reviewsDetails;
    }

    public void setReviewsDetails(List<ReviewsDetails> reviewsDetails) {
        this.reviewsDetails = reviewsDetails;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public void add(ReviewsDetails review){
        if(reviewsDetails==null){
            reviewsDetails = new ArrayList<>();
        }
        reviewsDetails.add(review);
    }
}
