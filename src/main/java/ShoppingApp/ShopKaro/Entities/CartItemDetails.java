package ShoppingApp.ShopKaro.Entities;


import javax.persistence.*;


@Entity
@Table(name = "cart_item_details")
public class CartItemDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    int prodId;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    String price;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "cart_id")
    private CartDetails cartDetails_inCI;


    public CartDetails getCartDetails_inCI() {
        return cartDetails_inCI;
    }

    public void setCartDetails_inCI(CartDetails cartDetails_inCI) {
        this.cartDetails_inCI = cartDetails_inCI;
    }

    public CartItemDetails(){}

    public CartItemDetails(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CartItemDetails{" +
                "prodId=" + prodId +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
