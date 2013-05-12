package model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlateauTest {
    private Plateau plateau;
    @Before
    public void setup(){
        plateau = new Plateau(5, 5);
    }

    @Test
    public void should_in_range_when_input_not_bigger_than_range() {
        assertThat(plateau.isOutRange(5, 5), is(false));
    }

    @Test
    public void should_in_range_when_input_zero() {
        assertThat(plateau.isOutRange(0, 0), is(false));
    }

    @Test
    public void should_in_range_when_input_3and4() {
        assertThat(plateau.isOutRange(3, 4), is(false));
    }

    @Test
    public void should_out_range_when_input_bigger_than_range() {
        assertThat(plateau.isOutRange(6, 7), is(true));
    }

    @Test
    public void should_out_range_when_input_nagative() {
        assertThat(plateau.isOutRange(-6, -7), is(true));
    }

}
