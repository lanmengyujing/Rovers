package state;

public class SState implements State {
    @Override
    public State turnRight() {
        return new WState();

    }

    @Override
    public State turnLeft() {
        return new EState();
    }

    @Override
    public char getDirection() {
        return 'S';
    }
}
