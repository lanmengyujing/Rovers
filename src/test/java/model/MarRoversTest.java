package model;

import exception.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MarRoversTest {
    private MarRovers marRovers;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setup() throws GameException {
        marRovers = new MarRovers();
        marRovers.initPlateau("10 10");
    }

    @Test
    public void should_return_12N_when_input_11N_and_command_M() throws GameException {
        marRovers.setInstruction("1 1 N");
        marRovers.executeInstruction("m");
        assertThat(marRovers.getOutput(), is("1 2 N"));
    }

    @Test
    public void should_return_11E_when_input_11N_and_command_R() throws GameException {
        marRovers.setInstruction("1 1 n");
        marRovers.executeInstruction("r");
        assertThat(marRovers.getOutput(), is("1 1 E"));
    }

    @Test
    public void should_return_11W_when_input_11N_and_command_L() throws GameException {
        marRovers.setInstruction("1 1 N");
        marRovers.executeInstruction("l");
        assertThat(marRovers.getOutput(), is("1 1 W"));
    }

    @Test
    public void should_OutPut_Be_12N_When_Input_Rover_13N_Instruction_LMLMLMLMM() throws GameException {
        marRovers.setInstruction("1 2 N");
        marRovers.executeInstruction("LMLMLMLMM");
        assertThat(marRovers.getOutput(), is("1 3 N"));
    }

    @Test
    public void should_OutPut_Be_51E_When_Input_Rover_33E_Instruction_MMRMMRMRRM() throws GameException {
        marRovers.setInstruction("3 3 e");
        marRovers.executeInstruction("MMRMMRMRRM");
        assertThat(marRovers.getOutput(), is("5 1 E"));
    }

    @Test
    public void should_OutPut_Be_14W_When_Input_Rover_23N_Instruction_LMRML() throws GameException {
        marRovers.setInstruction("2 3 N");
        marRovers.executeInstruction("LMRML");
        assertThat(marRovers.getOutput(), is("1 4 W"));
    }

    @Test
    public void should_rover_be_9_10_N_When_Instruction_MM() throws GameException {
        marRovers.setInstruction("9 8 N");
        marRovers.executeInstruction("LRMm");
        assertThat(marRovers.getOutput(), is("9 10 N"));
    }

    @Test(expected = OutOfBoundException.class)
    public void should_rover_be_out_bound_when_move_beyond_10_10() throws GameException {
        marRovers.setInstruction("9 9 N");
        marRovers.executeInstruction("Mm");
        expectedEx.expectMessage("rover out of bound!");
    }

    @Test(expected = OutOfBoundException.class)
    public void should_rover_be_out_bound_when_move_out_00() throws GameException {
        marRovers.setInstruction("0 0 N");
        marRovers.executeInstruction("LMm");
        expectedEx.expectMessage("rover out of bound!");
    }

    @Test(expected = CrashException.class)
    public void should_Rovers_Crash_When_Input_Rover_1_1_N_Instruction_M_And_Rover_1_3_S_Instruction_M() throws GameException {
        marRovers.setInstruction("1 1 N");
        marRovers.executeInstruction("m");
        marRovers.setInstruction("1 3 s");
        marRovers.executeInstruction("m");
        expectedEx.expectMessage("Rovers crash each other");
    }

    @Test(expected = PlaceRoverCommandException.class)
    public void should_instruction_wrong_when_input_11h() throws GameException {
        marRovers.setInstruction("1 1 h");
        expectedEx.expectMessage("The input position or orientation for rover is not valid! try again");
    }

    @Test(expected = WrongCommandException.class)
    public void should_command_wrong_when_input_MP9RL() throws GameException {
        marRovers.setInstruction("1 1 N");
        marRovers.executeInstruction("P9R");
        expectedEx.expectMessage("The input commands for rover are not valid!Please input commands as\"MRL\", try again");
    }

    @Test(expected = PlateauInitException.class)
    public void should_plateau_init_wrong_when_input_p8() throws GameException {
        marRovers.initPlateau("p 8");
        expectedEx.expectMessage("The input area for Plateau is not valid! Please input two parameters as \"x y\" ,try again");
    }

    @Test(expected = PlateauInitException.class)
    public void should_plateau_init_wrong_when_input_negative_2_8() throws GameException {
        marRovers.initPlateau("-2 8");
        expectedEx.expectMessage("The input area for Plateau is not valid! Please input two parameters as \"x y\" ,try again");
    }
}
