package parser;

import exception.GameException;
import exception.WrongCommandException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class CommandParserTest {
    private CommandParser parser = new CommandParser();

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test(expected = WrongCommandException.class)
    public void should_be_invalid_when_input_ab12c() throws GameException {
        parser.matchCondition("ab12c");
        expectedEx.expectMessage("The input commands for rover are not valid!Please input commands as\"MRL\", try again");
    }

    @Test
    public void should_command_valid_when_put_MRLM() throws WrongCommandException {
        assertThat(parser.matchCondition("MRLM"), is(true));
    }

}
