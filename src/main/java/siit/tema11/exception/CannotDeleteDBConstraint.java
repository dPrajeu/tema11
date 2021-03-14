package siit.tema11.exception;

public class CannotDeleteDBConstraint extends RuntimeException{
    public CannotDeleteDBConstraint(String message){
        super(message);
    }
}
