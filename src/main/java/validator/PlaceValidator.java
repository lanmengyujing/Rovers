package validator;


import exception.PlaceRoverCommandException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlaceValidator implements Validator {
    private String regEx = "^\\s*\\d*+\\s+\\d*+\\s+[N|S|W|E]\\s*$";

    @Override
    public boolean matchCondition(String str) throws PlaceRoverCommandException {
        Pattern pattern = Pattern.compile(regEx);
        Matcher m = pattern.matcher(str);
        if (!m.find()) {
            throw new PlaceRoverCommandException(PlaceRoverCommandException.ROVER_INIT_TIP);
        }else {
            return true;
        }
    }
}
