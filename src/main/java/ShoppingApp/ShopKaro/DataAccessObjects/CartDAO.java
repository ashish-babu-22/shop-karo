package ShoppingApp.ShopKaro.DataAccessObjects;

import ShoppingApp.ShopKaro.Entities.CartDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDAO extends JpaRepository<CartDetails,Integer> {

}
