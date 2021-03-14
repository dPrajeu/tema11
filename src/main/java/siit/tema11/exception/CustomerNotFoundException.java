package siit.tema11.exception;

import org.hibernate.exception.ConstraintViolationException;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message){
        super(message);
    }
}
