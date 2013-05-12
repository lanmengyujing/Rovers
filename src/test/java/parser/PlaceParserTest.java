package parser;

import exception.GameException;
import exception.PlaceRoverCommandException;
import exception.WrongCommandException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlaceParserTest {
    private PlaceParser parser;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setup() {
        parser = new PlaceParser();
    }

    @Test(expected = PlaceRoverCommandException.class)
    public void should_throw_exception_when_input_23t() throws PlaceRoverCommandException {
        parser.matchCondition("2 3 t");
        expectedEx.expectMessage("The input position or orientation for rover is not valid! try again");
    }

    @Test
    public void should_command_valid_when_put_MRLM() throws PlaceRoverCommandException {
        assertThat(parser.matchCondition("1 2 W"), is(true));
    }
}
