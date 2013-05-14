package model;

import exception.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ClientTest {
     private Client client;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setup() throws IOException, GameException {
        client = new Client();
        String plateauInitStr = "10 10\n";
        setSystemIn(plateauInitStr);
        client.initPlateau();

    }

    @Test
    public void should_get_51E_when_input_rover_33E_instruction_MMRMMRMRRM() throws Exception {
        String roverInitStr = "3 3 E\n"
                + "MMRMMRMRRM\n";
        setSystemIn(roverInitStr);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        client.start();

        String standardOutput = out.toString();
        assertThat(standardOutput ,is("5 1 E"));
    }

    @Test
    public void should_rover_out_bound_when_input_rover_97E_instruction_MMRM() throws Exception {
        String roverInitStr = "9 7 E\n"
                + "MMRM\n " +
                "1 2 N\n";
        setSystemIn(roverInitStr);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        client.start();
        String standardOutput = out.toString();
        assertThat(standardOutput ,is(OutOfBoundException.OUT_OF_BOUND + "\n11 7 E"));
    }

    @Test
    public void should_rovers_crash_when_input_rover_1_1_N_instruction_M_and_rover_1_3_S_instruction_MM() throws Exception {
        String roverInitStr = "1 1 N\n"
                + "M\n " +
                "1 2 N\n";
        setSystemIn(roverInitStr);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        client.start();
        String standardOutput = out.toString();
        assertThat(standardOutput ,is("1 2 N"));

        String roverNextStr = "1 3 S\n"
                + "MM\n";
        setSystemIn(roverNextStr);

        client.start();
        String totalOutput = out.toString();

        assertThat(totalOutput ,is("1 2 N"+ CrashException.CRASH_TIP + "\n1 2 S"));
    }


    @Test
    public void should_show_tip_when_input_wrong_instruction_for_plateau() throws Exception {
        String plateauInitStr = "10 s\n" +
                "10 10\n";
        setSystemIn(plateauInitStr);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        client.initPlateau();
        String standardOutput = out.toString();
        assertThat(standardOutput ,is(PlateauInitException.PLATEAU_INIT_TIP+"\n"));
    }

    @Test
    public void should_show_tip_when_input_wrong_place_instruction_for_rover() throws Exception {
        String roverInitStr = "3 a E\n"
                +"3 3 E\n"
                + "MMRMMRMRRM\n";
        setSystemIn(roverInitStr);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        client.start();
        String standardOutput = out.toString();
        assertThat(standardOutput ,is(PlaceRoverCommandException.ROVER_INIT_TIP + "\n5 1 E"));
    }

    @Test
    public void should_show_tip_when_input_wrong_command_for_rover() throws Exception {
        String roverInitStr = "3 3 E\n"
                +"m67ad\n"
                + "MMRMMRMRRM\n";
        setSystemIn(roverInitStr);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        client.start();
        String standardOutput = out.toString();
        assertThat(standardOutput ,is(WrongCommandException.COMMAND_TIP + "\n5 1 E"));

    }

    private void setSystemIn(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
