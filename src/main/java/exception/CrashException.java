package exception;

public class CrashException extends GameException {
    public static final String CRASH_TIP = "Rovers crash each other";

    @Override
    public String getMessage(){
        return CRASH_TIP;
    }

    public CrashException(String message){
        super(message);
    }
}
