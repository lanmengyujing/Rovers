package validator;

import exception.GameException;

public interface Validator {
    public boolean matchCondition(String str) throws GameException;
}
