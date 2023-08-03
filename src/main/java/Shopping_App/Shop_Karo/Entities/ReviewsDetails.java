package Shopping_App.Shop_Karo.Entities;


import javax.persistence.*;

@Entity
@Table(name = "review_details")
public class ReviewsDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    int id;

    @Column(name = "comments")
    String comments;

    public ReviewsDetails(){}

    public ReviewsDetails(String comments) {
        this.comments = comments;
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
                ", comments='" + comments + '\'' +
                '}';
    }
}
