package model;

import exception.OutOfBoundException;
import state.State;

public class Rover {
    private int posX;
    private int posY;
    private State state;
    private Plateau plateau;

    public Rover(int posX, int posY, State state) {
        this.posX = posX;
        this.posY = posY;
        this.state = state;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public void executeInstruction(char command) throws OutOfBoundException {
        switch (command) {
            case 'M':
                forward();
                break;
            case 'R':
                state = state.turnRight();
                break;
            case 'L':
                state = state.turnLeft();
                break;
            default:
                throw new AssertionError();
        }
    }

    private void forward() throws OutOfBoundException {
        switch (state.getDirection()) {
            case 'N':
                addY(1);
                break;
            case 'S':
                addY(-1);
                break;
            case 'E':
                addX(1);
                break;
            case 'W':
                addX(-1);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void addY(int step) throws OutOfBoundException {
        posY += step;
        if (isOutRange(posX, posY)) {
            throw new OutOfBoundException(OutOfBoundException.OUT_OF_BOUND);
        }
    }

    public void addX(int step) throws OutOfBoundException {
        posX += step;
        if (isOutRange(posX, posY)) {
            throw new OutOfBoundException(OutOfBoundException.OUT_OF_BOUND);
        }
    }

    private boolean isOutRange(int posX, int posY) {
        return plateau.isOutRange(posX, posY);
    }

    public String getOutput() {
        char direction = state.getDirection();
        return "" + posX + " " + posY + " " + direction;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
