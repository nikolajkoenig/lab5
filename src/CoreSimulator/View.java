package CoreSimulator;

import java.util.Observable;
import java.util.Observer;

/**
 * @author vikson-6
 */
abstract public class View implements Observer {
    public State state;

    public View(State state) {
        this.state = state;
        state.addObserver(this);
    }

    public void update(Observable observable, Object o) {
        this.print();
    }

    /**
     * Prints a representation of the data available in
     * the State object.
     */
    abstract void print();
}
