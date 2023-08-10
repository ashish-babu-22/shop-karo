package ShoppingApp.ShopKaro.DataAccessObjects;

import ShoppingApp.ShopKaro.Entities.CartItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsDAO extends JpaRepository<CartItemDetails,Integer> {

    @Query("delete from CartItemDetails where cartDetails_inCI=:cart_id and prodId=:prod_id")
    void deleteProductInCartById(@Param("cart_id") int cartId,@Param("prod_id") int prodId);

    @Query("select sum(price) from CartItemDetails where cartDetails_inCI.id=:cart_id")
    Integer totalPrice(@Param("cart_id")int cart_id);
}
