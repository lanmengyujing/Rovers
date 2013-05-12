package state;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SStateTest {
    private SState state;
    @Before
    public void setUp() throws Exception {
        state = new SState();
    }

    @Test
    public void should_get_W_when_turn_right(){
        State newState = state.turnRight();
        assertThat(newState.getDirection(), is('W'));
    }

    @Test
    public void should_get_S_when_turn_left(){
        State newState = state.turnLeft();
        assertThat(newState.getDirection(), is('E'));
    }
}
