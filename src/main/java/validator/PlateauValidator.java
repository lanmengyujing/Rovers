package validator;

import exception.PlateauInitException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlateauValidator implements Validator {
    private String regEx = "^\\s*\\d*+\\s+\\d*\\s*$";

    public boolean matchCondition(String str) throws PlateauInitException {
        Pattern pattern = Pattern.compile(regEx);
        Matcher m = pattern.matcher(str);
        if (!m.find()) {
            throw new PlateauInitException(PlateauInitException.PLATEAU_INIT_TIP);
        }else {
            return true;
        }
    }
}
