package parser;

import exception.WrongCommandException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CommandParser implements Parser {
    String regEx = "^[L|M|R]*$";

    @Override
    public boolean matchCondition(String str) throws WrongCommandException {
        Pattern pattern = Pattern.compile(regEx);
        Matcher m = pattern.matcher(str);
        if (!m.find()) {
            throw new WrongCommandException(WrongCommandException.COMMAND_TIP);
        } else {
            return true;
        }
    }
}
