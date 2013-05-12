package state;

public interface State {
    public State turnRight();
    public State turnLeft();
    public char getDirection();

//
//    NState('N', 1),
//    EState('E', 2),
//    SState('S', 3),
//    WState(4);
//
//    private int value;
//
//    private state.State(int value) {
//        this.value = value;
//    }
//
//    private int value() {
//        return value;
//    }
//
//    public state.State turnRight() {
//        int nextValue = (value + 1)%4;
//        return createState(nextValue);
//    }
//
//    public state.State turnLeft() {
//        int nextValue = (value - 1)%4;
//        return createState(nextValue);
//    }
//
//    private state.State createState(int nextValue) {
//        for (state.State state  : state.State.values()) {
//            if(state.value()  == nextValue) {
//                return state;
//            }
//        }
//        return null;
//    }


}
