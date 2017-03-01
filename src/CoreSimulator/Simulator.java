package CoreSimulator;

/**
 * @author vikson-6
 */
public class Simulator {
    private EventStore events = new EventStore();
    private State state = new State();

    /**
     * Run the simulation, executing the Event.effect() on the current
     * State until the EventStore is empty.
     *
     * NOTE: shouldn't the last element in the EventStore be a StopEvent?
     */
    public void run() {
        Event event;
        while ((event = events.poll()) != null) {
            if (state.stopSimulation)
                break;

            event.effect(state);
        }
    }
}
