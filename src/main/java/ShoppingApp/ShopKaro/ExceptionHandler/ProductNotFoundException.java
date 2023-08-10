package ShoppingApp.ShopKaro.ExceptionHandler;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message){
        super(message);
    }
    public ProductNotFoundException(int message){
        super("Product Not Found with ID = "+message);
    }
    public ProductNotFoundException(String message,Throwable cause){
        super(message,cause);
    }
    public ProductNotFoundException(Throwable cause){super(cause);}
}
