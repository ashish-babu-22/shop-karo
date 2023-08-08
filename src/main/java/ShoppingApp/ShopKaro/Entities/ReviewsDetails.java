package ShoppingApp.ShopKaro.Entities;


import javax.persistence.*;

@Entity
@Table(name = "review_details")
public class ReviewsDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "comments")
    String comments;

    public ReviewsDetails(){}

    public ReviewsDetails(String name, String comments) {
        this.name = name;
        this.comments = comments;
    }
 public ReviewsDetails( String comments) {
        this.comments = comments;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "ReviewsDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
