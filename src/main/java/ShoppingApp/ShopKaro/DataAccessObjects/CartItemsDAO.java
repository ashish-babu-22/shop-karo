package ShoppingApp.ShopKaro.DataAccessObjects;

import ShoppingApp.ShopKaro.Entities.CartItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsDAO extends JpaRepository<CartItemDetails,Integer> {
}
