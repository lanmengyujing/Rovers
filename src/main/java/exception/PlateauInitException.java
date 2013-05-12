package exception;


public class PlateauInitException extends GameException {
    public static final String PLATEAU_INIT_TIP = "The input area for Plateau is not valid! Please input two parameters as \"x y\" ,try again";


    public PlateauInitException(String message) {
        super(message);
    }

    @Override
    public String getMessage(){
        return PLATEAU_INIT_TIP;
    }
}
