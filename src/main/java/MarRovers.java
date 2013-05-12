import state.*;

public class MarRovers {

    private int posX;
    private int posY;
    private char direction;
    private Plateau plateau;
    private State state;

    public void setInstruction(String instruction) {
        String[] instructions = instruction.split(" ");
        posX = Integer.valueOf(instructions[0]);
        posY = Integer.valueOf(instructions[1]);
        direction = instructions[2].charAt(0);
        state = getStateByChar(direction);
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

    public void executeInstruction(String commandStr) {
        commandStr = commandStr.toUpperCase();
        for (char command : commandStr.toCharArray()) {
            if (command == 'M') {
                switch (state.getDirection()) {
                    case 'N':
                        posY++;
                        break;
                    case 'S':
                        posY--;
                        break;
                    case 'E':
                        posX++;
                        break;
                    case 'W':
                        posX--;
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            if (command == 'R') {
                state = state.turnRight();
            }
            if (command == 'L') {
                state = state.turnLeft();
                System.out.println(state);
            }
        }
    }

    public void setPlateau(String plateauStr) {
        String[] plateauInstruction = plateauStr.split(" ");
        int x = Integer.valueOf(plateauInstruction[0]);
        int y = Integer.valueOf(plateauInstruction[0]);
        plateau = new Plateau(x, y);
    }

    public String getOutput() {
        char direction = state.getDirection();
        return "" + posX + " " + posY + " " + direction;
    }
}
