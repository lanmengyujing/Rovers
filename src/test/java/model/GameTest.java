package model;

import exception.GameException;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTest {
    @Test
    public void should_get_51E_When_Input_Rover_33E_Instruction_MMRMMRMRRM() throws Exception {
        Game game = new Game();

        String plateauInitStr = "12 12\n";
        ByteArrayInputStream in = new ByteArrayInputStream(plateauInitStr.getBytes());
        System.setIn(in);
        game.initPlateau();

        String roverInitStr = "3 3 E\n"
                + "MMRMMRMRRM\n";
        ByteArrayInputStream inRover = new ByteArrayInputStream(roverInitStr.getBytes());
        System.setIn(inRover);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        game.start();

        String standardOutput = out.toString();
        assertThat(standardOutput ,is("5 1 E"));
    }
}
