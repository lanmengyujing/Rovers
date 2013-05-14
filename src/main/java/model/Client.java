package model;


import exception.CrashException;
import exception.GameException;
import exception.OutOfBoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {

    private MarRovers marRovers;
    private InputStreamReader input;
    private BufferedReader reader;

    public void initPlateau() {
        marRovers = new MarRovers();
        initReader();
        while (true) {
            String plateauInitStr = readLine();
            try {
                marRovers.initPlateau(plateauInitStr);
                break;
            } catch (GameException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private void initReader() {
        input = new InputStreamReader(System.in);
        reader = new BufferedReader(input);
    }

    public void start() {
        initReader();
        while (true) {
            String roverInitStr = readLine();
            try {
                marRovers.initRoverState(roverInitStr);
                break;
            } catch (GameException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            String command = readLine();
            try {
                marRovers.executeInstruction(command);
                break;
            } catch (OutOfBoundException e) {
                System.out.println(e.getMessage());
                break;
            } catch (CrashException e) {
                System.out.println(e.getMessage());
                break;
            } catch (GameException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print(marRovers.getOutput());
    }

    private String readLine() {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.getMessage();
        }
        return line;
    }
}
