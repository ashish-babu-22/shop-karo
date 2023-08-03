package Shopping_App.Shop_Karo.DataAccessObjects;

import Shopping_App.Shop_Karo.Entities.ReviewsDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDAO extends JpaRepository<ReviewsDetails,Integer> {

}
