package state;


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
}
