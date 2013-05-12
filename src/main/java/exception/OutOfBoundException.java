package exception;

public class OutOfBoundException extends GameException {
    public static final String OUT_OF_BOUND =  "rover out of bound!";

    public OutOfBoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage(){
        return OUT_OF_BOUND;
    }
}
