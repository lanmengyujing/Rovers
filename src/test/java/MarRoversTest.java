import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MarRoversTest {
    private MarRovers marRovers;

    @Before
    public void setup()  {
        marRovers = new MarRovers();
        marRovers.setPlateau("10 10");
    }

    @Test
    public void should_return_12N_when_input_11N_and_command_M(){
        marRovers.setInstruction("1 1 N");
        marRovers.executeInstruction("m");
        assertThat(marRovers.getOutput(), is("1 2 N"));
    }

    @Test
    public void should_return_11E_when_input_11N_and_command_R(){
        marRovers.setInstruction("1 1 N");
        marRovers.executeInstruction("r");
        assertThat(marRovers.getOutput(), is("1 1 E"));
    }

    @Test
    public void should_return_11W_when_input_11N_and_command_L(){
        marRovers.setInstruction("1 1 N");
        marRovers.executeInstruction("L");
        assertThat(marRovers.getOutput(), is("1 1 W"));
    }

    @Test
    public void should_OutPut_Be_14W_When_Input_Rover_23N_Instruction_LMRML(){

    }

    @Test
    public void should_OutPut_Be_12N_When_Input_Rover_13N_Instruction_LMLMLMLMM(){

    }

    @Test
    public void should_OutPut_Be_51E_When_Input_Rover_33E_Instruction_MMRMMRMRRM(){

    }
}
