package CoreSimulator;

import java.sql.Time;

/**
 * @author vikson-6
 */
abstract public class Event {
    public final Time time;

    public Event(int hour, int minute, int second) {
        time = new Time(hour, minute, second);
    }

    /**
     * Execute the Event's effect on the current State.
     */
    abstract void effect(State state);
}
