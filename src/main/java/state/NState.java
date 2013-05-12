package state;
public class NState implements State {
    @Override
    public State turnRight() {
        return new EState();
    }

    @Override
    public State turnLeft() {
        return new WState();
    }

    @Override
    public char getDirection() {
        return 'N';
    }

}
