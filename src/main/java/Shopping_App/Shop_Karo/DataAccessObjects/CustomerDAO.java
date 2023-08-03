package Shopping_App.Shop_Karo.DataAccessObjects;

import Shopping_App.Shop_Karo.Entities.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<CustomerDetails,Integer> {

}
