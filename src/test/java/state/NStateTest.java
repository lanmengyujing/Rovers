package state;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NStateTest {
    private NState state;
    @Before
    public void setUp() throws Exception {
        state = new NState();
    }

    @Test
    public void should_get_E_when_turn_right(){
        State newState = state.turnRight();
        assertThat(newState.getDirection(), is('E'));
    }

    @Test
    public void should_get_W_when_turn_left(){
        State newState = state.turnLeft();
        assertThat(newState.getDirection(), is('W'));
    }
}
