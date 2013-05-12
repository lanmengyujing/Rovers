package exception;


public class WrongCommandException extends GameException {
    public static final String COMMAND_TIP = "The input commands for rover are not valid!Please input commands as\"MRL\", try again";

    public WrongCommandException(String message) {
        super(message);
    }

    @Override
    public String getMessage(){
        return COMMAND_TIP;
    }
}
