package ShoppingApp.ShopKaro.DataAccessObjects;

import ShoppingApp.ShopKaro.Entities.ProductDetails;

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
        TypedQuery<ProductDetails> cartItems = entityManager.createQuery("select p from product_details where cart_details.cart_id = :id",ProductDetails.class);
        cartItems.setParameter("id",cartId);

        return cartItems.getResultList();
    }




}
