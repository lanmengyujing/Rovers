package state;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WStateTest {

    private WState state;
    @Before
    public void setUp() throws Exception {
        state = new WState();
    }

    @Test
    public void should_get_N_when_turn_right(){
        State newState = state.turnRight();
        assertThat(newState.getDirection(), is('N'));
    }
}
