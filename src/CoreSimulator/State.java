package CoreSimulator;

import java.sql.Time;
import java.util.Observable;

/**
 * @author vikson-6
 *
 * Represent the current state in the simulation.
 */
public class State extends Observable {
    public boolean stopSimulation;
    public Time time;

    /* Implement statistical functions in the parent State class. */
}
