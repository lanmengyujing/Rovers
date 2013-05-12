package parser;

import exception.GameException;

public interface Parser {
    public boolean matchCondition(String str) throws GameException;
}
