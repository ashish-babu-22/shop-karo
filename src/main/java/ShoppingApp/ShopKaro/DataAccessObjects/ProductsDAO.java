package ShoppingApp.ShopKaro.DataAccessObjects;

import ShoppingApp.ShopKaro.Entities.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsDAO extends JpaRepository<ProductDetails,Integer> {

}
