package ShoppingApp.ShopKaro.DataAccessObjects;

import ShoppingApp.ShopKaro.Entities.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductsDAO extends JpaRepository<ProductDetails,Integer> {
    @Transactional
    @Modifying
    @Query(value = "delete from cart_product where cart_id = :cart_id and product_id=:prod_id",nativeQuery = true)
    void deleteProductInCartById(@Param("cart_id") int cartId, @Param("prod_id") int prodId);

    @Query(value = "SELECT SUM(p.price) " +
            "FROM product_details p " +
            "JOIN cart_product cp ON p.product_id = cp.product_id " +
            "WHERE cp.cart_id = :cart_id",nativeQuery = true)
    Integer totalPrice(@Param("cart_id")int cart_id);
}

