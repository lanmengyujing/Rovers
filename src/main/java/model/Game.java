package model;


import exception.GameException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    MarRovers marRovers;
    public void initPlateau() throws IOException, GameException {
        marRovers = new MarRovers();
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        String plateauInitStr = reader.readLine();
        marRovers.initPlateau(plateauInitStr);
    }

    public void start() throws Exception {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        String roverInitStr = reader.readLine();
        marRovers.setInstruction(roverInitStr);
        String command = reader.readLine();
        marRovers.executeInstruction(command);
        System.out.print(marRovers.getOutput());

    }
}
