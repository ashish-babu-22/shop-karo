package ShoppingApp.ShopKaro.ExceptionHandler;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){super(message);}
public UserNotFoundException(int message){super("User Not Found with ID = "+message);}

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
