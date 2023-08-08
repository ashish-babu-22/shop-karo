package ShoppingApp.ShopKaro.ExceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.LocalTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> exceptionHandling(ProductNotFoundException exception){
        ProductErrorResponse error = new ProductErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                String.valueOf(LocalTime.now())
        );
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> exceptionHandling(UserNotFoundException exception){
        ProductErrorResponse error = new ProductErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                String.valueOf(LocalDateTime.now())
        );
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> exceptionHandler(Exception exception){
        ProductErrorResponse errorResponse = new ProductErrorResponse(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                String.valueOf(LocalDateTime.now())
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);

    }

}
