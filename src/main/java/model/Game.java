package model;


import exception.GameException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    private MarRovers marRovers;
    private InputStreamReader input;
    private BufferedReader reader;

    public void initPlateau() {
        marRovers = new MarRovers();
        input = new InputStreamReader(System.in);
        reader = new BufferedReader(input);

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

    public void start() {
        input = new InputStreamReader(System.in);
        reader = new BufferedReader(input);
        while (true) {
            String roverInitStr = readLine();
            try {
                marRovers.setInstruction(roverInitStr);
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
