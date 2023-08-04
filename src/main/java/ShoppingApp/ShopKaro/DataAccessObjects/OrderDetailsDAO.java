package ShoppingApp.ShopKaro.DataAccessObjects;

import ShoppingApp.ShopKaro.Entities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsDAO extends JpaRepository<OrderDetails,Integer> {

}
