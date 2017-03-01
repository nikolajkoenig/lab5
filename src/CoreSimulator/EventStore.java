package CoreSimulator;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author vikson-6
 */
public class EventStore {
    private Comparator<Event> byTime;
    private PriorityQueue<Event> queue;
    private static final int initialCapacity = 10;

    public EventStore() {
        byTime = new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                /* Sort events in a timely order. */
                return e1.time.compareTo(e2.time);
            }
        };

        queue = new PriorityQueue<>(initialCapacity, byTime);
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     *
     * @return the head of this queue, or null if this queue is empty
     */
    public Event poll() {
        return queue.poll();
    }

    /**
     * Inserts the specified element into the queue, the resulting position in the queue
     * depends on the Event's time field.
     *
     * @param e the element to add
     */
    public void add(Event e) {
        queue.add(e);
    }

}
