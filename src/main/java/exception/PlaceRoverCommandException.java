package exception;


public class PlaceRoverCommandException extends GameException {
    public static final String ROVER_INIT_TIP = "The input position or orientation for rover is not valid! try again";

    public PlaceRoverCommandException(String message) {
        super(message);
    }

    @Override
    public String getMessage(){
        return ROVER_INIT_TIP;
    }

}
