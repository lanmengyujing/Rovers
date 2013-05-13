package model;

import exception.CrashException;
import exception.GameException;
import exception.OutOfBoundException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTest {
     private Game game;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setup() throws IOException, GameException {
        game = new Game();
        String plateauInitStr = "10 10\n";
        setSystemIn(plateauInitStr);
        game.initPlateau();

    }

    @Test
    public void should_get_51E_when_input_rover_33E_instruction_MMRMMRMRRM() throws Exception {
        String roverInitStr = "3 3 E\n"
                + "MMRMMRMRRM\n";
        setSystemIn(roverInitStr);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        game.start();

        String standardOutput = out.toString();
        assertThat(standardOutput ,is("5 1 E"));
    }

    @Test(expected = OutOfBoundException.class)
    public void should_rover_out_bound_when_input_rover_97E_instruction_MMRM() throws Exception {
        String roverInitStr = "9 7 E\n"
                + "MMRM\n";
        setSystemIn(roverInitStr);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        game.start();
        expectedEx.expectMessage(OutOfBoundException.OUT_OF_BOUND);
        String standardOutput = out.toString();
        assertThat(standardOutput ,is(""));
    }

    @Test(expected = CrashException.class)
    public void should_rovers_crash_when_input_rover_1_1_N_instruction_M_and_rover_1_3_S_instruction_MM() throws Exception {
        String roverInitStr = "1 1 N\n"
                + "M\n";
        setSystemIn(roverInitStr);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        game.start();
        String standardOutput = out.toString();
        assertThat(standardOutput ,is("1 2 N"));

        String roverNextStr = "1 3 S\n"
                + "MM\n";
        setSystemIn(roverNextStr);
        System.setOut(new PrintStream(out));

        game.start();
        expectedEx.expectMessage(CrashException.CRASH_TIP);
    }

    private void setSystemIn(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
