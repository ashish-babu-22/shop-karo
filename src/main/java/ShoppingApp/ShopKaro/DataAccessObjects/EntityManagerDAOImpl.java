package ShoppingApp.ShopKaro.DataAccessObjects;

import ShoppingApp.ShopKaro.Entities.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


@Repository
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

    @Transactional
    @Override
    public CartItemDetails AddCartItem(int prod_id,int cart_id) {
        ProductDetails tempProd = entityManager.find(ProductDetails.class,prod_id);
        CartItemDetails cartItem = new CartItemDetails(tempProd.getName(),tempProd.getPrice());
         CartDetails temp;
        try{
        temp = entityManager.find(CartDetails.class,cart_id);}
        catch(Exception e){
            temp = new CartDetails(cart_id);
        }
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
    public int totalPrice(List<CartItemDetails> cartItemDetails) {
        int tot = 0;
        for(CartItemDetails item : cartItemDetails){
            int price = Integer.parseInt(item.getPrice().replaceAll("[^0-9]",""));
            tot+=price;
        }
        return tot;
    }

    @Transactional
    @Override
    public void deleteCartItemByProductId(int cart_id, int prod_id) {
        CartDetails cart = entityManager.find(CartDetails.class,cart_id);

        Query query = entityManager.createQuery("delete from cart_item_details where cart_id=:cartId and prod_id=:proId");
        query.setParameter("cartId",cart_id);
        query.setParameter("proId",prod_id);
        CartItemDetails temp = (CartItemDetails) query.getSingleResult();

    }


}
