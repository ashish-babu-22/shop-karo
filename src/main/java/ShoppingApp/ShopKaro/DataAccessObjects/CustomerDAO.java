package ShoppingApp.ShopKaro.DataAccessObjects;

import ShoppingApp.ShopKaro.Entities.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<CustomerDetails,Integer> {
    @Query("select id from CustomerDetails where mail=:mail or contact=:contact and password=:password")
    Integer getCustomerIdByMailAndPass(@Param("mail")String mail,@Param("password")String password,@Param("contact")String contact);
}
