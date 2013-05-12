import exception.OutOfBoundException;
import state.*;

public class MarRovers {
    private Rover rover;
    private Plateau plateau;

    public void initPlateau(String plateauStr) {
        String[] plateauInstruction = plateauStr.split(" ");
        int x = Integer.valueOf(plateauInstruction[0]);
        int y = Integer.valueOf(plateauInstruction[0]);
        plateau = new Plateau(x, y);
    }

    public void setInstruction(String instruction) {
        String[] instructions = instruction.toUpperCase().split(" ");
        int posX = Integer.valueOf(instructions[0]);
        int posY = Integer.valueOf(instructions[1]);
        State state = getStateByChar(instructions[2].charAt(0));
        rover = new Rover(posX, posY, state);
        rover.setPlateau(plateau);
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

    public void executeInstruction(String commandStr) throws OutOfBoundException {
        rover.executeInstruction(commandStr);
    }

    public String getOutput() {
        return rover.getOutput();
    }

}
