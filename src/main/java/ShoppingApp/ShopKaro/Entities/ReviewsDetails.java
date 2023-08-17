package ShoppingApp.ShopKaro.Entities;


import javax.persistence.*;

@Entity
@Table(name = "review_details")
public class ReviewsDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    int ReviewID;

    @Column(name = "name")
    String Name;

    @Column(name = "comments")
    String Comments;

    public ReviewsDetails(){}

    public ReviewsDetails(String name, String comments) {
        this.Name = name;
        this.Comments = comments;
    }
 public ReviewsDetails( String comments) {
        this.Comments = comments;
    }

    public int getReviewID() {
        return ReviewID;
    }

    public void setReviewID(int reviewID) {
        this.ReviewID = reviewID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        this.Comments = comments;
    }

    @Override
    public String toString() {
        return "ReviewsDetails{" +
                "id=" + ReviewID +
                ", name='" + Name + '\'' +
                ", comments='" + Comments + '\'' +
                '}';
    }
}
