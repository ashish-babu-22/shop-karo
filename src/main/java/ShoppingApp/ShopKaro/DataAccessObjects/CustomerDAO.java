package ShoppingApp.ShopKaro.DataAccessObjects;

import ShoppingApp.ShopKaro.Entities.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerDAO extends JpaRepository<CustomerDetails,Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into users (username,password,status) VALUES (:uname,:pass,1)",nativeQuery = true)
    void addToUserDB(@Param("uname")String uname,@Param("pass")String pass);

    @Transactional
    @Modifying
    @Query(value = "insert into roles (username,role) VALUES (:uname,'ROLE_CUSTOMER')",nativeQuery = true)
    void addToRolesDB(@Param("uname")String username);

    @Query("select id from CustomerDetails where mail=:mail or contact=:contact and password=:password")
    Integer getCustomerIdByMailAndPass(@Param("mail")String mail,@Param("password")String password,@Param("contact")String contact);
}
