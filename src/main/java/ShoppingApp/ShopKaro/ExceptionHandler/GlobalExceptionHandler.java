package ShoppingApp.ShopKaro.ExceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date dateObject = new Date();
    String date = String.valueOf(dateObject);
    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> exceptionHandling(ProductNotFoundException exception){
        ProductErrorResponse error = new ProductErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                date
        );
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> exceptionHandling(UserNotFoundException exception){
        ProductErrorResponse error = new ProductErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "User Not Found with ID = "+exception.getMessage(),
                date
        );
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> exceptionHandler(Exception exception){
        ProductErrorResponse errorResponse = new ProductErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                date
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);

    }

}
