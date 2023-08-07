package ShoppingApp.ShopKaro.DataAccessObjects;

import ShoppingApp.ShopKaro.Entities.CartItemDetails;
import ShoppingApp.ShopKaro.Entities.CustomerDetails;
import ShoppingApp.ShopKaro.Entities.ProductDetails;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class EntityManagerDAOImpl implements EntityManagerDAO{


    CartItemsDAO cartItemsDAO;
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

    @Override
    public CartItemDetails AddCartItem(int prod_id,int cart_id) {
        ProductDetails tempProd = entityManager.find(ProductDetails.class,prod_id);
        CartItemDetails cartItem = new CartItemDetails(tempProd.getName(),tempProd.getPrice());
        return cartItemsDAO.save(cartItem);
    }

    @Override
    public int findId(CustomerDetails customerDetails) {
        Query res = entityManager.createQuery("select id from customer_details where mail= :mail and password = :pass");
        res.setParameter("Mail",customerDetails.getMail());
        res.setParameter("pass",customerDetails.getPassword());

        try{
        return (int) res.getSingleResult();
       }
        catch(Exception e){
            return -1;
        }
    }


}
