package validator;

import exception.PlateauInitException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlateauParserTest {
    PlateauValidator parser;
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setup(){
        parser = new PlateauValidator();
    }

    @Test(expected = PlateauInitException.class)
    public void should_be_invalid_when_input_ab12c() throws PlateauInitException {
        parser.matchCondition("w 0");
        expectedEx.expectMessage("The input area for Plateau is not valid! Please input two parameters as \"x y\" ,try again");
    }

    @Test
    public void should_command_valid_when_put_MRLM() throws PlateauInitException {
        assertThat(parser.matchCondition("5 10"), is(true));
    }

}
