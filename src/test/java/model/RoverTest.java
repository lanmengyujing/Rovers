package model;

import exception.OutOfBoundException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import state.NState;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RoverTest {
    private Rover rover;
    private Plateau plateau;

    @Before
    public void setup(){
        rover = new Rover(2, 4 , new NState());
        plateau = new Plateau(5, 5);
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void should_OutPut_Be_24E_When_Instruction_R() throws OutOfBoundException {
        rover.setPlateau(plateau);
        rover.executeInstruction('R');
        assertThat(rover.getOutput(), is("2 4 E"));
    }

    @Test
    public void should_OutPut_Be_24W_When_Instruction_L() throws OutOfBoundException {
        rover.setPlateau(plateau);
        rover.executeInstruction('L');
        assertThat(rover.getOutput(), is("2 4 W"));
    }

    @Test
    public void should_OutPut_Be_25N_When_Instruction_M() throws OutOfBoundException {
        rover.setPlateau(plateau);
        rover.executeInstruction('M');
        assertThat(rover.getOutput(), is("2 5 N"));

    }

    @Test(expected = OutOfBoundException.class)
    public void should_Out_Bound_When_Instruction_MM() throws OutOfBoundException {
        rover.setPlateau(plateau);
        rover.executeInstruction('M');
        rover.executeInstruction('M');
        expectedEx.expectMessage("rover out of bound!");
    }

}
