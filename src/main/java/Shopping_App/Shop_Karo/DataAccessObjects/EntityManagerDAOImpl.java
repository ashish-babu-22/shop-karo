package Shopping_App.Shop_Karo.DataAccessObjects;

import Shopping_App.Shop_Karo.Entities.ProductDetails;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EntityManagerDAOImpl implements EntityManagerDAO{


    EntityManager entityManager;
    public EntityManagerDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<ProductDetails> itemsInCartById(int cartId) {
        TypedQuery<ProductDetails> cartItems = entityManager.createQuery("from product_details where cart_id = :id")
        return ;
    }
}
