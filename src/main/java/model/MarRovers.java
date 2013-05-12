package model;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import exception.*;
import state.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarRovers {
    private Rover rover;
    private Plateau plateau;
    List<Rover> roverList = new ArrayList<Rover>();

    public void initPlateau(String plateauStr) throws PlateauInitException {
        String regEx = "^\\s*\\d*+\\s+\\d*\\s*$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher m = pattern.matcher(plateauStr);
        if(!m.find()){
            throw new PlateauInitException(PlateauInitException.PLATEAU_INIT_TIP);
        }
        String[] plateauInstruction = plateauStr.split(" ");
        int x = Integer.valueOf(plateauInstruction[0]);
        int y = Integer.valueOf(plateauInstruction[0]);
        plateau = new Plateau(x, y);
    }

    public void setInstruction(String instructionStr) throws PlaceRoverCommandException {
        String instruction = instructionStr.toUpperCase();
        String regEx = "^\\s*\\d*+\\s+\\d*+\\s+[N|S|W|E]\\s*$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher m = pattern.matcher(instruction);
        if(!m.find()){
            throw new PlaceRoverCommandException(PlaceRoverCommandException.ROVER_INIT_TIP);
        }

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
        String regEx = "^[L|M|R]*$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher m = pattern.matcher(commandStr);
        if(!m.find()){
            throw new WrongCommandException(WrongCommandException.COMMAND_TIP);
        }
        for (char command : commandStr.toCharArray()) {
            rover.executeInstruction(command);
            checkCrash(rover);
        }
    }

    private void checkCrash(Rover rover) throws CrashException {
        for (Rover roverIn : roverList) {
            if ( !(roverIn.hashCode() == rover.hashCode() && roverIn.equals(rover))
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
