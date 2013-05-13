package model;

import exception.*;
import parser.CommandParser;
import parser.Parser;
import parser.PlaceParser;
import parser.PlateauParser;
import state.*;

import java.util.ArrayList;
import java.util.List;

public class MarRovers {
    private Rover rover;
    private Plateau plateau;
    List<Rover> roverList = new ArrayList<Rover>();

    public void initPlateau(String plateauStr) throws GameException {
        Parser parser = new PlateauParser();
        parser.matchCondition(plateauStr);
        String[] plateauInstruction = plateauStr.split(" ");
        int x = Integer.valueOf(plateauInstruction[0]);
        int y = Integer.valueOf(plateauInstruction[0]);
        plateau = new Plateau(x, y);
    }

    public void setInstruction(String instructionStr) throws GameException {
        String instruction = instructionStr.toUpperCase();
        Parser parser = new PlaceParser();
        parser.matchCondition(instruction);
        String[] instructions = instruction.split(" ");
        int posX = Integer.valueOf(instructions[0]);
        int posY = Integer.valueOf(instructions[1]);
        State state = getStateByChar(instructions[2].charAt(0));
        rover = new Rover(posX, posY, state);
        rover.setPlateau(plateau);
        roverList.add(rover);
    }

    private State getStateByChar(char direction) {
        switch (direction) {
            case 'N':
                return new NState();
            case 'S':
                return new SState();
            case 'E':
                return new EState();
            case 'W':
                return new WState();
            default:
                throw new AssertionError();
        }
    }

    public void executeInstruction(String commandStr) throws GameException {
        commandStr = commandStr.toUpperCase();
        Parser parser = new CommandParser();
        parser.matchCondition(commandStr);
        for (char command : commandStr.toCharArray()) {
            rover.executeInstruction(command);
            checkCrash(rover);
        }
    }

    private void checkCrash(Rover rover) throws CrashException {
        for (Rover roverIn : roverList) {
            if (!(roverIn.hashCode() == rover.hashCode() && roverIn.equals(rover))
                    && (roverIn.getPosX() == rover.getPosX())
                    && (roverIn.getPosY() == rover.getPosY())) {
                throw new CrashException(CrashException.CRASH_TIP);
            }
        }
    }

    public String getOutput() {
        return rover.getOutput();
    }

}
