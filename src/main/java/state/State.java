package state;


public interface State {
    public State turnRight();
    public State turnLeft();
    public char getDirection();
}
