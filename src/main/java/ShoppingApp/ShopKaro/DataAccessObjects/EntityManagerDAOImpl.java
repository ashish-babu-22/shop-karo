package ShoppingApp.ShopKaro.DataAccessObjects;

import ShoppingApp.ShopKaro.Entities.CartDetails;
import ShoppingApp.ShopKaro.Entities.CartItemDetails;
import ShoppingApp.ShopKaro.Entities.CustomerDetails;
import ShoppingApp.ShopKaro.Entities.ProductDetails;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class EntityManagerDAOImpl implements EntityManagerDAO{


    CartItemsDAO cartItemsDAO;
    CartDAO cartDAO;
    EntityManager entityManager;
    public EntityManagerDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

//    @Override
//    public List<CartItemDetails> itemsInCartById(int cartId) {
//        CartDetails temp = entityManager.find(CartDetails.class,cartId);
//        return temp.getCartItemDetails();
//    }

    @Override
    public CartItemDetails AddCartItem(int prod_id,int cart_id) {
        ProductDetails tempProd = entityManager.find(ProductDetails.class,prod_id);
        CartItemDetails cartItem = new CartItemDetails(tempProd.getName(),tempProd.getPrice());
        CartDetails temp = entityManager.find(CartDetails.class,cart_id);
        temp.add(cartItem);
        cartDAO.save(temp);
        return cartItem;
    }

    @Override
    public int findId(CustomerDetails customerDetails) {
        Query res = entityManager.createQuery("select id from customer_details where mail= :mail and password = :pass");
        res.setParameter("Mail",customerDetails.getMail());
        res.setParameter("pass",customerDetails.getPassword());
        int result = 0;
        try{
         //result =
           return (Integer) res.getSingleResult();

            }
        catch(Exception e){
            return -1;
        }

    }

    @Override
    public int totalPrice(CartItemDetails cartItemDetails) {
        Query query = entityManager.createQuery("select sum(c.price) from cart_item_details c");
        try {
            return (Integer)query.getSingleResult();
        }
        catch (Exception e){
            return -1;
        }
    }

    @Override
    public void deleteCartItemByProductId(int cart_id, int prod_id) {
        CartDetails cart = entityManager.find(CartDetails.class,cart_id);

        Query query = entityManager.createQuery("delete from cart_item_details where cart_id=:cartId and prod_id=:proId");
        query.setParameter("cartId",cart_id);
        query.setParameter("proId",prod_id);
        CartItemDetails temp = (CartItemDetails) query.getSingleResult();

    }


}
