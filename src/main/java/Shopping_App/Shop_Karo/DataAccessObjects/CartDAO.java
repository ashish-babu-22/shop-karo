package Shopping_App.Shop_Karo.DataAccessObjects;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDAO extends JpaRepository<Shopping_App.Shop_Karo.Entities.CartDetails,Integer> {

}
