package state;


import model.Rover;

public class EState implements State {

    @Override
    public State turnRight() {
        return new SState();
    }

    @Override
    public State turnLeft() {
        return new NState();
    }

    @Override
    public char getDirection() {
        return 'E';
    }

    @Override
    public Rover move(Rover rover) {
        rover.addX(1);
        return rover;
    }


}
