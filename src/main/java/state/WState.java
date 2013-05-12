package state;

public class WState implements State{
    @Override
    public State turnRight() {
        return new NState();
    }

    @Override
    public State turnLeft() {
        return new SState();
    }

    @Override
    public char getDirection() {
        return 'W';
    }
}
